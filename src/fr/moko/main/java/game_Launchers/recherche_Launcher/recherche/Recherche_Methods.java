package fr.moko.main.java.game_Launchers.recherche_Launcher.recherche;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Méthodes attenantes au jeu "Recherche +/-"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Recherche_Methods {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();



    /**
     * Défini la résultat gagnant
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unité utilisées pour les combinaisons
     *
     * @return (String) Résultat gagnant
     */
    public String run_str_WinningResult(int int_Recherche_NumberOfUnities){

        // Initialisation (String) Résultat gagnant
        String str_WinningResult = "";
        logger.info("Initialisation (String) Résultat gagnant");

        // FOR - Incrémentate "=" au résultat gagnant
        logger.info("FOR - Incrémentation \"=\" au résultat gagnant");
        for(int i = 0; i < int_Recherche_NumberOfUnities; i++){

            // Incrémentatation "=" au résultat gagnant
            str_WinningResult += "=";
        }

        logger.debug("Résultat gagnant : " + str_WinningResult);

        return str_WinningResult;
    }
}
