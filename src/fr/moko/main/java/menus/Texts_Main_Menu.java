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
        System.out.println("A quel jeu souhaitez-vous jouer ?\n");

        delay.delay_Text();
        System.out.println("\t- \"R\" pour jouer à \"Recherche +/-\";");
        delay.delay_Text();
        System.out.println("\t- \"M\" pour jouer au \"Mastermind\".\n");

        delay.delay_Text();
        System.out.println("\t(\"Q\" pour quitter)\n");
    }



    /**
     * Affiche la demande de confirmation
     */
    public void display_ETES_VOUS_SUR() {

        delay.delay_Text();
        System.out.println("Êtes-vous sûr ? \"O\" pour confirmer, sinon \"N\".\n");

        delay.delay_Text();
        System.out.println("\t- \"O\" pour confirmer;");
        delay.delay_Text();
        System.out.println("\t- Sinon \"N\".\n");

        delay.delay_Text();
        System.out.println("\t(\"Q\" pour quitter)\n");
    }



    /**
     * Affiche "Faites votre sélection : "
     */
    public void display_FAITES_VOTRE_SELECTION() {

        delay.delay_Text();
        System.out.print("Faites votre sélection : \n");
    }



    /**
     * Affiche "Veuillez faire un choix !"
     */
    public void display_VEUILLEZ_FAIRE_UN_CHOIX() {

        delay.delay_Text();
        System.out.println("Veuillez faire un choix !\n");
    }



    /**
     * Affiche "Vous avez choisi de jouer à "Recherche +/-" !"
     */
    public void display_VOUS_AVEZ_CHOISI_RECHERCHE() {

        delay.delay_Text();
        System.out.println("Vous avez choisi de jouer à \"Recherche +/-\" !\n");
    }



    /**
     * Affiche "Vous avez choisi de jouer au "mastermind !""
     */
    public void display_VOUS_AVEZ_CHOISI_MASTERMIND() {

        delay.delay_Text();
        System.out.println("Vous avez choisi de jouer au \"mastermind\" !\n");
    }



    /**
     * Affiche "Votre choix n'est pas correct !"
     */
    public void display_VOTRE_CHOIX_N_EST_PAS_CORRECT() {

        delay.delay_Text();
        System.out.println("Votre choix n'est pas correct !\n");
    }



    /**
     * Affiche "Veuillez réessayer."
     */
    public void display_VEUILLEZ_REESSAYER() {

        delay.delay_Text();
        System.out.println("Veuillez réessayer.\n");
    }



    /**
     * Affiche le menu des modes
     */
    public void display_Modes_Menu(){

        delay.delay_Text();
        System.out.println("Choisissez le mode :\n");

        delay.delay_Text();
        System.out.println("\t- \"1\" pour jouer en mode \"Challenger\";");
        delay.delay_Text();
        System.out.println("\t- \"2\" pour jouer en mode \"Défense\";");
        delay.delay_Text();
        System.out.println("\t- \"3\" pour jouer en mode \"Duel\".\n");

        delay.delay_Text();
        System.out.println("\t(\"Q\" pour quitter)\n");
    }



    /**
     * Affiche "Vous avez choisi de jouer en mode "Challenger" !"
     */
    public void display_VOUS_AVEZ_CHOISI_DE_JOUER_EN_MODE_CHALLENGER() {

        delay.delay_Text();
        System.out.println("Vous avez choisi de jouer en mode \"Challenger\" !\n");
    }



    /**
     * Affiche "Vous avez choisi de jouer en mode "Défense" !"
     */
    public void display_VOUS_AVEZ_CHOISI_DE_JOUER_EN_MODE_DEFENSE() {

        delay.delay_Text();
        System.out.println("Vous avez choisi de jouer en mode \"Défense\" !\n");
    }



    /**
     * Affiche "Vous avez choisi de jouer en mode "Duel" !"
     */
    public void display_VOUS_AVEZ_CHOISI_DE_JOUER_EN_MODE_DUEL() {

        delay.delay_Text();
        System.out.println("Vous avez choisi de jouer en mode \"Duel\" !\n");
    }
}
