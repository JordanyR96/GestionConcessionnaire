   package gestionConcessionnaire;

public class Berline implements Vehicule {
    private String marque;
    private String typeCarroserie;
    private String typeCarburant;
    private String typePortes;
    private String typeMoteur;
    private String typeLumieres;
    private String typePneus;
    private double prix;
    private String etat;
    private String statut;

    public Berline(String marque, String typeCarroserie, String typeCarburant, 
                   String typePortes, String typeMoteur, String typeLumieres, 
                   String typePneus, double prix, String etat, String statut)
    {
        this.marque = marque;
        this.typeCarroserie = typeCarroserie;
        this.typeCarburant = typeCarburant;
        this.typePortes = typePortes;
        this.typeMoteur = typeMoteur;
        this.typeLumieres = typeLumieres;
        this.typePneus = typePneus;
        this.prix = prix;
        this.etat = etat;
        this.statut = statut;
    }

    @Override
    public String getMarque() {
       return marque;
    }

    @Override
    public void setMarque(String marque) {
       this.marque = marque;
    }

    @Override
    public String getTypeCarroserie() {
        return typeCarroserie;
    }

    @Override
    public void setTypeCarroserie(String typeCarroserie) {
       this.typeCarroserie = typeCarroserie;
    }

    @Override
    public String getTypeCarburant() {
        return typeCarburant;
    }

    @Override
    public void setTypeCarburant(String typeCarburant) {
        this.typeCarburant = typeCarburant;
    }

    @Override
    public String getTypePortes() {
        return typePortes;
    }

    @Override
    public void setTypePortes(String typePortes) {
        this.typePortes = typePortes;
    }

    @Override
    public String getTypeMoteur() {
        return typeMoteur;
    }

    @Override
    public void setTypeMoteur(String typeMoteur) {
       this.typeMoteur = typeMoteur;
    }

    @Override
    public String getTypeLumieres() {
        return typeLumieres;
    }

    @Override
    public void setTypeLumieres(String typeLumieres) {
        this.typeLumieres = typeLumieres;
    }

    @Override
    public String getTypePneus() {
        return typePneus;
    }

    @Override
    public void setTypePneus(String typePneus) {
        this.typePneus = typePneus;
    }

    @Override
    public double getPrix() {
        return prix;
    }

    @Override
    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String getEtat() {
       return etat;
    }

    @Override
    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String getStatut() {
        return statut;
    }

    @Override
    public void setStatut(String statut) {
       this.statut = statut;
    }
    
    @Override
    public void changerStatut(String nouveauStatut) {
       this.statut = nouveauStatut;
    }
    
    @Override
    public void afficherInfo() {
        System.out.println("=== BERLINE ===");
        System.out.println("Marque       : " + this.marque);
        System.out.println("Carrosserie  : " + this.typeCarroserie);
        System.out.println("Carburant    : " + this.typeCarburant);
        System.out.println("Portes       : " + this.typePortes);
        System.out.println("Moteur       : " + this.typeMoteur);
        System.out.println("Lumieres     : " + this.typeLumieres);
        System.out.println("Pneus        : " + this.typePneus);
        System.out.println("Prix         : " + this.prix + " Euro");
        System.out.println("Etat         : " + this.etat);
        System.out.println("Statut       : " + this.statut);
    }
    
}
