package fr.moko.main.java.menus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * Lance le menu principal
 *
 * @author : Moko
 * @version : 1.0
 */
public class Main_Menu {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance : "Texts_Main_Menu"
    Texts_Main_Menu texts_Main_Menu = new Texts_Main_Menu();

    // Instance : "Methods_Main_Menu"
    Methods_Main_Menu methods_Main_Menu = new Methods_Main_Menu();



    /**
     * Lancement du menu principal
     *
     * @return : (array String) contenant les choix du menu principal
     */
    public String[] run_Main_Menu(String array_str_Menu_Choices[]) {

        logger.trace("#######################################");
        logger.trace("<<< START >>> Méthode : run_Main_Menu()");
        logger.trace("#######################################");

        // Initialisation (String) Valeur du menu
        String str_Menu_Value = new String();

        // Initialisation (String) Choix du jeu
        String str_Game_Choise = new String();

        // Initialisation (String) Confirmation du choix
        String str_Confirm_Choise = new String();

        // Initialisation (String) Choix du mode
        String str_Mode_Choise = new String();

        // DO {} WHILE - Confirnmation = "N"
        logger.info("DO {} WHILE - Confirnmation = \"N\"");
        do {

            // DO {} WHILE - Le choix du jeu = ""
            logger.info("DO {} WHILE - Le choix du jeu = \"\"");
            do {

                // MàJ - (String) Valeur du menu
                str_Menu_Value = "Games";
                logger.debug("MàJ - (String) Valeur du menu : " + str_Menu_Value);

                // Affichage du menu des jeux
                texts_Main_Menu.display_Games_Menu();

                // Initialisation et récupération - (String) valeur de la chaîne de caractère contenue dans le scanner : "str_Scanner"
                String str_Scanner = methods_Main_Menu.run_Scanner();
                logger.debug("Initialisation et récupération - (String) Valeur de la chaîne de caractère contenue dams le scanner : " + str_Scanner);

                // Initialisation et récupération - (char) lettre correspondant au choix du jeu : "ch_Scanner"
                char ch_Scanner = str_Scanner.toUpperCase().charAt(0);
                logger.debug("Initialisation et récupération - (char) Lettre correspondant au choix du jeu : " + ch_Scanner);

                // Injection - (String) choix du jeu : "str_GameChoise"
                str_Game_Choise = methods_Main_Menu.run_Scanner_Treatment(str_Menu_Value, ch_Scanner);
                logger.debug("Injection - (String) Choix du jeu : " + str_Game_Choise);

            } while (str_Game_Choise.equals(""));

            // DO {} WHILE - La confirmation = ""
            logger.info("DO {} WHILE - La confirmation = \"\"");
            do {

                // MàJ - (String) Valeur du menu
                str_Menu_Value = "Confirm";

                // Affichage confirmation
                texts_Main_Menu.display_ETES_VOUS_SUR();

                // Initialisation et récupération - (String) valeur de la chaîne de caractère contenue dans le scanner : "str_Scanner"
                String str_Scanner = methods_Main_Menu.run_Scanner();
                logger.debug("Initialisation et récupération - (String) Valeur de la chaîne de caractère contenue dams le scanner : " + str_Scanner);

                // Initialisation et récupération - (char) lettre correspondant au choix du jeu : "ch_Scanner"
                char ch_Scanner = str_Scanner.toUpperCase().charAt(0);
                logger.debug("Initialisation et récupération - (char) Lettre correspondant au choix de la confirmation : " + ch_Scanner);

                // Injection - (String) Confirmation
                str_Confirm_Choise = methods_Main_Menu.run_Scanner_Treatment(str_Menu_Value, ch_Scanner);
                logger.debug("Injection - (String) Confirmation : " + str_Confirm_Choise);

            } while (str_Confirm_Choise.equals(""));

        } while (str_Confirm_Choise.equals("N"));




        // Injection des choix du menu principal
        array_str_Menu_Choices[0] = str_Game_Choise;

        logger.trace("#####################################");
        logger.trace("<<< END >>> Méthode : run_Main_Menu()");
        logger.trace("#####################################\n");

        return array_str_Menu_Choices;
    }
}
