package fr.moko.main.java.menus;

import fr.moko.main.java.delay.Delay;



/**
 * Textes attenants aux menus
 *
 * @author : Moko
 * @version 1.0
 */
public class Texts_Main_Menu {

    // Instances "Delay"
    Delay delay = new Delay();



    /**
     * Affiche le menu des jeux
     */
    public void display_Games_Menu() {

        delay.delay_Text();
        System.out.println("\nA quel jeu souhaitez-vous jouer ?\n");

        delay.delay_Text();
        System.out.println("\t- \"R\" pour jouer à \"Recherche +/-\";");
        delay.delay_Text();
        System.out.println("\t- \"M\" pour jouer au \"Mastermind\".");

        delay.delay_Text();
        System.out.println("\n\t(\"Q\" pour quitter)");
    }



    /**
     * Affiche la demande de confirmation
     */
    public void display_ETES_VOUS_SUR() {

        delay.delay_Text();
        System.out.println("\nÊtes-vous sûr ? \"O\" pour confirmer, sinon \"N\".");

        delay.delay_Text();
        System.out.println("\n\t- \"O\" pour confirmer;");
        delay.delay_Text();
        System.out.println("\t- Sinon \"N\".");

        delay.delay_Text();
        System.out.println("\n\t(\"Q\" pour quitter)");
    }



    /**
     * Affiche "Faites votre sélection : "
     */
    public void display_FAITES_VOTRE_SELECTION() {

        delay.delay_Text();
        System.out.print("\nFaites votre sélection : ");
    }



    /**
     * Affiche "Veuillez faire un choix !"
     */
    public void display_VEUILLEZ_FAIRE_UN_CHOIX() {

        delay.delay_Text();
        System.out.println("\nVeuillez faire un choix !");
    }



    /**
     * Affiche "Vous avez choisi de jouer à "Recherche +/-" !"
     */
    public void display_VOUS_AVEZ_CHOISI_RECHERCHE() {

        delay.delay_Text();
        System.out.println("\nVous avez choisi de jouer à \"Recherche +/-\" !");
    }



    /**
     * Affiche "Vous avez choisi de jouer au "mastermind !""
     */
    public void display_VOUS_AVEZ_CHOISI_MASTERMIND() {

        delay.delay_Text();
        System.out.println("\nVous avez choisi de jouer au \"mastermind\" !");
    }



    /**
     * Affiche "Votre choix n'est pas correct !"
     */
    public void display_VOTRE_CHOIX_N_EST_PAS_CORRECT() {

        delay.delay_Text();
        System.out.println("\nVotre choix n'est pas correct !");
    }



    /**
     * Affiche "Veuillez réessayer."
     */
    public void display_VEUILLEZ_REESSAYER() {

        delay.delay_Text();
        System.out.println("\nVeuillez réessayer.");
    }
}
