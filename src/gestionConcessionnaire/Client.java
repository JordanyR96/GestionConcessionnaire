package gestionConcessionnaire;

import java.time.LocalDate;

public class Client extends Personne {

    private final int id;
    private final String date_premier_achat;
    private LocalDate dateDernierAchat;
    private double credit;
    private double dette;
    private double balance;
    private int moisRestants;

    public Client(int id, String date_premier_achat,
            double credit, double balance,
            String nom, String prenom, String sexe, String date_naissance) {
        super(nom, prenom, sexe, date_naissance);
        this.id = id;
        this.date_premier_achat = date_premier_achat;
        this.dateDernierAchat = null;
        this.credit = credit;
        this.dette = 0;
        this.balance = balance;
        this.moisRestants = 0;
    }

    public int getId() {
        return id;
    }

    public String getDate_premier_achat() {
        return date_premier_achat;
    }

    public LocalDate getDateDernierAchat() {
        return dateDernierAchat;
    }

    public void setDateDernierAchat(LocalDate dateDernierAchat) {
        this.dateDernierAchat = dateDernierAchat;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDette() {
        return dette;
    }

    public void setDette(double dette) {
        this.dette = dette;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getMoisRestants() {
        return moisRestants;
    }

    public void setMoisRestants(int moisRestants) {
        this.moisRestants = moisRestants;
    }

    public boolean acheterComptant(Vehicule v) {
        // Verifye ke kliyan pa gen det
        if (this.dette > 0) {
            System.out.println("Ou gen yon det ki poko fin peye. Peye premye det la.");
            return false;
        }

        // Verifye si veyikil la disponib
        // Comparazon sa enpeche yon NullPointerException si stati an nil
        if (!"disponible".equalsIgnoreCase(v.getStatut())) {
            System.out.println("Veyikil sa pa disponib (statut : " + v.getStatut() + ").");
            return false;
        }

        // Verifye ke kliyan gen ase lajan
        if (this.balance < v.getPrix()) {
            System.out.println("Ou pa gen ase lajan pou ou achte veyikil sa.");
            return false;
        }

        // Calcil pou dedwi pri a nan balans lan
        this.balance -= v.getPrix();

        // Anrejistre denye acha
        this.dateDernierAchat = LocalDate.now();

        // Chanje stati veyikil la
        v.changerStatut("Vann");

        // Afiche rezime acha a
        System.out.println("======= ACHA COMPTANT REYISI =======");
        System.out.println("Dat acha : " + this.dateDernierAchat);
        System.out.println("Veyikil : " + v.getMarque());
        System.out.println("Pri peye : " + v.getPrix() + " Euro");
        System.out.println("Balans ki rete : " + this.balance + " Euro");

        return true;
    }

    public boolean acheterCredit(Vehicule v, double avance, double mensualite) {
        // fon nou verifye ke cliyen pa gen det
        if (this.dette > 0) {
            System.out.println("Ou gen yon det ki poko fin peye. Peze premye det la.");
            return false;
        }

        // Gade si cliyen gen ase lajan
        if (avance <= 0) {
            System.out.println("Avans la dwe pi gran pase 0.");
            return false;
        }
        if (this.balance < avance) {
            System.out.println("Ou pa gen ase lajan pou avans sa.");
            return false;
        }

        // Gade si vehikil la disponib
        // Comparazon sa enpeche yon NullPointerException si stati an nil
        if (!"disponible".equalsIgnoreCase(v.getStatut())) {
            System.out.println("Veyikil sa pa disponib (statut : " + v.getStatut() + ").");
            return false;
        }

        if (avance >= v.getPrix()) {
            System.out.println("Si avans la kouvri tout pri a, itilize acha comptant.");
            return false;
        }
        // verifye mensyalite li si li valid
        if (mensualite <= 0) {
            System.out.println("Mensyalite a dwe pi gran pase 0.");
            return false;
        }

        // sa se calcil det ak nomb mwa
        //Fonktyon sa pemet ou arodi ale **Math.ceil**
        double resteAPayer = v.getPrix() - avance;
        int nbMois = (int) Math.ceil(resteAPayer / mensualite);

        // Aplike changemen
        this.balance -= avance;
        this.dette = resteAPayer;
        this.moisRestants = nbMois;
        this.dateDernierAchat = LocalDate.now();
        v.changerStatut("vann");

        // Pati pou afiche ke kredi a pase.
        System.out.println("=== ACHA AK KREDI REYISI ===");
        System.out.println("Dat acha : " + this.dateDernierAchat);
        System.out.println("Avans peye : " + avance + " Euro");
        System.out.println("Rès pou peye : " + resteAPayer + " Euro");
        System.out.println("Mensyalite : " + mensualite + " Euro pa mwa");
        System.out.println("Konbyen mwa : " + nbMois);

        return true;
    }

    @Override
    public void changerNom(String nouveauNom) {
        setNom(nouveauNom);
        System.out.println("Non an chanje : " + nouveauNom);
    }

    @Override
    public void afficherInfo() {
        System.out.println("Kliyan : " + getNom() + " " + getPrenom());
        System.out.println("Dat premye achat : " + this.date_premier_achat);
        System.out.println("Dat denye achat : " + (this.dateDernierAchat == null ? "Poko genyen" : this.dateDernierAchat));
        System.out.println("Balans : " + this.balance);
        System.out.println("Kredi disponib : " + this.credit);
        System.out.println("Det : " + this.dette);
        System.out.println("Mwa ki rete : " + this.moisRestants);
    }
}
