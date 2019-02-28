package fr.moko.main.java.game_Launchers;

import fr.moko.main.java.configuration.Configuration;
import fr.moko.main.java.menus.Main_Menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


/**
 * Lance des jeux "Recherche +/-" et "Mastermind"</p>
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



    /**
     * Lancement des jeux "Recherche +/-" et "Mastermind"
     */
    public void game_Launcher() {

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
    }
}
