
package gestionConcessionnaire;

public class Fournisseur {
    private final int id;
    private String nom;
    private String pays;
    private String contact;
    private String adresse;
    private String email;

    public Fournisseur(int id, String nom, String pays, String contact, String adresse, String email) {
        this.id = id;
        this.nom = nom;
        this.pays = pays;
        this.contact = contact;
        this.adresse = adresse;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void afficherInfo() {
        System.out.println("======== Founise ========");
        System.out.println("ID : " + this.id);
        System.out.println("Nom : " + this.nom);
        System.out.println("Pays : " + this.pays);
        System.out.println("Contact : " + this.contact);
        System.out.println("Adresse : " + this.adresse);
        System.out.println("Email : " + this.email);
    }
    
}
