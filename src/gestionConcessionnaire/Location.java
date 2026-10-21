package gestionConcessionnaire;

import java.time.LocalDate;

public class Location {

    private final Client client;
    private final Vehicule vehicule;
    private final LocalDate dateDebut;
    private final int nombreJour;
    private final double prixParJour;

    public Location(Client client, Vehicule vehicule, LocalDate dateDebut, int nombreJour, double prixParJour) {
        if (client == null || vehicule == null || dateDebut == null) {
            throw new IllegalArgumentException("cliyen, veyikil e dat la obligatwa.");
        }
        if (nombreJour <= 0) {
            throw new IllegalArgumentException("Nomb jou an sipoze pi fo ke zero.");
        }
        if (prixParJour <= 0) {
            throw new IllegalArgumentException("Pri pa jou an sipoze pi fo ke zero.");
        }

        this.client = client;
        this.vehicule = vehicule;
        this.dateDebut = dateDebut;
        this.nombreJour = nombreJour;
        this.prixParJour = prixParJour;
    }

    public Client getClient() {
        return client;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public int getNombreJour() {
        return nombreJour;
    }

    public double getPrixParJour() {
        return prixParJour;
    }

    // kalkile pri total
    public double getPrixTotal() {
        return this.nombreJour * this.prixParJour;
    }

    // Pati pou mete fin a la location : la voiture redevient disponible
    public void terminerLocation() {
        if (!"Lwe".equalsIgnoreCase(this.vehicule.getStatut())) {
            this.vehicule.changerStatut("disponible");
            System.out.println("Lokasyon an fini. Veyikil la disponib anko.");
        } else {
            System.out.println("Veyikil sa pa nan lokasyon.");
        }
    }

    public void afficherInfo() {
        System.out.println("======= LOKASYON =======");
        System.out.println("Dat : " + this.dateDebut);
        System.out.println("Kliyan : " + this.client.getNom() + " " + this.client.getPrenom());
        System.out.println("Veyikil : " + this.vehicule.getMarque() + "(" + this.vehicule.getTypeCarroserie() + ")");
        System.out.println("Konbyen jou : " + this.nombreJour);
        System.out.println("Pri pa jou : " + this.prixParJour);
        System.out.println("Pri total : " + getPrixTotal() + " Euro");
    }
}
