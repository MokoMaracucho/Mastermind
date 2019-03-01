package fr.moko.main.java.games_Launchers.Games;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * Méthodes utilitaires
 *
 * @author : Moko
 * @version : 1.0
 */
public class Utilities_Games {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();



    /**
     * Conversion d'un entier dans un tableau d'entiers
     *
     * @param int_NumberOfBoxes : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_Combination_TryCatch : (int) Combinaison après vérification qu'elle ne contient que des nombres
     *
     * @return : (int[]) La combinaison convertie dans un tableau d'entier
     */
    public int[] run_int_TO_arrayInt(int int_NumberOfBoxes, int int_Combination_TryCatch){

        int array_int_Combination[] = new int[int_NumberOfBoxes];

        int int_Level = 1;

        int int_IStart = int_NumberOfBoxes - 1;
        logger.debug("int_IStart : " + int_IStart);

        if (int_Combination_TryCatch >= 10) {

            do {

                int_Level *= 10;

                if (int_Combination_TryCatch > int_Level) {

                    int_IStart -= 1;
                }

            } while (int_Combination_TryCatch > int_Level);
        }

        String str_Scanner = Integer.toString(int_Combination_TryCatch);

        for (int i = int_IStart; i < int_NumberOfBoxes; i++) {

            array_int_Combination[i] = Integer.parseInt(str_Scanner.charAt(i - int_IStart) + "");
        }

        logger.debug("(array int) Combinaison : " + Arrays.toString(array_int_Combination));

        return array_int_Combination;
    }



    /**
     * Conversion d'un tableau d'entier en chaine de caractère
     *
     * @param int_NumberOfBoxes : (int) Nombre de cases du tableau
     * @param array_int : (array int) Tableau d'entiers
     *
     * @return : (String) Chaîne de caractères
     */
    public String run_arrayInt_TO_str(int int_NumberOfBoxes, int array_int[]){

        String str = "";

        for (int i = 0; i < int_NumberOfBoxes; i++){

            str += Integer.toString(array_int[i]);
        }
        return str;
    }



    /**
     * Conversion d'un tableau de caractères en chaîne de caractères
     *
     * @param int_NumberOfBoxes : (int) Nombre de cases
     * @param array_ch : (char[]) Tableau de caractères
     *
     * @return (String) Chaîne de caractères
     */
    public String run_arrayCh_TO_str(int int_NumberOfBoxes, char array_ch[]) {

        String str = "";

        for (int i = 0; i < int_NumberOfBoxes; i++){

            str += array_ch[i];
        }

        logger.debug("Incrémentation String() : " + str);

        return str;
    }



    /**
     * Conversion d'une chaîne de caractère en tableau de caractères
     *
     * @param int_Mastermind_NumberOfUnities : (int) Nombre d'unités de la combinaison
     * @param str_Combination_UpperCase : (String) Combinaison en lettres capitales
     *
     * @return (char[]) Un tableau de caractères
     */
    public char[] run_str_TO_chArray(int int_Mastermind_NumberOfUnities, String str_Combination_UpperCase) {

        char array_ch_Combination[] = new char[int_Mastermind_NumberOfUnities];

        for (int i = 0; i < int_Mastermind_NumberOfUnities; i++) {

            array_ch_Combination[i] = str_Combination_UpperCase.charAt(i);
        }

        logger.debug("array_ch_Combination[] : " + Arrays.toString(array_ch_Combination));

        return array_ch_Combination;
    }
}
