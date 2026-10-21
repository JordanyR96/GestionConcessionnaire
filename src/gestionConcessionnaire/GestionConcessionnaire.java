package gestionConcessionnaire;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class GestionConcessionnaire {

    static Scanner sc = new Scanner(System.in);
    static Concessionnaire concession = new Concessionnaire();

    public static void verifierTexteObligatoire(String valeur) throws GestionException {
        if (valeur == null || valeur.trim().isEmpty()) {
            throw new GestionException("Vale a paka rete vid.");
        }
    }

    private static String lireTexteObligatoire(String message) {
        while (true) {
            System.out.println(message);
            String valeur = sc.nextLine();

            try {
                verifierTexteObligatoire(valeur);
                return valeur;
            } catch (GestionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String lireDateObligatoire(String message) {
        while (true) {
            String texte = lireTexteObligatoire(message);

            try {
                LocalDate.parse(texte);
                return texte;
            } catch (DateTimeParseException e) {
                System.out.println("Dat la pa valab. Antre l nan fòma AAAA-MM-JJ.");
            }
        }
    }

    private static String lireDateFacultative(String message) {
        while (true) {
            System.out.print(message);
            String texte = sc.nextLine().trim();

            if (texte.isEmpty()) {
                return "";
            }

            try {
                LocalDate.parse(texte);
                return texte;
            } catch (DateTimeParseException e) {
                System.out.println("Dat la pa valab. Antre l nan fòma AAAA-MM-JJ.");
            }
        }
    }

    public static void main(String[] args) {
        int choix;

        do {
            System.out.println("=================================");
            System.out.println("     JESYON KONSESYONE LA        ");
            System.out.println("=================================");
            System.out.println("1. Client yo");
            System.out.println("2. Personnel yo");
            System.out.println("3. Vehicule yo");
            System.out.println("0. Kite aplikasyon an");

            choix = GestionException.lireChoix();

            switch (choix) {
                case 1:
                    menuClient();
                    break;
                case 2:
                    menuPersonnel();
                    break;
                case 3:
                    menuVehicule();
                    break;
                case 0:
                    System.out.println("Kite aplikasyon an.");
                    break;
                default:
                    System.out.println("Opsyon sa a pa valab");
            }
        } while (choix != 0);
    }

    private static void menuClient() {
        int choix;

        do {
            System.out.println("========= MENI CLIYAN =========");
            System.out.println("1. Anrejistre yon nouvo kliyan");
            System.out.println("2. Lis tout kliyan yo");
            System.out.println("3. Achte comptant");
            System.out.println("4. Achte ak kredi");
            System.out.println("0. Retounen");

            choix = GestionException.lireChoix();

            switch (choix) {
                case 1:
                    enregistrerClient();
                    break;
                case 2:
                    concession.listerClient();
                    break;
                case 3:
                    // Achate a comptant
                    int idxClient = GestionException.lireEntier("Endeks kliyan :");

                    int idxVehicule = GestionException.lireEntier("Endeks veyikil : ");

                    Client c = concession.getClient(idxClient);
                    Vehicule v = concession.getVehicule(idxVehicule);

                    if (c != null && v != null) {
                        boolean achatReussi = c.acheterComptant(v);

                        if (achatReussi) {
                            Vente vente = new Vente(c, v, LocalDate.now(), v.getPrix());
                            concession.ajouterVente(vente);
                        }
                    } else {
                        System.out.println("Endeks pa valab.");
                    }
                    break;

                case 4:
                    // Achte a kredit
                    int idxClient2 = GestionException.lireEntier("Endeks kliyan : ");
                    int idxVehicule2 = GestionException.lireEntier("Endeks veyikil : ");
                    double avance = GestionException.lireDouble("Avans : ");
                    double mensualite = GestionException.lireDouble("Mensyalite : ");

                    Client c2 = concession.getClient(idxClient2);
                    Vehicule v2 = concession.getVehicule(idxVehicule2);

                    if (c2 != null && v2 != null) {
                        boolean creditReussi = c2.acheterCredit(v2, avance, mensualite);

                        if (creditReussi) {
                            Vente vente = new Vente(c2, v2, LocalDate.now(), v2.getPrix());
                            concession.ajouterVente(vente);
                        }
                    } else {
                        System.out.println("Endeks pa valab.");
                    }
                    break;
                case 0:
                    System.out.println("Retounen nan meni principal la.");
                    break;
                default:
                    System.out.println("Opsyon sa a pa valid.");
            }
        } while (choix != 0);
    }

    private static void enregistrerClient() {
        System.out.println("=== NOUVO KLIYAN ===");

        int id = GestionException.lireEntier("ID : ");

        String datePremierAchat = lireTexteObligatoire("Dat premye achat (AAAA-MM-JJ) : ");

        double credit = GestionException.lireDouble("Kredi disponib : ");

        if (credit < 0) {
            System.out.println("Kredi a pa kapab negatif.");
        }

        double balance = GestionException.lireDouble("Balans : ");

        if (balance < 0) {
            System.out.println("Balans lan pa kapab negatif.");
        }

        String nom = lireTexteObligatoire("Non : ");

        String prenom = lireTexteObligatoire("Prenom : ");

        String sexe = lireTexteObligatoire("Sexe (M/F) : ");

        String dateNaissance = lireDateFacultative("Dat nesans (AAAA-MM-JJ) : ");

        Client c = new Client(id, datePremierAchat, credit, balance,
                nom, prenom, sexe, dateNaissance);
        concession.ajouterClient(c);
    }

    private static void menuPersonnel() {
        int choix;

        do {
            System.out.println("========= MENI PERSONEL =========");
            System.out.println("1. Anrejistre yon nouvo anplwaye");
            System.out.println("2. Lis tout anplwaye yo");
            System.out.println("3. Ogmante sale");
            System.out.println("4. Fè yon anplwaye travay");
            System.out.println("5. Chanje non yon anplwaye");
            System.out.println("0. Retounen");

            choix = GestionException.lireChoix();

            switch (choix) {
                case 1:
                    // Créer un employé
                    String nom = lireTexteObligatoire("Non : ");

                    String prenom = lireTexteObligatoire("Prenom : ");

                    String sexe = lireTexteObligatoire("Sexe (M/F) : ");

                    String dateNaissance = lireTexteObligatoire("Dat nesans : ");

                    int id = GestionException.lireEntier("ID : ");

                    String dateEmbauche = lireTexteObligatoire("Dat anboch : ");

                    String fonction = lireTexteObligatoire("Fonksyon : ");

                    double salaire = GestionException.lireDouble("Sale : ");

                    if (salaire <= 0) {
                        System.out.println("Sale a dwe pi gran pase 0.");
                        break;
                    }

                    String horaire = lireTexteObligatoire("Ore travay : ");

                    Personnel p = new Personnel(nom, prenom, sexe, dateNaissance,
                            id, dateEmbauche, fonction, salaire, horaire);
                    concession.ajouterPersonnel(p);
                    break;

                case 2:
                    concession.listerPersonnel();
                    break;

                case 3:
                    int idxAug = GestionException.lireEntier("Endeks anplwaye : ");

                    double pct = GestionException.lireDouble("Pousantaj ogmantasyon (%) : ");

                    Personnel pAug = concession.getPersonnel(idxAug);
                    if (pAug != null) {
                        pAug.augmenterSalaire(pct);
                    } else {
                        System.out.println("Endeks pa valab.");
                    }
                    break;

                case 4:
                    int idxTrav = GestionException.lireEntier("Endeks anplwaye : ");

                    Personnel pTrav = concession.getPersonnel(idxTrav);
                    if (pTrav != null) {
                        pTrav.travailler();
                    } else {
                        System.out.println("Endeks pa valab.");
                    }
                    break;

                case 5:
                    int idxNom = GestionException.lireEntier("Endeks anplwaye : ");

                    String nouveauNom = lireTexteObligatoire("Nouvo non : ");

                    Personnel pNom = concession.getPersonnel(idxNom);
                    if (pNom != null) {
                        pNom.changerNom(nouveauNom);
                    } else {
                        System.out.println("Endeks pa valab.");
                    }
                    break;

                case 0:
                    System.out.println("Retounen nan meni principal la.");
                    break;

                default:
                    System.out.println("Opsyon sa a pa valid.");
            }
        } while (choix != 0);
    }

    private static void menuVehicule() {
        int choix;

        do {
            System.out.println("====== MENI CLIENT ======");
            System.out.println("1. Ajoute yon veyikil");
            System.out.println("2. Lis veyikil yo");
            System.out.println("3. Chache pa pot");
            System.out.println("4. Chache pa mote");
            System.out.println("5. Chache pa limye");
            System.out.println("6. Chache pa carburant");
            System.out.println("7. Vann yon veyikil");
            System.out.println("8. Lwe yon veyikil");
            System.out.println("9. Retire yon veyikil");
            System.out.println("10. Anrejistre yon founise");
            System.out.println("11. Anrejistre yon acha");
            System.out.println("12. Lis acha yo");
            System.out.println("13. Lis lokasyon yo");
            System.out.println("14. Fini yon lokasyon");
            System.out.println("15. Lis vant yo");
            System.out.println("0. Retounen nan meni principal la");

            choix = GestionException.lireChoix();

            switch (choix) {
                case 1:
                    ajouterVehiculeMenu();
                    break;
                case 2:
                    concession.listerVehicule();
                    break;
                case 3:
                    System.out.println("Ki kalite pot ou vle ? ");
                    String portes = sc.nextLine();
                    concession.chercherParPortes(portes);
                    break;
                case 4:
                    System.out.println("Ki kalite mote ou vle ? ");
                    String moteur = sc.nextLine();
                    concession.chercherParMoteur(moteur);
                    break;
                case 5:
                    System.out.println("Ki kalite limye ou vle ? ");
                    String lumieres = sc.nextLine();
                    concession.chercherParLumieres(lumieres);
                    break;
                case 6:
                    System.out.println("Ki kalite carburant ou vle ? ");
                    String carburant = sc.nextLine();
                    concession.chercherParCarburant(carburant);
                    break;
                case 7:

                    int idxVente = GestionException.lireEntier("Bay endeks veyikil la : ");

                    concession.vendreVehicule(idxVente);
                    break;
                case 8:
                    try {
                        int idxClientLocation = GestionException.lireEntier("Endeks kliyan : ");

                        int idxVehiculeLocation = GestionException.lireEntier("Endeks veyikil : ");

                        Client clientLocation = concession.getClient(idxClientLocation);
                        Vehicule vehiculeLocation = concession.getVehicule(idxVehiculeLocation);

                        int nombreJour = GestionException.lireEntier("Konbyenjou : ");

                        double prixParJour = GestionException.lireDouble("Pri pa jou : ");

                        if (clientLocation == null || vehiculeLocation == null) {
                            System.out.println("Endeks kliyan oswa veyikil la pa valab.");
                            break;
                        }

                        Location location = new Location(
                                clientLocation,
                                vehiculeLocation,
                                LocalDate.now(),
                                nombreJour,
                                prixParJour
                        );

                        concession.ajouterLocation(location);

                    } catch (IllegalArgumentException e) {
                        System.out.println("Lokasyon an pa valab : " + e.getMessage());
                    }
                    break;

                case 9:
                    int idxSuppr = GestionException.lireEntier("Bay endeks veyikil la : ");

                    concession.supprimerVehicule(idxSuppr);
                    break;
                case 10:
                    // Enregistrer un fournisseur
                    int idF = GestionException.lireEntier("ID founise : ");

                    String nomF = lireTexteObligatoire("Non founise : ");

                    String pays = lireTexteObligatoire("Peyi : ");

                    String contact = lireTexteObligatoire("kontak : ");

                    System.out.print("Adres : ");
                    String adresse = sc.nextLine();

                    String email = lireTexteObligatoire("Email : ");

                    Fournisseur f = new Fournisseur(idF, nomF, pays, contact, adresse, email);
                    concession.ajouterFournisseur(f);
                    break;

                case 11:
                    // Enregistrer un achat
                    // D'abord, choisir le fournisseur
                    concession.listerFournisseurs();

                    idF = GestionException.lireEntier("Id founise : ");

                    Fournisseur fAchat = concession.chercherFournisseurParId(idF);
                    if (fAchat == null) {
                        System.out.println("Pa gen founise ki gen ID sa a.");
                        break;
                    }

                    // 2. kre  veyicil achta
                    System.out.println("=== KREYE VEYIKIL ACHTE A ===");
                    System.out.println("1. Berline");
                    System.out.println("2. Suv");
                    System.out.println("3. Couper");
                    System.out.println("4. Citadine");
                    System.out.println("5. Camionnette");

                    int typeA;
                    typeA = GestionException.typeVehicule();

                    String marqueA = lireTexteObligatoire("Mak : ");

                    double prixA = GestionException.lireDouble("Pri : ");

                    if (prixA <= 0) {
                        System.out.println("Pri a dwe pi gran pase 0.");
                        break;
                    }

                    String carbA = lireTexteObligatoire("Kabiran : ");

                    String portA = lireTexteObligatoire("Pot : ");

                    String motA = lireTexteObligatoire("Mote : ");

                    String lumA = lireTexteObligatoire("Limye : ");

                    String pneuA = lireTexteObligatoire("Pneus : ");

                    String etaA = lireTexteObligatoire("Eta : ");

                    String staA = lireTexteObligatoire("Stati : ");

                    Vehicule vA = null;
                    switch (typeA) {
                        case 1:
                            vA = new Berline(marqueA, "Berline", carbA, portA, motA, lumA, pneuA, prixA, etaA, staA);
                            break;
                        case 2:
                            vA = new Suv(marqueA, "SUV", carbA, portA, motA, lumA, pneuA, prixA, etaA, staA);
                            break;
                        case 3:
                            vA = new Couper(marqueA, "Couper", carbA, portA, motA, lumA, pneuA, prixA, etaA, staA);
                            break;
                        case 4:
                            vA = new Citadine(marqueA, "Citadine", carbA, portA, motA, lumA, pneuA, prixA, etaA, staA);
                            break;
                        case 5:
                            vA = new Camionnette(marqueA, "Camionnette", carbA, portA, motA, lumA, pneuA, prixA, etaA, staA);
                            break;
                        default:
                            System.out.println("Kalite pa valab.");
                            break;
                    }

                    if (vA != null) {
                        double prixAchat = GestionException.lireDouble("Pri acha (peye founise a) : ");

                        if (prixAchat <= 0) {
                            System.out.println("Pri acha a dwe pi gran pase 0.");
                            break;
                        }

                        try {
                            Achat achat = new Achat(vA, fAchat, LocalDate.now(), prixAchat);
                            concession.ajouterAchat(achat);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Acha pa valid : " + e.getMessage());
                        }
                    }
                    break;

                case 12:
                    concession.listerAchats();
                    break;

                case 13:
                    concession.listerLocation();
                    break;

                case 14:
                    int idxLocationFin = GestionException.lireEntier("Bay endeks lokasyon an : ");
                    concession.terminerLocation(idxLocationFin);
                    break;

                case 15:
                    concession.listerVentes();
                    break;

                case 0:
                    System.out.println("Retounen nan meni principal la.");
                    break;
                default:
                    System.out.println("Opsyon sa pa valid.");
            }
        } while (choix != 0);
    }

    private static void ajouterVehiculeMenu() {
        System.out.println("=== KREYE VEYIKIL ACHTE A ===");
        System.out.println("1. Berline");
        System.out.println("2. Suv");
        System.out.println("3. Couper");
        System.out.println("4. Citadine");
        System.out.println("5. Camionnette");

        int type;
        type = GestionException.ajouterVehicule();

        String marque = lireTexteObligatoire("Mak : ");

        double prix = GestionException.lireDouble("Pri : ");

        if (prix <= 0) {
            System.out.println("Pri a dwe pi gran pase 0.");
            return;
        }

        String carburant = lireTexteObligatoire("kabiran : ");

        String portes = lireTexteObligatoire("Pot : ");

        String moteur = lireTexteObligatoire("Mote : ");

        String lumieres = lireTexteObligatoire("Limye : ");

        String pneus = lireTexteObligatoire("Pneus : ");

        String etat = lireTexteObligatoire("Eta : ");

        String statut = lireTexteObligatoire("Stati : ");

        Vehicule v = null;
        switch (type) {
            case 1:
                v = new Berline(marque, "Berline", carburant, portes, moteur, lumieres, pneus, prix, etat, statut);
                break;
            case 2:
                v = new Suv(marque, "SUV", carburant, portes, moteur, lumieres, pneus, prix, etat, statut);
                break;
            case 3:
                v = new Couper(marque, "Couper", carburant, portes, moteur, lumieres, pneus, prix, etat, statut);
                break;
            case 4:
                v = new Citadine(marque, "Citadine", carburant, portes, moteur, lumieres, pneus, prix, etat, statut);
                break;
            case 5:
                v = new Camionnette(marque, "Camionnette", carburant, portes, moteur, lumieres, pneus, prix, etat, statut);
                break;
            default:
                System.out.println("Kalite pa valab.");
                return;
        }
        concession.ajouterVehicule(v);

    }

}
