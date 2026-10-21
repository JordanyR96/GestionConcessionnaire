package gestionConcessionnaire;

import java.time.LocalDate;

public class Vente {

    private final Client client;
    private final Vehicule vehicule;
    private final LocalDate date;
    private final double prix;

    public Vente(Client client, Vehicule vehicule, LocalDate date, double prix) {
        if (client == null || vehicule == null || date == null) {
            throw new IllegalArgumentException(
                    "Le client, le véhicule et la date sont obligatoires.");
        }
        if (prix <= 0) {
            throw new IllegalArgumentException(
                    "Le prix de vente doit être supérieur à zéro.");
        }
        this.client = client;
        this.vehicule = vehicule;
        this.date = date;
        this.prix = prix;
    }

    public Client getClient() {
        return client;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getPrix() {
        return prix;
    }

    public void afficherInfo() {
        System.out.println("====== VAN ======");
        System.out.println("Dat : " + this.date);
        System.out.println("Kliyen : " + this.client.getNom() + " " + this.client.getPrenom());
        System.out.println("Vehikil : " + this.vehicule.getMarque()
                + "(" + this.vehicule.getTypeCarroserie() + ")");
        System.out.println("Pri : " + this.prix + "Euro");
    }
}
