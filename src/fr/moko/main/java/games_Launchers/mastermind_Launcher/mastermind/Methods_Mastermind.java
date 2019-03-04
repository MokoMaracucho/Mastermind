package fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind;

import fr.moko.main.java.games_Launchers.Games.Methods_Games;

import org.apache.logging.log4j.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Méthodes attenantes au "Mastermind"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Methods_Mastermind {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance : "Methods_Games"
    Methods_Games methods_Games = new Methods_Games();

    // Instance : "Texts_Mastermind"
    Texts_Mastermind texts_Mastermind = new Texts_Mastermind();



    /**
     * Tableau des lettres sélectionnées pour le jeu "Mastermind"
     *
     * @param int_Mastermind_NumberOfLetters : (int) Nombre de lettres sélectionnées pour les combinaisons
     * @param array_ch_AllLetters : (char[]) Toutes les lettres de l'alphabet
     *
     * @return : (char[]) Les lettres utilisées pour le "Mastermind"
     */
    public char[] run_array_ch_SelectedLetters(int int_Mastermind_NumberOfLetters, char array_ch_AllLetters[]) {

        // Initialisation (char[]) Lettres sélectionnées pour le "Mastermind"
        char array_ch_SelectedLetters[] = new char[int_Mastermind_NumberOfLetters];
        logger.info("Initialisation (char[]) Lettres utilisées pour le \"Mastermind\"");

        // FOR - Le nombre de lettres sélectionnées pour le "Mastermind"
        for (int i = 0; i < int_Mastermind_NumberOfLetters; i++) {

            // Récupération (char) Lettres de l'alphabet dans l'ordre
            array_ch_SelectedLetters[i] = array_ch_AllLetters[i];
        }

        logger.debug("(char[]) Lettres sélectionnées pour le \"Mastermind\" : " + Arrays.toString(array_ch_SelectedLetters));

        return array_ch_SelectedLetters;
    }



    /**
     * Teste la présence unique de lettres dans la combinaison de l'utilisateur
     *
     * @param int_Mastermind_NumberOfLetters  : (int) Nombre d'unités utilisées pour les combinaisons
     * @param array_str_MenuChoices : (String[]) Choix du menu principal
     * @param str_SubMode : (String) Sous-mode en mode "Duel"
     * @param array_ch_SelectedLetters : (char[]) Lettres sélectionnées pour le jeu "Mastermind"
     * @param sc_Combination : Scanner contenant la combinaison
     *
     * @return : (String) La combinaison quand elle ne contient que des lettres
     */
    public String run_Combination_Regex(int int_Mastermind_NumberOfLetters, String array_str_MenuChoices[], String str_SubMode, char array_ch_SelectedLetters[], Scanner sc_Combination) {

        logger.trace("#####################################");
        logger.trace("### START ### run_Combination_Regex()");
        logger.trace("#####################################");

        String str_Combination = new String();

        // Initialisation (boolean) La combinaison n'est composée que de lettres
        boolean boo_OnlyLetters = true;
        logger.debug("Initialisation (boolean) La combinaison n'est composée que de lettres : " + boo_OnlyLetters);

        // DO {} WHILE - La combinaison n'est pas composée que de lettres
        do {
            logger.info("DO {} WHILE - La combinaison n'est pas composée que de lettres");

            // IF - La combinaison n'est composée que de lettres
            if (!boo_OnlyLetters) {
                logger.info("IF - La combinaison n'est composée que de lettres");

                // Lancement du scanner pour nouvelle proposition
                methods_Games.run_sc_Combination(array_str_MenuChoices, str_SubMode);
                logger.info("Lancement du scanner pour nouvelle proposition");
            }

            // Récupération (String) Contenu du scanner
            str_Combination = sc_Combination.nextLine();
            logger.debug("Récupération (String) Contenu du scanner : " + str_Combination);

            // Instance "Pattern"
            Pattern pattern = Pattern.compile("[a-zA-Z]+");
            logger.info("Instance \"Pattern\"");

            // Instance "Matcher"
            Matcher matcher = pattern.matcher(str_Combination);
            logger.info("Instance \"Matcher\"");

            // IF - Match
            if (matcher.matches()) {
                logger.info("IF - Match");

                // SEULEMENT DES LETTRES = TRUE
                boo_OnlyLetters = true;
                logger.debug("boolean Seulement des lettres : " + boo_OnlyLetters);
            }
            // ELSE - Error
            else {
                logger.warn("ELSE - Error");

                // MàJ - (boolean) La combinaison n'est composée que de lettres
                boo_OnlyLetters = false;
                logger.error("MàJ - (boolean) La combinaison n'est composée que de lettres : " + boo_OnlyLetters);

                // Affiche "La combinaiosn doit être composée des lettres : ..."
                texts_Mastermind.display_LA_COMBINAISON_DOIT_ETRE_COMPOSEE_DES_LETTRES(int_Mastermind_NumberOfLetters, array_ch_SelectedLetters);
            }
            // DO {} WHILE : "SI SEULEMNT DES LETTRES" - SORTIE
        } while (!boo_OnlyLetters);
        logger.info("DO {} WHILE : \"Si seulement des lettres\" - SORTIE");

        // VALEUR STRING() COMBINAISON EN RETOUR
        logger.debug("String() Combinaison : " + str_Combination);

        logger.trace("###################################");
        logger.trace("### END ### run_Combination_Regex()");
        logger.trace("###################################\n");

        return str_Combination;
    }



    /**
     * Teste la bonne longueur de la combinaison de l'utilisateur
     *
     * @param int_Mastermind_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param str_Combination_UpperCase : (String) Combinaison en lettres capitales
     *
     * @return : (boolean) La combinaison est de la bonne longueur
     */
    public boolean run_Combination_GoodLenght(int int_Mastermind_NumberOfUnities, String str_Combination_UpperCase) {

        logger.trace("##########################################");
        logger.trace("### START ### run_Combination_GoodLenght()");
        logger.trace("##########################################");

        // Initialisation (boolean) La combinaison est de la bonne longueur
        boolean boo_GoodLenght = true;
        logger.debug("Initialisation (boolean) La combinaison est de la bonne longueur : " + boo_GoodLenght);

        // IF - La combinaison ≠ longueur spécifiée
        if (str_Combination_UpperCase.length() != int_Mastermind_NumberOfUnities) {
            logger.error("IF - La combinaison ≠ longueur spécifiée");

            // Màj - (boolean) La combinaison est de la bonne longueur
            boo_GoodLenght = false;
            logger.debug("Màj - (boolean) La combinaison est de la bonne longueur : " + boo_GoodLenght);
        }

        logger.debug("(boolean) La combinaison est de la bonne longueur : " + boo_GoodLenght);

        logger.trace("########################################");
        logger.trace("### END ### run_Combination_GoodLenght()");
        logger.trace("########################################\n");

        return boo_GoodLenght;
    }



    /**
     * Teste la validité des lettres utilisées dans la combinaison de l'utlisateur
     *
     * @param int_Mastermind_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_Mastermind_NumberOfLetters : (int) Nombre de lettres utilisées pour les combinaisons
     * @param array_ch_SelectedLetters : (char[]) Lettres sélectionnées pour le jeu "Mastermind"
     * @param str_Combination_UpperCase : Combinaison en lettres capitales
     *
     * @return : (boolean) La combinaison est composée des bonnes lettres
     */
    public boolean run_Combination_GoodCharacters(int int_Mastermind_NumberOfUnities, int int_Mastermind_NumberOfLetters, char array_ch_SelectedLetters[], String str_Combination_UpperCase) {

        logger.trace("##############################################");
        logger.trace("### START ### run_Combination_GoodCharacters()");
        logger.trace("##############################################");

        // Initialisation (boolean) L'unité sélectionnée contient une lettre autorisée
        boolean boo_Combination_GoodLetter = false;
        logger.debug("Initialisation (boolean) L'unité sélectionnée contient une lettre autorisée : " + boo_Combination_GoodLetter);

        // Initialisation (boolean) Toutes les unités testées contiennent des lettres autorisées
        boolean boo_Combination_GoodLetters = false;
        logger.debug("Initialisation (boolean) Toutes les unités testées contiennent des lettres autorisées : " + boo_Combination_GoodLetters);

        // FOR - Pour chaque unité de la combinaison
        for (int i = 0; i < int_Mastermind_NumberOfUnities; i++) {

            // FOR - Chaque lettre utilisée pour le "Mastermind"
            for (int j = 0; j < int_Mastermind_NumberOfLetters; j++) {

                // IF - L'unité sélectionnée contient une lettre autorisée
                if (str_Combination_UpperCase.charAt(i) == array_ch_SelectedLetters[j]) {

                    // MàJ - (boolean) L'unité sélectionnée contient une lettre autorisée
                    boo_Combination_GoodLetter = true;

                    break;
                }
                // ELSE - L'unité sélectionnée ne contient pas une lettre autorisée
                else {

                    // BOOLEEN LETTRE DANS COMBINAISON != A LA LETTRE SELECTIONNEE POUR LE JEU
                    boo_Combination_GoodLetter = false;
                }
            }

            // IF - L'unité sélectionnée contient une lettre autorisée
            if (boo_Combination_GoodLetter) {

                // MàJ - (boolean) Toutes les unités testées contiennent des lettres autorisées
                boo_Combination_GoodLetters = true;

            }
            // ELSE - L'unité sélectionnée ne contient pas une lettre autorisée
            else {

                // MàJ - (boolean) La combinaison n'est pas composée que de lettres autorisées
                boo_Combination_GoodLetters = false;

                break;
            }
        }

        // (boolean) La combinaison n'est pas composée que de lettres autorisées
        logger.debug("Valeur booléen bonnes lettres en retour : " + boo_Combination_GoodLetters);

        logger.trace("##########################################");
        logger.trace("### END ### run_Combination_GoodCharacters()");
        logger.trace("##########################################\n");

        return boo_Combination_GoodLetters;
    }



    /**
     * Tableau qui récupère le nombre de chaque lettre dans la combinaison
     *
     * @param int_MAstermind_NumberOfUnities  : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_Mastermind_NumberOfLetters : (int) Nombre de lettres utilisées pour les combinaisons
     * @param array_ch_SelectedLetters : (char[]) Lettres sélectionnées pour le jeu "Mastermind"
     * @param array_ch_Combinaison : (char[]) Combinaison secrète
     *
     * @return : (int) Nombre de chaque lettre dans la combinaison secrète
     */
    public int[] run_array_int_NumberOfEachLetters(int int_MAstermind_NumberOfUnities, int int_Mastermind_NumberOfLetters, char array_ch_SelectedLetters[], char array_ch_Combinaison[]) {

        // Initialisation (int[]) Nombre de chaque lettre dans la combinaison
        int array_int_NumberOfEachLettersInCombinason[] = new int[int_Mastermind_NumberOfLetters];
        logger.info("Initialisation (int[]) Nombre de chaque lettre dans la combinaison");

        // FOR - Chaque lettre de la combinaison
        for (int i = 0; i < int_MAstermind_NumberOfUnities; i++) {

            // FOR - Pour le nombre de lettres sélectionnées pour le "Mastermind"
            for (int j = 0; j < int_Mastermind_NumberOfLetters; j++) {

                // IF - L'unité sélectionnée contient une lettre séeclectionnée pour le jeu
                if (array_ch_Combinaison[i] == array_ch_SelectedLetters[j]) {

                    // Incrémentation += 1 pour la lettre sélectionnée
                    array_int_NumberOfEachLettersInCombinason[j] += 1;

                    break;
                }
            }
        }

        // (int[]) Nombre de chaque lettre dans la combinaison
        logger.debug("array_int_NumberOfEachLettersInCombinason[] : " + Arrays.toString(array_int_NumberOfEachLettersInCombinason));

        return array_int_NumberOfEachLettersInCombinason;
    }
}
