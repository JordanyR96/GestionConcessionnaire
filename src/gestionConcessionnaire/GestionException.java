package gestionConcessionnaire;

/**
 *
 * @author Samael
 */
import static gestionConcessionnaire.GestionConcessionnaire.sc;
import java.util.InputMismatchException;

public class GestionException extends Exception {

    public GestionException(String message) {
        super(message);
    }

    //Exception pou choix
    public static int lireChoix() {
        while (true) {
            System.out.println("Chwazi yon opsyon : ");
            try {
                int choix = sc.nextInt();
                sc.nextLine();
                return choix;
            } catch (InputMismatchException exception) {
                System.out.println("Opsyon sa pa valab : mete yon nomb entye.");
                sc.nextLine();
            }
        }
    }

    //Eception pou type veyikil
    public static int typeVehicule() {
        return lireChoix();
    }

    //Eception pou type ajoute yon veyikil
    public static int ajouterVehicule() {
        while (true) {
            System.out.println("Chwazi kalite a : ");
            try {
                int type = sc.nextInt();
                sc.nextLine();
                return type;
            } catch (InputMismatchException exception) {
                System.out.println("Opsyon sa pa valab : mete yon nomb entye.");
                sc.nextLine();
            }
        }
    }

    //Exception pou gere locatyon an
    public static int lireEntier(String message) {
        while (true) {
            System.out.print(message);

            try {
                int valeur = sc.nextInt();
                sc.nextLine();
                return valeur;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Tanpri antre yon nonb antye.");
            }
        }
    }

    public static double lireDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                double valeur = sc.nextDouble();
                sc.nextLine();
                return valeur;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Tanpri antre yon nonb.");
            }
        }
    }
    
   
}
