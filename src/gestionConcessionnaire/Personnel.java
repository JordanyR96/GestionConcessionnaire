package gestionConcessionnaire;

public class Personnel extends Personne {
    private final int id;
    private final String date_embauche;
    private String fonction;
    private double salaire;
    private String horaire;

    public Personnel(String nom, String prenom, String sexe, String date_naissance,
                      int id, String date_embauche, String fonction, double salaire, String horaire) {
        super(nom, prenom, sexe, date_naissance);
        this.id = id;
        this.date_embauche = date_embauche;
        this.fonction = fonction;
        this.salaire = salaire;
        this.horaire = horaire;
    }

    public int getId() {
        return id; 
    }

    public String getDate_embauche() {
        return date_embauche;
    }

    public String getFonction() {
        return fonction;
    }
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public double getSalaire() {
        return salaire;
    }
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getHoraire() {
        return horaire;
    }
    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

     
       // Se la kopoteman komanse
    @Override
    public void changerNom(String nouveauNom) {
        setNom(nouveauNom);
        System.out.println("Non an chanje : " + nouveauNom);
    }
    
    public void travailler() {
        System.out.println(getNom() + " " + getPrenom() + " ap travay kom " + this.fonction + ".");
    }
    
    public void augmenterSalaire(double pourcentage) {
        if(pourcentage <= 0) {
            System.out.println("Pousentaj la dwe pi gran pase 0.");
            return;
        }
        double ancienSalaire = this.salaire;
        this.salaire = this.salaire + (this.salaire * pourcentage / 100);
        System.out.println("Sale a ogmente " + ancienSalaire + " a " + this.salaire + "(" + pourcentage + "%)");
    }
    
    public void afficherSalaire() {
        System.out.println("Sale aktyel : " + this.salaire);
    }
        
    @Override
    public void afficherInfo() {
        System.out.println("Anplwaye : " + getNom() + " " + getPrenom());
        System.out.println("Fonksyon : " + this.fonction);
        System.out.println("Ore travay : " + this.horaire);
    }
}