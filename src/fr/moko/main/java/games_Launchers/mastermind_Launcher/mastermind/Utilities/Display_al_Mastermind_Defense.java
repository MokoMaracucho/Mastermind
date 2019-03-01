package fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Affiche le contenu le l'ArrayList "al_Defense"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Display_al_Mastermind_Defense {

    static Logger logger = LogManager.getRootLogger();

    // Instance "Display_Array_Defense"
    Display_Array_Defense display_Array_Defense = new Display_Array_Defense();



    /**
     * Affichage le contenu le l'ArrayList "al_Defense"
     *
     *
     * @param int_NumberOfUnities : (int) Nombre d'uniés utilisées pour les combinaisons
     * @param int_NumberOfLetters : (int) Nombre de lettres sélectionnées pour le "Mastermind"
     * @param al_Mastermind_Defense : (ArrayList) Données de défense
     */
    public void display_al_Mastermind_Defense (int int_NumberOfUnities, int int_NumberOfLetters, ArrayList al_Mastermind_Defense) {

        logger.trace("###########################################################################################################");
        logger.trace("########################################## AL_MASTERMIND_DEFENSE ##########################################");
        logger.trace("###########################################################################################################");

        // al_Defense(0)
        char array_ch_SelectedLetters[] = (char[]) al_Mastermind_Defense.get(0);
        logger.debug("array_ch_SelectedLetters[] :                  " + Arrays.toString(array_ch_SelectedLetters));

        // al_Defense(1)
        char array_ch_Combination[] = (char[]) al_Mastermind_Defense.get(1);
        logger.debug("array_ch_Combination[] :                      " + Arrays.toString(array_ch_Combination));

        // al_Defense(2)
        int array_int_NumberOfEachLettersInCombinason[] = (int[]) al_Mastermind_Defense.get(2);
        logger.debug("array_int_NumberOfEachLettersInCombinason[] : " + Arrays.toString(array_int_NumberOfEachLettersInCombinason));

        // al_Defense(3)
        int int_NumberOfChancesCounter = (int) al_Mastermind_Defense.get(3);
        logger.debug("int_NumberOfChancesCounter :                  " + int_NumberOfChancesCounter);

        // al_Defense(4)
        char array_ch_PreviousComputerProposal[] = (char[]) al_Mastermind_Defense.get(4);
        logger.debug("array_ch_PreviousComputerProposal[] :         " + Arrays.toString(array_ch_PreviousComputerProposal));

        // al_Defense(5)
        char array_ch_NewComputerProposal[] = (char[]) al_Mastermind_Defense.get(5);
        logger.debug("array_ch_NewComputerProposal[] :              " + Arrays.toString(array_ch_NewComputerProposal));

        // al_Defense(6)
        int array_int_PreviousComparisonResult[] = (int[]) al_Mastermind_Defense.get(6);
        logger.debug("array_int_PreviousComparisonResult[] :        " + Arrays.toString(array_int_PreviousComparisonResult));

        // al_Defense(7)
        int array_int_NewComparisonResult[] = (int[]) al_Mastermind_Defense.get(7);
        logger.debug("array_int_NewComparisonResult[] :             " + Arrays.toString(array_int_NewComparisonResult));

        // al_Defense(8)
        char array_ch_ComparisonOfComparisonResults[] = (char[]) al_Mastermind_Defense.get(8);
        logger.debug("array_ch_ComparisonOfComparisonResults[] :    " + Arrays.toString(array_ch_ComparisonOfComparisonResults));

        // al_Defense(9)
        char array_ch_DefenseAnalysis[][] = (char[][]) al_Mastermind_Defense.get(9);
        logger.debug("array_ch_DefenseAnalysis[][]\n");
        display_Array_Defense.display_Array_Defense(int_NumberOfUnities, int_NumberOfLetters, al_Mastermind_Defense);

        // al_Defense(10)
        boolean array_boo_FoundLetters[] = (boolean[]) al_Mastermind_Defense.get(10);
        logger.debug("array_boo_FoundLetters[] :                    " + Arrays.toString(array_boo_FoundLetters));

        // al_Defense(11)
        int int_ReplacementPosition = (int) al_Mastermind_Defense.get(11);
        logger.debug("int_ReplacementPosition :                     " + int_ReplacementPosition);

        // al_Defense(12)
        char ch_PreviousLetter = (char) al_Mastermind_Defense.get(12);
        logger.debug("ch_PreviousLetter :                           " + ch_PreviousLetter);

        // al_Defense(13)
        char ch_NewLetter = (char) al_Mastermind_Defense.get(13);
        logger.debug("ch_NewLetter :                                " + ch_NewLetter);

        logger.trace("###########################################################################################################");
        logger.trace("###########################################################################################################");
        logger.trace("###########################################################################################################\n");
    }
}
