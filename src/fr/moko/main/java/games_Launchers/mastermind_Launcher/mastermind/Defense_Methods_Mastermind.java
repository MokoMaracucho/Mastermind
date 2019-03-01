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
     * @param int_NumberOfLetters : (int) Nombre de lettres utilisées pour les combinaisons
     * @param al_Mastermind_Defense : (ArrayList) Données défense
     * @param ch_Letter : (char) Lettre séectionnée
     *
     * @return : (int) L'index de la lettre
     */
    public int run_int_IndexOfLetter(int int_NumberOfLetters, ArrayList al_Mastermind_Defense, char ch_Letter) {

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
        for (int j = 0; j < int_NumberOfLetters; j++) {

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
     *
     *
     * @param array_ch_SelectedLetters
     * @param i
     * @param ch_InitialLetter
     * @param ch_NextLetter
     *
     * @return
     */
    public char run_NextLetter(int int_NumberOfLetters, char array_ch_SelectedLetters[], int i, char ch_InitialLetter, char ch_NextLetter) {

        logger.trace("########################################");
        logger.trace("<<< START >>> Méthode : run_NextLetter()");
        logger.trace("########################################");

        // IF - "i" < Que le nombre de lettres sélectionnées pour le "Mastermind"
        if (i < int_NumberOfLetters - 1) {
            logger.info("IF - \"i\" < Que le nombre de lettres sélectionnées pour le \"Mastermind\"");

            // MàJ - (char) Lettre sélectionnée
            ch_NextLetter = array_ch_SelectedLetters[i + 1];
            logger.debug("MàJ - (char) Lettre sélectionnée : " + ch_NextLetter);
        }
        // ELSE - i" > Que le nombre de lettres sélectionnées pour le "Mastermind"
        else {
            logger.info("ELSE - i\" > Que le nombre de lettres sélectionnées pour le \"Mastermind\"");

            int j = i - int_NumberOfLetters;

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
