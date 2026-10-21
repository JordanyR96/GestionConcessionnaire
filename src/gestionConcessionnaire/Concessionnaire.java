package gestionConcessionnaire;

import java.util.ArrayList;

public class Concessionnaire {

    private ArrayList<Vehicule> parc;
    private ArrayList<Client> clients;
    private ArrayList<Personnel> personnel;
    private ArrayList<Achat> achats;
    private ArrayList<Vente> ventes;
    private ArrayList<Location> locations;
    private ArrayList<Fournisseur> fournisseurs;

    // Inityalize liste vide 
    public Concessionnaire() {
        this.parc = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.personnel = new ArrayList<>();
        this.achats = new ArrayList<>();
        this.ventes = new ArrayList<>();
        this.locations = new ArrayList<>();
        this.fournisseurs = new ArrayList<>();
    }

    public void ajouterVehicule(Vehicule v) {
        this.parc.add(v);
        System.out.println("Veyikil la ajoute nan parc la.");
    }

    // Ajouter e lister
    public void listerVehicule() {
        if (this.parc.isEmpty()) {
            System.out.println("Pa gen veyikil nan parc la.");
            return;
        }
        for (Vehicule v : this.parc) {
            v.afficherInfo();
            System.out.println("---");
        }
    }

    public Vehicule getVehicule(int index) {
        if (index >= 0 && index < this.parc.size()) {
            return this.parc.get(index);
        }
        return null;
    }

    //Fe recheche avek kritèr
    public void chercherParPortes(String typePortes) {
        boolean trouve = false;
        for (Vehicule v : this.parc) {
            if (typePortes.equalsIgnoreCase(v.getTypePortes())) {
                v.afficherInfo();
                System.out.println("---");
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Pa gen veyikil ki gen type pote sa.");
        }
    }

    public void chercherParMoteur(String typeMoteur) {
        boolean trouve = false;
        for (Vehicule v : this.parc) {
            if (typeMoteur.equalsIgnoreCase(v.getTypeMoteur())) {
                v.afficherInfo();
                System.out.println("---");
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Pa gen veyikil ki gen type mote sa.");
        }
    }

    public void vendreVehicule(int index) {
        if (index >= 0 && index < this.parc.size()) {
            Vehicule v = this.parc.get(index);
            if (v.getStatut().equalsIgnoreCase("disponible")) {
                v.changerStatut("vann");
                System.out.println("Veyikil sa vann !");
            } else {
                System.out.println("Veyikil sa pa disponib (statut : " + v.getStatut() + ")");
            }
        } else {
            System.out.println("Endeks sa pa valab.");
        }
    }

    public void louerVehicule(int index) {
        if (index >= 0 && index < this.parc.size()) {
            Vehicule v = this.parc.get(index);
            if (v.getStatut().equalsIgnoreCase("disponible")) {
                v.changerStatut("Lwe");
                System.out.println("Veyikil sa lwe !");
            } else {
                System.out.println("Veyikil sa pa disponib (statut : " + v.getStatut() + ")");
            }
        } else {
            System.out.println("Endeks sa pa valab.");
        }
    }

    public void supprimerVehicule(int index) {
        if (index >= 0 && index < this.parc.size()) {
            this.parc.remove(index);
            System.out.println("Veyikil sa retire nan parc la.");
        } else {
            System.out.println("Endèks sa pa valab.");
        }
    }

    public void chercherParLumieres(String typeLumieres) {
        boolean trouve = false;
        for (Vehicule v : this.parc) {
            if (typeLumieres.equalsIgnoreCase(v.getTypeLumieres())) {
                v.afficherInfo();
                System.out.println("---");
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Pa gen veyikil ki gen kalite limyè sa.");
        }
    }

    public void chercherParCarburant(String typeCarburant) {
        boolean trouve = false;
        for (Vehicule v : this.parc) {
            if (typeCarburant.equalsIgnoreCase(v.getTypeCarburant())) {
                v.afficherInfo();
                System.out.println("---");
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Pa gen veyikil ki mache ak kalite carburant sa.");
        }
    }

    //Pati cliyan
    public void ajouterClient(Client c) {
        for (Client clientExistant : this.clients) {
            if (clientExistant.getId() == c.getId()) {
                System.out.println("Cet ID client est déjà utilisé.");
                return;
            }
        }

        this.clients.add(c);
        System.out.println("Cliyan sa ajoute.");
    }

    public void listerClient() {
        if (this.clients.isEmpty()) {
            System.out.println("Poko gen cliyan.");
            return;
        }
        for (Client c : this.clients) {
            c.afficherInfo();
            System.out.println("---");
        }
    }

    public Client getClient(int index) {
        if (index >= 0 && index < this.clients.size()) {
            return this.clients.get(index);
        }
        return null;
    }

    //Pati Pesonel la
    public void ajouterPersonnel(Personnel p) {
        for (Personnel employeExistant : this.personnel) {
            if (employeExistant.getId() == p.getId()) {
                System.out.println("ID sa la deja.");
                return;
            }
        }

        this.personnel.add(p);
        System.out.println("Pesonel lan ajoute.");
    }

    public void listerPersonnel() {
        if (this.personnel.isEmpty()) {
            System.out.println("Poko gen pesonel.");
            return;
        }
        for (Personnel p : this.personnel) {
            p.afficherInfo();
            System.out.println("---");
        }
    }

    public Personnel getPersonnel(int index) {
        if (index >= 0 && index < this.personnel.size()) {
            return this.personnel.get(index);
        }
        return null;
    }

    // Pati fournisseut la
    public void ajouterFournisseur(Fournisseur fournisseur) {
        for (Fournisseur f : this.fournisseurs) {
            if (f.getId() == fournisseur.getId()) {
                System.out.println("Id sa la deja.");
                return;
            }
        }
        this.fournisseurs.add(fournisseur);
        System.out.println("Founise a ajoute.");
    }

    public void listerFournisseurs() {
        if (this.fournisseurs.isEmpty()) {
            System.out.println("Poko gen founise.");
            return;
        }
        for (Fournisseur f : this.fournisseurs) {
            f.afficherInfo();
            System.out.println("---");
        }
    }

//public Fournisseur getFournisseur(int index) {
//    if (index >= 0 && index < this.fournisseurs.size()) {
//        return this.fournisseurs.get(index);
//    }
//    return null;  
//}
    public Fournisseur chercherFournisseurParId(int id) {
        for (Fournisseur fournisseur : this.fournisseurs) {
            if (fournisseur.getId() == id) {
                return fournisseur;
            }
        }
        return null;
    }

//Pati achat
// Sa se pati metod
    public void ajouterAchat(Achat a) {
        this.achats.add(a);
        // Fon mw ajoute veyikil yo nan parc la tou
        this.parc.add(a.getVehicule());
        System.out.println("Acha anrejistre.");
    }

    public void listerAchats() {
        if (this.achats.isEmpty()) {
            System.out.println("Poko gen acha.");
            return;
        }
        for (Achat a : this.achats) {
            a.afficherInfo();
            System.out.println();
        }
    }

    public void ajouterVente(Vente vente) {
        this.ventes.add(vente);
        System.out.println("Vant anrejistre.");
    }

    public void listerVentes() {
        if (this.ventes.isEmpty()) {
            System.out.println("Poko gen vant.");
            return;
        }

        for (Vente vente : this.ventes) {
            vente.afficherInfo();
            System.out.println();
        }
    }

    public void listerLocation() {
        if (this.locations.isEmpty()) {
            System.out.println("Poko gen lokasyon.");
            return;
        }
        for (int i = 0; i < this.locations.size(); i++) {
            System.out.println("Indeks : " + i);
            this.locations.get(i).afficherInfo();
            System.out.println();
        }
    }

    public void ajouterLocation(Location location) {
        Vehicule vehicule = location.getVehicule();

        if (!"disponible".equalsIgnoreCase(vehicule.getStatut())) {
            System.out.println("Veyikil sa pa disponib.");
            return;
        }
        this.locations.add(location);
        vehicule.changerStatut("Lwe");
        System.out.println("Lokasyon anrejistre.");
    }

    public void terminerLocation(int index) {
        if (index < 0 || index >= this.locations.size()) {
            System.out.println("Endeks lokasyon an pa valab.");
            return;
        }
        this.locations.get(index).terminerLocation();
    }
}
