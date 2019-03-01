package fr.moko.main.java.game_Launchers.recherche_Launcher;
import fr.moko.main.java.game_Launchers.recherche_Launcher.recherche.Recherche_Methods;

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

    // Instance : "Recherche_Methods"
    Recherche_Methods recherche_Methods = new Recherche_Methods();



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

        // Initialisation (String) Sous-mode en mode "Duel"
        String str_Sub_Mode = new String();

        // Initialisation (String) résultat gagnant
        String str_WinningResult = recherche_Methods.run_str_WinningResult(int_Recherche_NumberOfUnities);
        logger.debug("(String) Résultat gagnant : " + str_WinningResult);
    }
}
