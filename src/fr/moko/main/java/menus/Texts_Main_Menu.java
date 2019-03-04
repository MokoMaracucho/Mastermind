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
        System.out.println("\t- \"M\" pour jouer au \"Mastermind\".\n");

        delay.delay_Text();
        System.out.println("\t(\"Q\" pour quitter)\n");
    }



    /**
     * Affiche la demande de confirmation
     */
    public void display_ETES_VOUS_SUR() {

        delay.delay_Text();
        System.out.println("\nÊtes-vous sûr ? \"O\" pour confirmer, sinon \"N\".\n");

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
        System.out.print("Faites votre sélection : ");
    }



    /**
     * Affiche "Veuillez faire un choix !"
     */
    public void display_VEUILLEZ_FAIRE_UN_CHOIX() {

        delay.delay_Text();
        System.out.println("\nVeuillez faire un choix !\n");
    }



    /**
     * Affiche "Vous avez choisi de jouer à "Recherche +/-" !"
     */
    public void display_VOUS_AVEZ_CHOISI_RECHERCHE() {

        delay.delay_Text();
        System.out.println("\nVous avez choisi de jouer à \"Recherche +/-\" !");
    }



    /**
     * Affiche "Vous avez choisi de jouer au "mastermind_Launcher !""
     */
    public void display_VOUS_AVEZ_CHOISI_MASTERMIND() {

        delay.delay_Text();
        System.out.println("\nVous avez choisi de jouer au \"Mastermind\" !");
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



    /**
     * Affiche le menu des modes
     */
    public void display_Modes_Menu(){

        delay.delay_Text();
        System.out.println("\nChoisissez le mode :\n");

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
        System.out.println("\nVous avez choisi de jouer en mode \"Challenger\" !");
    }



    /**
     * Affiche "Vous avez choisi de jouer en mode "Défense" !"
     */
    public void display_VOUS_AVEZ_CHOISI_DE_JOUER_EN_MODE_DEFENSE() {

        delay.delay_Text();
        System.out.println("\nVous avez choisi de jouer en mode \"Défense\" !");
    }



    /**
     * Affiche "Vous avez choisi de jouer en mode "Duel" !"
     */
    public void display_VOUS_AVEZ_CHOISI_DE_JOUER_EN_MODE_DUEL() {

        delay.delay_Text();
        System.out.println("\nVous avez choisi de jouer en mode \"Duel\" !");
    }



    /**
     * Affiche "C'est parti pour jouer ... en mode ..."
     *
     * @param array_str_MenuChoices : (array String) Choix du menu principal
     */
    public void display_C_EST_PARTI_POUR(String array_str_MenuChoices[]) {

        String str_A_OU_AU = run_A_OU_AU(array_str_MenuChoices);

        delay.delay_Text();
        System.out.println("\nC'est parti pour jouer " + str_A_OU_AU + " \"" + array_str_MenuChoices[0] + "\" en mode \"" + array_str_MenuChoices[1] + "\" !");
    }

    /**
     * Retourne "à" ou "au"
     *
     * @param array_str_MenuChoices : (array String) Choix du menu principal
     *
     * @return : (String) "à" ou "au"
     */
    public String run_A_OU_AU(String array_str_MenuChoices[]) {

        String str_A_OU_AU = new String();

        switch (array_str_MenuChoices[0]){

            case "Recherche +/-" :

                str_A_OU_AU = "à";

                break;

            case "Mastermind" :

                str_A_OU_AU = "au";

                break;
        }

        return str_A_OU_AU;
    }
}
