package fr.moko.main.java.game_Launchers;

import fr.moko.main.java.configuration.Configuration;
import fr.moko.main.java.dev_Mode.Dev_Mode;
import fr.moko.main.java.graphism.Graphism;
import fr.moko.main.java.menus.Main_Menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;



/**
 * <p>Lance les jeux "Recherche +/-" et "Mastermind"</p>
 *
 * <ul>
 *     <li>Recherche +/-</li>
 *     <li>mastermind</li>
 * </ul>
 *
 * @author : Moko
 * @version : 1.0
 */
public class Game_Launcher {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance "Configuration"
    Configuration configuration = new Configuration();

    // Instance "Dev_Mode"
    Dev_Mode dev_Mode = new Dev_Mode();

    // Instance "Main_Menu"
    Main_Menu main_Menu = new Main_Menu();

    // Instance "Graphism"
    Graphism graphism = new Graphism();



    /**
     * Lancement des jeux "Recherche +/-" et "Mastermind"
     */
    public void game_Launcher() {

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



        // Récupération - (boolean) Mode développeur
        boolean boo_DevMode = (boolean) al_Configuration.get(0);
        logger.debug("Récupération - (boolean) Mode développeur : " + boo_DevMode);



        // Récupération - (int) Nombre d'unités des combinaisons du jeu "Recherche +/-"
        int int_Recherche_NumberOfUnities = (int) al_Configuration.get(1);
        logger.debug("Récupération - (int) Nombre d'unités des combinaisons du jeu \"Recherche +/-\" : " + int_Recherche_NumberOfUnities);

        // Récupération - (int) Nombre de chances du jeu "Recherche +/-"
        int int_Recherche_NumberOfChances = (int) al_Configuration.get(4);
        logger.debug("Récupération - (int) Nombre de chances du jeu \"Recherche +/-\" : " + int_Recherche_NumberOfChances);



        // Récupération - (int) Nombre d'unités des combinaisons du jeu "Mastermind"
        int int_Mastermind_NumberOfUnities = (int) al_Configuration.get(2);
        logger.debug("Récupération - (int) Nombre d'unités des combinaisons du jeu \"Mastermind\" : " + int_Mastermind_NumberOfUnities);

        // Récupération - (int) Nombre de lettres utilisées pour le jeu "Mastermind"
        int int_Mastermind_NumberOfLetters = (int) al_Configuration.get(3);
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
        //for (int i = 0; i <= 1; i++) {
            //logger.info("FOR - Lancement boucle infini");



            // Remise à zéro de "i"
            //i = 0;
            //logger.debug("Remise à zéro de \"i\" : " + i);



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
            String array_str_Menu_Choices[] = new String[2];

            array_str_Menu_Choices = main_Menu.run_Main_Menu(array_str_Menu_Choices);

            logger.debug("(String) Choix du jeu : " + array_str_Menu_Choices[0]);
            logger.debug("(String) Choix du mode : " + array_str_Menu_Choices[1]);
        //}



        logger.trace("#####################################");
        logger.trace("<<< END >>> Méthode : game_Launcher()");
        logger.trace("#####################################\n");
    }
}
