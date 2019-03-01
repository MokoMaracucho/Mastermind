package fr.moko.main.java.games_Launchers.mastermind_Launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;



/**
 * Lance le jeu "Mastermind"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Mastermind_Launcher {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();



    /**
     * Lancement du jeu "Mastermind"
     *
     * @param al_Configuration : (ArrayList) Valeurs de configuration
     * @param array_str_Menu_Choices : (String[]) Choix du menu principal
     */
    public void mastermind_Launcher(ArrayList al_Configuration, String array_str_Menu_Choices[]) {

        // Récupération des valeurs de configuration
        boolean boo_DevMode = (boolean) al_Configuration.get(0);
        int int_Mastermind_NumberOfUnities = (int) al_Configuration.get(3);
        int int_Mastermind_NumberOfLetters = (int) al_Configuration.get(4);
        int int_Mastermind_NumberOfChances = (int) al_Configuration.get(5);
        logger.info("Récupération des valeurs de configuration");
    }
}
