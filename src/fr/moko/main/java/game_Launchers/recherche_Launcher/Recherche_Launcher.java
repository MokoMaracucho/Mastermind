package fr.moko.main.java.game_Launchers.recherche_Launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;



/**
 * Lance le jeu "Recherche +/-"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Recherche_Launcher {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();



    /**
     * Lancement du jeu "Recherche +/-"
     *
     * @param al_Configuration : (ArrayList) Valeurs de configuration
     * @param array_str_Menu_Choices : (String[]) Choix du menu principal
     */
    public void recherche_Launcher(ArrayList al_Configuration, String array_str_Menu_Choices[]) {

        // Récupération des valeurs de configuration
        boolean boo_DevMode = (boolean) al_Configuration.get(0);
        int int_Recherche_NumberOfUnities = (int) al_Configuration.get(1);
        int int_Recherche_NumberOfChances = (int) al_Configuration.get(2);
        logger.info("Récupération des valeurs de configuration");
    }
}
