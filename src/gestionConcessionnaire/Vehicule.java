
package gestionConcessionnaire;

public interface Vehicule {
    // Pou make la
    String getMarque();
    void setMarque(String marque);
    // tip carosri (Berline, SUV, Coupé, Citadine, Camionnette)
    String getTypeCarroserie();
    void setTypeCarroserie(String typeCarroserie);
     // Carburant
    String getTypeCarburant();
    void setTypeCarburant(String typeCarburant);
    // Pote
    String getTypePortes();
    void setTypePortes(String typePortes);
    // Mote
    String getTypeMoteur();
    void setTypeMoteur(String typeMoteur);
    // Lumieres
    String getTypeLumieres();
    void setTypeLumieres(String typeLumieres);
    // caoutchouc
    String getTypePneus();
    void setTypePneus(String typePneus);
    double getPrix();
    void setPrix(double prix);
     // Eat machine lan (neuf / occasion / endommage)
    String getEtat();
    void setEtat(String etat);
    // Statut li ka (disponible / vendu / loué)
    String getStatut();
    void setStatut(String statut);
    // aktyon 
    void changerStatut(String nouveauStatut);
    void afficherInfo();
    
}
