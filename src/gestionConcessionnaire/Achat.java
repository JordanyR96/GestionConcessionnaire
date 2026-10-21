package gestionConcessionnaire;

import java.time.LocalDate;

public class Achat {

    private final Vehicule vehicule;
    private final Fournisseur fournisseur;
    private final LocalDate date;
    private final double prixAchat;

    public Achat(Vehicule vehicule, Fournisseur fournisseur, LocalDate date, double prixAchat) {
        if (vehicule == null || fournisseur == null || date == null) {
            throw new IllegalArgumentException(
                    "Veyikil, founise e dat la ogligatwa.");
        }

        if (prixAchat <= 0) {
            throw new IllegalArgumentException("Le prix d'achat doit être supérieur à zéro.");
        }

        this.vehicule = vehicule;
        this.fournisseur = fournisseur;
        this.date = date;
        this.prixAchat = prixAchat;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void afficherInfo() {
        System.out.println("======== ACHA ========");
        System.out.println("Dat : " + this.date);
        System.out.println("Veyikil : " + this.vehicule.getMarque()
                + "(" + this.vehicule.getTypeCarroserie() + ")");
        System.out.println("Fournisseur : " + this.fournisseur.getNom());
        System.out.println("Peyi : " + this.fournisseur.getPays());
        System.out.println("Pri acha : " + this.prixAchat + " Euro");
    }
}
