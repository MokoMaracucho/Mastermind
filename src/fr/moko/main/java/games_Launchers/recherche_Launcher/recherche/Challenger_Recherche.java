
package fr.moko.main.java.games_Launchers.recherche_Launcher.recherche;

import fr.moko.main.java.games_Launchers.Games.Methods_Games;

import fr.moko.main.java.games_Launchers.Games.Texts_Games;
import fr.moko.main.java.games_Launchers.Games.Utilities_Games;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



/**
 * Méthodes attenantes au mode "Challenger" du jeu "Recherche +/-"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Challenger_Recherche {


    // Instance "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance "Methods_Recherche"
    Methods_Recherche methods_Recherche = new Methods_Recherche();

    // Instance "Texts_Recherche"
    Texts_Recherche texts_Recherche = new Texts_Recherche();

    // Instance "Texts_Games"
    Texts_Games texts_Games = new Texts_Games();

    // Instance "Methods_Games"
    Methods_Games methods_Games = new Methods_Games();

    // Instance "Utilities_Games"
    Utilities_Games utilities_Games = new Utilities_Games();


    /**
     * Lancement du nombre aléatoire
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param array_int_RandomNumber : (int[]) Nombre généré de manière aléatoire
     *
     * @return : Nombre aléatoire
     */
    public int[] run_RandomNumber(int int_Recherche_NumberOfUnities, int array_int_RandomNumber[]) {

        // FOR - Pour chaque unité de la combinaison secrète
        for (int i = 0; i < int_Recherche_NumberOfUnities; i++) {
            logger.info("FOR - Pour chaque unité de la combinaison secrète");

            // Instance "Random"
            Random random = new Random();

            // Incréemntattion chiffre aléatoire
            array_int_RandomNumber[i] = random.nextInt(9);
            logger.debug("Incréemntattion chiffre aléatoire : " + Arrays.toString(array_int_RandomNumber));
        }

        logger.debug("Nombre aléatoire généré : " + Arrays.toString(array_int_RandomNumber));

        return array_int_RandomNumber;
    }


    /**
     * Initialisation du jeu "Recherche +/-" en mode "Challenger"
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_NumberOfChances : (int) Nombre de chances
     * @param array_str_Main_Menu_Choices : (String[]) Choix du menu principal
     * @param boo_HeWon : (boolean) L'ordinateur a gagné
     * @param i i : (int) Nombre de tours
     * @param str_SubMode : (String) Sous-mode en mode "Duel"
     * @param array_int_RandomNumber : (int[]) Nombre généré de manière aléatoire
     * @param str_ComparisonResult_Challenger : (String) Résultat de la comparason en mode "Challenger"
     *
     * @return (String) Résultat de la comparaison
     */
    public String run_RecherchePlusMoins_Challenger(int int_Recherche_NumberOfUnities, int int_NumberOfChances, String array_str_Main_Menu_Choices[], boolean boo_HeWon, int i, String str_SubMode, int array_int_RandomNumber[], String str_ComparisonResult_Challenger) {

        // Initialisation (int) Proposition Try Catch
        int int_Combination_TryCatch = 0;
        logger.debug("Initialisation (int) Proposition Try Catch");

        // Initialisation (boolean) Proposition validée
        boolean boo_Combination_Validated = false;
        logger.debug("Initialisation (boolean) Proposition validée : " + boo_Combination_Validated);

        // DO {} WHILE - La proposition n'est pas validée
        do {
            logger.info("DO {} WHILE - La proposition n'est pas validée");

            // Initialise le scanner pour la proposition
            Scanner sc_Combinaison = methods_Games.run_sc_Combination(array_str_Main_Menu_Choices, str_SubMode);
            logger.info("Initialise le scanner pour la proposition");

            // Vérifie si la combinaison de l'utilisateur ne contient que des nombres
            int_Combination_TryCatch = methods_Recherche.run_Combination_TryCatch(array_str_Main_Menu_Choices, str_SubMode, sc_Combinaison, int_Combination_TryCatch);
            logger.info("Vérifie si la combinaison de l'utilisateur ne contient que des nombres");

            // MàJ - (boolean) Vérifie si la combinaison de l'utilisateur est valide
            boo_Combination_Validated = methods_Recherche.run_Combination_Treatment(int_Recherche_NumberOfUnities, int_Combination_TryCatch, boo_Combination_Validated);
            logger.info("MàJ - (boolean) Vérifie si la combinaison de l'utilisateur est valide");

        } while (!boo_Combination_Validated);

        // Conversion (int[]) Combinaison de l'utilisateur dans entier
        int array_int_Combination[] = utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Combination_TryCatch);
        logger.debug("Conversion (int[]) Combinaison de l'utilisateur : " + Arrays.toString(array_int_Combination));

        // Conversion (String) Combinaison de l'utilisateur contenue dans un tableau d'entier
        String str_Combination = utilities_Games.run_arrayInt_TO_str(int_Recherche_NumberOfUnities, array_int_Combination);

        // IF - Pas le premier tour && Pas mode "Duel" && L'ordinateur n'a pas gagné
        if (i != 0 && !array_str_Main_Menu_Choices[1].equals("Duel") && !boo_HeWon) {
            logger.info("IF - Pas le premier tour && Pas mode \"Duel\" && L'ordinateur n'a pas gagné");

            // Affiche le nombre des chances restantes
            texts_Games.display_RemainingChances(int_NumberOfChances, array_str_Main_Menu_Choices, str_SubMode, i);
        }

        // Affiche "Votre proposition ..."
        texts_Recherche.display_VOTRE_PROPOSITION(str_Combination);

        // Lancement comparaiosn entre la combinaison de l'utilisateur et la combinaison secrète
        char array_ch_ComparisonResult[] = run_array_ch_ComparisonResult(int_Recherche_NumberOfUnities, array_int_RandomNumber, array_int_Combination);
        logger.info("Lancement comparaiosn entre la combinaison de l'utilisateur et la combinaison secrète");

        // Conversion (String) Résultat de la comparaison contenu dans un tableau de caractères
        str_ComparisonResult_Challenger = utilities_Games.run_arrayStr_TO_str(int_Recherche_NumberOfUnities, array_ch_ComparisonResult);

        // Affiche le résultat de la comparaison
        texts_Recherche.display_RESULTAT_DE_LA_COMPARAISON(array_str_Main_Menu_Choices, str_SubMode, str_ComparisonResult_Challenger);

        return str_ComparisonResult_Challenger;
    }


    /**
     * Lancement de la conparaison entre la proposition de l'utilisateur et la combinaison secrète
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param array_int_Base : (int[]) Tableau comparé
     * @param array_int_ToCompare : (int[]) Tableau à comparer
     *
     * @return : (char[]) Résultat de la comparaison
     */
    public char[] run_array_ch_ComparisonResult(int int_Recherche_NumberOfUnities, int array_int_Base[], int array_int_ToCompare[]) {

        logger.debug("-----------------------------------------------------------> Tableau à comparer : " +Arrays.toString(array_int_ToCompare));
        logger.debug("-----------------------------------------------------------> Tableau de base : " +Arrays.toString(array_int_Base));

        // Initialisation (char[]) Résultat de la comparaison
        char array_ch_ComparisonResult[] = new char[int_Recherche_NumberOfUnities];
        logger.debug("Initialisation (char[]) Résultat de la comparaison : " + Arrays.toString(array_ch_ComparisonResult));

        // FOR - Pour chaque unité
        logger.info("FOR - Pour chaque unité");
        for (int i = 0; i < int_Recherche_NumberOfUnities; i++) {

            // IF - L'unité à comparer est < que l'unité comparée
            if (array_int_ToCompare[i] < array_int_Base[i]) {
                logger.info("IF - L'unité à comparer est < que l'unité comparée");

                array_ch_ComparisonResult[i] = '+';

            }
            // ELSE IF - L'unité à comparer est > que l'unité comparée
            else if (array_int_ToCompare[i] > array_int_Base[i]) {
                logger.info("ELSE IF - L'unité à comparer est > que l'unité comparée");


                array_ch_ComparisonResult[i] = '-';

            }
            // ELSE - L'unité à comparer est = que l'unité comparée
            else {
                logger.info("ELSE - L'unité à comparer est = que l'unité comparée");

                array_ch_ComparisonResult[i] = '=';
            }
        }

        return array_ch_ComparisonResult;
    }
}
