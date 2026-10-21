package gestionConcessionnaire;

public abstract class Personne {
    private String nom;
    private String prenom;
    private String sexe;
    private String date_naissance;

    public Personne(){}

    public Personne(String nom, String prenom, String sexe, String date_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.date_naissance = date_naissance;
    }

    public String getNom() { 
        return nom; 
    }
    public void setNom(String nom) { 
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getDate_naissance() {
        return date_naissance;
    }
    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    // Montre enfòmasyon jeneral moun nan — chak sou-klas dwe defini pwòp vèsyon pa li
    public abstract void afficherInfo();
    public abstract void changerNom(String nouveauNom);
}