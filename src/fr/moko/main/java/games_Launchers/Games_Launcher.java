package fr.moko.main.java.games_Launchers;

import fr.moko.main.java.configuration.Configuration;
import fr.moko.main.java.dev_Mode.Dev_Mode;
import fr.moko.main.java.games_Launchers.Games.Texts_Games;
import fr.moko.main.java.games_Launchers.mastermind_Launcher.Mastermind_Launcher;
import fr.moko.main.java.games_Launchers.recherche_Launcher.Recherche_Launcher;
import fr.moko.main.java.graphism.Graphism;
import fr.moko.main.java.menus.Main_Menu;

import fr.moko.main.java.menus.Methods_Main_Menu;
import fr.moko.main.java.menus.Texts_Main_Menu;

import org.apache.logging.log4j.*;

import java.util.ArrayList;



/**
 * <p>Lance les jeux "Recherche +/-" et "Mastermind"</p>
 *
 * <ul>
 *     <li>Recherche +/-</li>
 *     <li>Mastermind</li>
 * </ul>
 *
 * @author : Moko
 * @version : 1.0
 */
public class Games_Launcher {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance "Configuration"
    Configuration configuration = new Configuration();

    // Instance "Dev_Mode"
    Dev_Mode dev_Mode = new Dev_Mode();

    // Instance "Main_Menu"
    Main_Menu main_Menu = new Main_Menu();

    // Instance "Texts_Games"
    Texts_Games texts_Games = new Texts_Games();

    // Instance "Texts_Main_Menu"
    Texts_Main_Menu texts_Main_Menu = new Texts_Main_Menu();

    // Instance "Methods_Main_Menu"
    Methods_Main_Menu methods_Main_Menu = new Methods_Main_Menu();

    // Instance "Graphism"
    Graphism graphism = new Graphism();



    /**
     * Lancement des jeux "Recherche +/-" et "Mastermind"
     *
     * @param boo_DevMode : (boolean) En mode développeur
     */
    public void games_Launcher(boolean boo_DevMode) {

        logger.trace("#######################################");
        logger.trace("<<< START >>> Méthode : game_Launcher()");
        logger.trace("#######################################");

        logger.trace("######################################################################################");
        logger.trace("<<< 1st Part >>> Méthode : game_Launcher() : Récupération des valeurs de configuration");
        logger.trace("######################################################################################");

        // Initialisation (ArrayList) : "al_PropertiesValue"
        ArrayList al_Configuration = new ArrayList();



        // Récupération (ArrayList) valeurs de configurations dans "config.properties" : "al_PropertiesValue"
        al_Configuration = configuration.get_Configuration(al_Configuration);



        // Récupération - (int) Nombre d'unités des combinaisons du jeu "Recherche +/-"
        int int_Recherche_NumberOfUnities = (int) al_Configuration.get(1);
        logger.debug("Récupération - (int) Nombre d'unités des combinaisons du jeu \"Recherche +/-\" : " + int_Recherche_NumberOfUnities);

        // Récupération - (int) Nombre de chances du jeu "Recherche +/-"
        int int_Recherche_NumberOfChances = (int) al_Configuration.get(2);
        logger.debug("Récupération - (int) Nombre de chances du jeu \"Recherche +/-\" : " + int_Recherche_NumberOfChances);



        // Récupération - (int) Nombre d'unités des combinaisons du jeu "Mastermind"
        int int_Mastermind_NumberOfUnities = (int) al_Configuration.get(3);
        logger.debug("Récupération - (int) Nombre d'unités des combinaisons du jeu \"Mastermind\" : " + int_Mastermind_NumberOfUnities);

        // Récupération - (int) Nombre de lettres utilisées pour le jeu "Mastermind"
        int int_Mastermind_NumberOfLetters = (int) al_Configuration.get(4);
        logger.debug("Récupération - (int) Nombre de lettres utilisées pour le jeu \"Mastermind\" : " + int_Mastermind_NumberOfLetters);

        // Récupération - (int) Nombre de chances du jeu "Mastermind"
        int int_Mastermind_NumberOfChances = (int) al_Configuration.get(5);
        logger.debug("Récupération - (int) Nombre de chances du jeu \"Mastermind\" : " + int_Mastermind_NumberOfChances);



        logger.trace("#########################################################");
        logger.trace("<<< 2nd Part >>> Méthode : game_Launcher() : Présentation");
        logger.trace("#########################################################");

        // Initialisation - (boolean) Premier tour
        boolean boo_FirstRound = true;
        logger.debug("Initialisation - (boolean) Premier tour : " + boo_FirstRound);



        // FOR - Lancement boucle infini
        logger.info("FOR - Lancement boucle infini");
        for (int i = 0; i <= 1; i++) {



            // Remise à zéro de "i"
            i = 0;
            logger.debug("Remise à zéro de \"i\" : " + i);



            // IF - Premier tour
            if (boo_FirstRound) {
                logger.info("IF - Premier tour");

                // Affichage "MOKO GAMES INDUSTRY"
                graphism.display_MOKO_GAMES_INDUSTRY();

                // MàJ - (boolean) Premier tour
                boo_FirstRound = false;
                logger.debug("MàJ - (boolean) Premier tour : " + boo_FirstRound);

                // SI - En mode développeur
                if (boo_DevMode) {

                    // Affichage "Vous êtes en mode développeur"
                    dev_Mode.display_VOUS_ETES_EN_MODE_DEVELOPPEUR();
                }
            }



            logger.trace("###########################################################");
            logger.trace("<<< 3rd Part >>> Méthode : game_Launcher() : Menu principal");
            logger.trace("###########################################################");

            // Initialisation et récupération (array String) Choix du menu principal
            String array_str_Main_Menu_Choices[] = new String[2];

            array_str_Main_Menu_Choices = main_Menu.run_Main_Menu(array_str_Main_Menu_Choices);



            logger.trace("################################################################################################");
            logger.trace("<<< 4th Part >>> Méthode : game_Launcher() : Lance du jeu \"Recherche +/-\" ou du jeu \"Mastermind\"");
            logger.trace("################################################################################################");

            // SWITCH - Choix du jeu
            logger.info("SWITCH - Choix du jeu");
            switch (array_str_Main_Menu_Choices[0]) {

                // CASE - Mode  "Recherche +/-"
                case "Recherche +/-":
                    logger.info("CASE - Mode  \"Recherche +/-\"");

                    // Instance "Recherche_Launcher"
                    Recherche_Launcher recherche_Launcher = new Recherche_Launcher();
                    logger.info("Instance \"recherchePlusMoins\"");

                    // Lancement du jeu "Recherche +/-"
                    recherche_Launcher.recherche_Launcher(boo_DevMode, al_Configuration, array_str_Main_Menu_Choices);
                    logger.info("Lancement du jeu \"Recherche +/-\"");

                    break;

                // CASE - Mode  "Mastermind"
                case "Mastermind":
                    logger.info("CASE - Mode  \"Mastermind\"");

                    // Instance "Mastermind_Launcher"
                    Mastermind_Launcher mastermind_Launcher = new Mastermind_Launcher();
                    logger.info("Instance \"Mastermind\"");

                    // Lancement du jeu "Mastermind"
                    mastermind_Launcher.mastermind_Launcher(boo_DevMode, al_Configuration, array_str_Main_Menu_Choices);
                    logger.info("Lancement du jeu \"Mastermind\"");

                    break;
            }



            logger.trace("####################################################################");
            logger.trace("<<< 5th Part >>> Méthode : game_Launcher() : Voulez-vous continuer ?");
            logger.trace("####################################################################");

            texts_Games.display_VOULEZ_VOUS_CONTINUER();

            String str_Scanner = methods_Main_Menu.run_Scanner();

            String str_Main_Menu_Value = "End";

            char ch_Scanner = str_Scanner.toUpperCase().charAt(0);

            methods_Main_Menu.run_Scanner_Treatment(str_Main_Menu_Value, ch_Scanner);
        }

        logger.trace("#####################################");
        logger.trace("<<< END >>> Méthode : game_Launcher()");
        logger.trace("#####################################\n");
    }
}
