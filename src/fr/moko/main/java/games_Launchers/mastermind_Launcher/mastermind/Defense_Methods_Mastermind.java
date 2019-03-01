package fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;



/**
 * Méthodes attenantes à la défense du "Mastermind"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Defense_Methods_Mastermind {

    // Instance "Logger"
    static Logger logger = LogManager.getRootLogger();



    /**
     * Récupération de l'index de la lettre
     *
     * @param int_Mastermind_NumberOfLetters : (int) Nombre de lettres utilisées pour les combinaisons
     * @param al_Mastermind_Defense : (ArrayList) Données défense
     * @param ch_Letter : (char) Lettre séectionnée
     *
     * @return : (int) L'index de la lettre
     */
    public int run_int_IndexOfLetter(int int_Mastermind_NumberOfLetters, ArrayList al_Mastermind_Defense, char ch_Letter) {

        logger.trace("###############################################");
        logger.trace("<<< START >>> Méthode : run_int_IndexOfLetter()");
        logger.trace("###############################################");

        // Initialisation (int) Index de la lettre sélectionnée
        int int_IndexOfLetter = 0;
        logger.debug("Initialisation (int) Index de la lettre sélectionnée");

        // Récupération (char[]) Lettres sélectionnée pour le "Mastermind"
        char array_ch_SelectedLetters[] = (char[]) al_Mastermind_Defense.get(0);
        logger.debug("Récupération (char[]) Lettres sélectionnée pour le \"Mastermind\" : " + Arrays.toString(array_ch_SelectedLetters));

        // FOR - Chaque lettre sélectionnée pour le "Mastermind"
        logger.info("FOR - Chaque lettre sélectionnée pour le \"Mastermind\"");
        for (int j = 0; j < int_Mastermind_NumberOfLetters; j++) {

            // IF - Lettre sélectionnée = Lettre sélectionnée pour le "Mastermind"
            if (ch_Letter == array_ch_SelectedLetters[j]) {
                logger.info("IF - Lettre sélectionnée = Lettre sélectionnée pour le \"Mastermind\"");

                // MàJ - (int) Index de la lettre sélectionnée
                int_IndexOfLetter = j;
                logger.debug("Index de la lettre");

                break;
            }
        }
        logger.trace("#############################################");
        logger.trace("<<< END >>> Méthode : run_int_IndexOfLetter()");
        logger.trace("#############################################\n");

        return int_IndexOfLetter;
    }



    /**
     * Défini la lettre suivante
     *
     * @param int_Mastermind_NumberOfLetters : (int) Nombre de lettres utilisées pour les combinaisons
     * @param array_ch_SelectedLetters : (char[]) Lettres sélectionnées pour le jeu "Mastermind"
     * @param int_IndexInitialLetter : (int) Index de la lettre initiale
     * @param ch_NextLetter : (char) Lettre suivante
     *
     * @return : (char) La lettre suivante
     */
    public char run_NextLetter(int int_Mastermind_NumberOfLetters, char array_ch_SelectedLetters[], int int_IndexInitialLetter, char ch_NextLetter) {

        logger.trace("########################################");
        logger.trace("<<< START >>> Méthode : run_NextLetter()");
        logger.trace("########################################");

        // IF - "int_IndexInitialLetter" < Que le nombre de lettres sélectionnées pour le "Mastermind"
        if (int_IndexInitialLetter < int_Mastermind_NumberOfLetters - 1) {
            logger.info("IF - \"int_IndexInitialLetter\" < Que le nombre de lettres sélectionnées pour le \"Mastermind\"");

            // MàJ - (char) Lettre sélectionnée
            ch_NextLetter = array_ch_SelectedLetters[int_IndexInitialLetter + 1];
            logger.debug("MàJ - (char) Lettre sélectionnée : " + ch_NextLetter);
        }
        // ELSE - "int_IndexInitialLetter" > Que le nombre de lettres sélectionnées pour le "Mastermind"
        else {
            logger.info("ELSE - \"int_IndexInitialLetter\" > Que le nombre de lettres sélectionnées pour le \"Mastermind\"");

            int j = int_IndexInitialLetter - int_Mastermind_NumberOfLetters;

            // MàJ - (char) Lettre sélectionnée
            ch_NextLetter = array_ch_SelectedLetters[j + 1];
            logger.debug("MàJ - (char) Lettre sélectionnée : " + ch_NextLetter);
        }

        logger.trace("######################################");
        logger.trace("<<< END >>> Méthode : run_NextLetter()");
        logger.trace("######################################\n");

        return ch_NextLetter;
    }
}
