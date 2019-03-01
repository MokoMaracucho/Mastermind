package fr.moko.main.java.games_Launchers.recherche_Launcher.recherche;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 *  Textes attenants aux méthodes du jeu "Recherche +/-"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Methods_Texts_Recherche {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();



    /**
     * Génère le nombre maximum
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     *
     * @return (String) Nombre maximum
     */
    public String run_str_NumberMax(int int_Recherche_NumberOfUnities){

        // Initialisation (String) Nombre maximum
        String str_NumberMax = "";

        // FOR - le nombre d'unité de la combinaison
        logger.info("FOR - le numbre d'unité de la combinaison");
        for (int i = 0; i < int_Recherche_NumberOfUnities; i++) {

            // Incrémentation de "9"
            str_NumberMax += "9";
        }

        logger.debug("(String) Nombre maximum : " + str_NumberMax);

        return str_NumberMax;
    }
}
