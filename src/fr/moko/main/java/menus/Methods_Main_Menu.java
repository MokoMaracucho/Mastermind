package fr.moko.main.java.menus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;



/**
 * Méthodes attenantes aux menus
 *
 * @author : Moko
 * @version : 1.0
 */
public class Methods_Main_Menu {

    // Instance "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance : "Texts_Main_Menu"
    Texts_Main_Menu texts_Main_Menu = new Texts_Main_Menu();



    /**
     * Lancement scanner
     *
     * @return : (String) Contenu du scanner
     */
    public String run_Scanner(){

        // INITIALISATION (String) pour texte conten dans scanner : "str_Scanner"
        String str_Scanner = new String();

        // Instance "Scanner"
        Scanner sc_Scanner = new Scanner(System.in);

        // Initialisation (boolean) si le scanner est vide
        boolean boo_EmptyScanner = true;
        logger.debug("Initialisation (boolean) si le scanner est vide : " + boo_EmptyScanner);

        // DO {} WHILE - Si le scanner est vide
        logger.info("DO {} WHILE - Si le scanner est vide");
        do {

            // MàJ - (boolean) Scanner vide
            boo_EmptyScanner = false;
            logger.debug("MàJ - (boolean) Scanner vide : " + boo_EmptyScanner);

            // Affichage "Faites votre sélection : "
            texts_Main_Menu.display_FAITES_VOTRE_SELECTION();

            // Récupération (String) contenu du scanner
            str_Scanner = sc_Scanner.nextLine();
            logger.info("Récupération (String) contenu du scanner");

            // IF - Le scanner est vide
            if (str_Scanner.equals("")) {
                logger.info("IF - Le scanner est vide");

                // MàJ - (boolean) Scanner vide
                boo_EmptyScanner = true;
                logger.debug("MàJ - (boolean) Scanner vide : " + boo_EmptyScanner);

                // Affichage "Veuillez faire un choix !"
                texts_Main_Menu.display_VEUILLEZ_FAIRE_UN_CHOIX();
            }
        } while (boo_EmptyScanner);

        return str_Scanner;
    }



    /**
     * Traitement du contenu du scanner
     *
     * @param str_MenuValue : (String) valeur du menu
     * @param ch_Scanner : (char) caractère récupéré du scanner
     *
     * @return : (String) Choix
     */
    public String run_Scanner_Treatment(String str_MenuValue, char ch_Scanner){

        // Initialisation (String) Choix
        String str_Choise = new String();

        // SWITCH - (String) Valeur du menu
        logger.info("SWITCH - (String) Valeur du menu");
        switch (str_MenuValue) {

            // CASE - "Games"
            case "Games":
                logger.info("CASE - \"Games\"");

                // SWITCH - (char) Caractére récupéré du scanner
                logger.info("SWITCH - (char) Caractére récupéré du scanner");
                switch (ch_Scanner) {

                    // CASE - 'R'
                    case 'R':
                        logger.info("CASE - 'R'");

                        // Affiche "Vous avez choisi le jeu "Recherch +/-"
                        texts_Main_Menu.display_VOUS_AVEZ_CHOISI_RECHERCHE();

                        // MàJ - (String) Choix
                        str_Choise = "Recherche +/-";
                        logger.debug("MàJ - (String) Choix : " + str_Choise);

                        break;

                    // CASE - 'M'
                    case 'M':

                        // Affiche "Vous avez choisi le jeu "Mastermind"
                        texts_Main_Menu.display_VOUS_AVEZ_CHOISI_MASTERMIND();

                        // MàJ - (String) Choix
                        str_Choise = "Mastermind";
                        logger.debug("MàJ - (String) Choix : " + str_Choise);

                        break;

                    // CASE - 'Q'
                    case 'Q':

                        // EXIT - Sortie du jeu
                        System.exit(0);
                        logger.warn("EXIT - Sortie du jeu");

                        break;

                    // DEFAULT
                    default:

                        // Affiche "Votre choix n'est pas correct !"
                        texts_Main_Menu.display_VOTRE_CHOIX_N_EST_PAS_CORRECT();

                        // Affiche "Veuillez réessayer."
                        texts_Main_Menu.display_VEUILLEZ_REESSAYER();

                        break;
                }
                break;

            // CASE - "Comfirm"
            case "Confirm" :
                logger.info("CASE - \"Comfirm\"");

                // SWITCH - (char) Caractére récupéré du scanner
                logger.info("SWITCH - (char) Caractére récupéré du scanner");
                switch (ch_Scanner){

                    // CASE - 'O'
                    case 'O' :
                        logger.info("CASE - 'O'");

                        // MàJ - (String) Choix
                        str_Choise = "O";
                        logger.debug("MàJ - (String) Choix : " + str_Choise);

                        break;

                    // CASE - 'N'
                    case 'N' :
                        logger.info("CASE - 'N'");

                        // MàJ - (String) Choix
                        str_Choise = "N";
                        logger.debug("MàJ - (String) Choix : " + str_Choise);

                        break;

                    // CASE - 'Q'
                    case 'Q' :
                        logger.info("CASE - 'Q'");

                        // EXIT - Sortie du jeu
                        System.exit(0);
                        logger.warn("EXIT - Sortie du jeu");

                        break;

                    // DEFAULT
                    default :
                        logger.info("DEFAULT");

                        // Affiche "Votre choix n'est pas correct !"
                        texts_Main_Menu.display_VOTRE_CHOIX_N_EST_PAS_CORRECT();

                        // Affiche "Veuillez réessayer."
                        texts_Main_Menu.display_VEUILLEZ_REESSAYER();

                        break;
                }
                break;

            // CASE - "Modes"
            case "Modes" :
                logger.info("CASE - \"Modes\"");

                // SWITCH - (char) Caractére récupéré du scanner
                logger.info("SWITCH - (char) Caractére récupéré du scanner");
                switch (ch_Scanner){

                    // CASE - '1'
                    case '1' :
                        logger.info("CASE - '1'");

                        texts_Main_Menu.display_VOUS_AVEZ_CHOISI_DE_JOUER_EN_MODE_CHALLENGER();

                        // MàJ - (String) Choix
                        str_Choise = "Challenger";
                        logger.debug("MàJ - (String) Choix : " + str_Choise);

                        break;

                    // CASE - '2'
                    case '2':
                        logger.info("CASE - '2'");

                        texts_Main_Menu.display_VOUS_AVEZ_CHOISI_DE_JOUER_EN_MODE_DEFENSE();

                        // MàJ - (String) Choix
                        str_Choise = "Défense";
                        logger.debug("MàJ - (String) Choix : " + str_Choise);

                        break;

                    // CASE - '3'
                    case '3':
                        logger.info("CASE - '3'");

                        texts_Main_Menu.display_VOUS_AVEZ_CHOISI_DE_JOUER_EN_MODE_DUEL();

                        // MàJ - (String) Choix
                        str_Choise = "Duel";
                        logger.debug("MàJ - (String) Choix : " + str_Choise);

                        break;

                    // CASE - 'Q'
                    case 'Q' :
                        logger.info("CASE - 'Q'");

                        // EXIT - Sortie du jeu
                        System.exit(0);
                        logger.warn("EXIT - Sortie du jeu");

                        break;

                    // DEFAULT
                    default :
                        logger.info("DEFAULT");

                        // Affiche "Votre choix n'est pas correct !"
                        texts_Main_Menu.display_VOTRE_CHOIX_N_EST_PAS_CORRECT();

                        // Affiche "Veuillez réessayer."
                        texts_Main_Menu.display_VEUILLEZ_REESSAYER();

                        break;
                }
                break;
        }

        return str_Choise;
    }
}
