package fr.moko.main.java.games_Launchers.Games;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * Méthodes attenantes aux jeux
 *
 * @author : Moko
 * @version : 1.0
 */
public class Methods_Games {

    // Instance "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance : "Texts_Games"
    Texts_Games texts_Games = new Texts_Games();



    /**
     * Lance le scanner pour la combinaison
     *
     * @param array_str_Menu_Choices : (array String) Choix du menu principal
     * @param str_SubMode : (String) Sous-mode si en mode "Duel"
     *
     * @return : Scanner contenant la combinaison
     */
    public Scanner run_sc_Combination(String array_str_Menu_Choices[], String str_SubMode) {

        // SWITCH - Mode des jeux
        logger.info("SWITCH - Mode des jeux");
        switch (array_str_Menu_Choices[1]) {

            // CASE - Mode "Challenger"
            case "Challenger" :
                logger.info("CASE - Mode \"Challenger\"");

                // Affiche "Faites votre proposition :"
                texts_Games.display_FAITES_VOTRE_PROPOSITION();

                break;

            // CASE - Mode "Défense"
            case "Défense":
                logger.info("CASE - Mode \"Défense\"");

                // Affiche "Saisissez votre combinaison :"
                texts_Games.display_SAISISSEZ_VOTRE_COMBINAISON();

                break;

            // CASE - Mode "Duel"
            case "Duel" :
                logger.info("CASE - Mode \"Duel\"");

                // SWITCH - Le sous-mode en mode "Duel"
                logger.info("SWITCH - Le sous-mode en mode \"Duel\"");
                switch (str_SubMode){

                    // CASE - Mode "Challenger"
                    case "Challenger" :
                        logger.info("CASE - Mode \"Challenger\"");

                        // Affiche "Faites votre proposition :"
                        texts_Games.display_FAITES_VOTRE_PROPOSITION();

                        break;

                    case "Défense" :

                        // Affiche "Saisissez votre combinaison :"
                        texts_Games.display_SAISISSEZ_VOTRE_COMBINAISON();

                        break;
                }
                break;
        }

        // Instance "Scanner"
        Scanner sc_Combination = new Scanner(System.in);

        return sc_Combination;
    }
}
