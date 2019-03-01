package fr.moko.main.java.games_Launchers.mastermind_Launcher;

import fr.moko.main.java.games_Launchers.Games.Methods_Games;
import fr.moko.main.java.games_Launchers.Games.Texts_Games;
import fr.moko.main.java.games_Launchers.Games.Utilities_Games;
import fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind.Defense_Mastermind;
import fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind.Methods_Mastermind;
import fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind.Texts_Mastermind;
import fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind.Utilities.Display_al_Mastermind_Defense;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * Lance le jeu "Mastermind"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Mastermind_Launcher {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance : "Methods_Games"
    Methods_Games methods_Games = new Methods_Games();

    // Instance : "Texts_Games"
    Texts_Games texts_Games = new Texts_Games();

    // Instance : "Utilities_Games"
    Utilities_Games utilities_Games = new Utilities_Games();

    // Instance : "Defense_Mastermind"
    Defense_Mastermind defense_Mastermind = new Defense_Mastermind();

    // Instance : "Methods_Mastermind"
    Methods_Mastermind methods_Mastermind = new Methods_Mastermind();

    // Instance : "Display_al_Mastermind_Defense"
    Display_al_Mastermind_Defense display_al_Mastermind_Defense = new Display_al_Mastermind_Defense();

    // Instance : "Texts_Mastermind"
    Texts_Mastermind texts_Mastermind = new Texts_Mastermind();



    /**
     * Lancement du jeu "Mastermind"
     *
     * @param al_Configuration : (ArrayList) Valeurs de configuration
     * @param array_str_Main_Menu_Choices : (String[]) Choix du menu principal
     */
    public void mastermind_Launcher(ArrayList al_Configuration, String array_str_Main_Menu_Choices[]) {

        // Récupération des valeurs de configuration
        boolean boo_DevMode = (boolean) al_Configuration.get(0);
        int int_Mastermind_NumberOfUnities = (int) al_Configuration.get(3);
        int int_Mastermind_NumberOfLetters = (int) al_Configuration.get(4);
        int int_Mastermind_NumberOfChances = (int) al_Configuration.get(5);
        logger.info("Récupération des valeurs de configuration");



        // Initialisation (String) Sous-mode en mode "Duel"
        String str_SubMode = new String();
        logger.info("Initialisation (String) Sous-mode en mode \"Duel\"");



        // Instance (ArrayList) Données défense
        ArrayList al_Mastermind_Defense = new ArrayList();
        logger.info("Instance (ArrayList) Données défense");

        // Initialisation (char[]) Toutes les lettres de l'alphabet
        char array_ch_AllLetters[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N','O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        logger.debug("Initialisation (char[]) Toutes les lettres de l'alphabet : " + Arrays.toString(array_ch_AllLetters));

        // Initialisation (char[]) Lettres sélectionnées pour le jeu
        char array_ch_SelectedLetters[] = methods_Mastermind.run_array_ch_SelectedLetters(int_Mastermind_NumberOfLetters, array_ch_AllLetters);

        // Injection (char[]) Lettres sélectionnées pour le jeu dans données défense
        al_Mastermind_Defense.add(0, array_ch_SelectedLetters);
        logger.debug("Injection (char[]) Lettres sélectionnées pour le jeu dans données défense : " + Arrays.toString(array_ch_SelectedLetters));

        // Initialisation et injection (char[]) Combinaison secrète
        char array_ch_Combination[] = new char[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(1, array_ch_Combination);
        logger.info("Initialisation et injection (char[]) Combinaison secrète");

        // Initialisation et injection (int[]) Nombre de chaque lettre dans la combinaison
        int array_int_NumberOfEachLettersInCombinason[] = new int[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(2, array_int_NumberOfEachLettersInCombinason);
        logger.info("Initialisation et injection (int[]) Nombre de chaque lettre dans la combinaison");

        // Initialisation et injection (int) Compteur de tours
        int int_NumberOfRoundsCounter = 0;
        al_Mastermind_Defense.add(3, int_NumberOfRoundsCounter);
        logger.info("Initialisation et injection (int) Compteur de chances");

        // Initialisation et injection (char[]) Proposition précédente de l'ordinateur
        char array_ch_PreviousComputerProposal[] = new char[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(4, array_ch_PreviousComputerProposal);
        logger.info("Initialisation et injection (char[]) Proposition précédente de l'ordinateur");

        // Initialisation et injection (char[]) Nouvelle proposition de l'ordinateur
        char array_ch_NewComputerProposal[] = new char[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(5, array_ch_NewComputerProposal);
        logger.info("Initialisation et injection (char[]) Nouvelle proposition de l'ordinateur");

        // Initialisation et injection (int[]) Comparaison précédente
        int array_int_PreviousComparisonResult[] = new int[3];
        al_Mastermind_Defense.add(6, array_int_PreviousComparisonResult);
        logger.info("Initialisation et injection (int[]) Comparaison précédente");

        // Initialisation et injection (int[]) Nouvelle comparaison
        int array_int_NewComparisonResult[] = new int[3];
        al_Mastermind_Defense.add(7, array_int_NewComparisonResult);
        logger.info("Initialisation et injection (int[]) Nouvelle comparaison");

        // Initialisation et injection (char[]) Comparaison des comparaisons
        char array_ch_ComparisonOfComparisonResults[] = {' ', ' '};
        al_Mastermind_Defense.add(8, array_ch_ComparisonOfComparisonResults);
        logger.info("Initialisation et injection (char[]) Comparaison des comparaisons");

        // Initialisation et injection (char[][]) Analyse de la défense
        char array_ch_DefenseAnalysis[][] = new char[int_Mastermind_NumberOfLetters][int_Mastermind_NumberOfUnities];

        // FOR - Le nombre de lettres autorisées
        for (int j = 0; j < int_Mastermind_NumberOfLetters; j++) {

            // FOR - Le nombre de lettres sélectionné pour les combinaisons
            for (int k = 0; k < int_Mastermind_NumberOfUnities; k++) {

                array_ch_DefenseAnalysis[j][k] = ' ';
            }
        }

        al_Mastermind_Defense.add(9, array_ch_DefenseAnalysis);
        logger.info("Initialisation et injection (char[][]) Analyse de la défense");

        // Initialisation et injection (boolean[]) Lettres de la combinaison trouvées
        boolean array_boo_FoundLetters[] = new boolean[int_Mastermind_NumberOfUnities];
        al_Mastermind_Defense.add(10, array_boo_FoundLetters);
        logger.info("Initialisation et injection (boolean[]) Lettres de la combinaison trouvées");

        // Initialisation et injection (int) Position de remplacement
        int int_ReplacementPosition = 0;
        al_Mastermind_Defense.add(11, int_ReplacementPosition);
        logger.info("Initialisation et injection (int) Position de remplacement");

        // Initialisation et injection (char) Lettre précédente
        char ch_PreviousLetter = ' ';
        al_Mastermind_Defense.add(12, ch_PreviousLetter);
        logger.info("Initialisation et injection (char) Lettre précédente");

        // Initialisation et injection (char) Nouvelle lettre
        char ch_NewLetter = ' ';
        al_Mastermind_Defense.add(13, ch_NewLetter);
        logger.info("Initialisation et injection (char) Nouvelle lettre");



        // Initialisation (boolean) L'ordinateur a gagné
        boolean boo_HE_WON = false;
        logger.debug("Initialisation (boolean) L'ordinateur a gagné : " + boo_HE_WON);

        // Initialisation (boolean) Partie gagnée
        boolean boo_Won_Part = false;
        logger.debug("Initialisation (boolean) Partie gagnée : " + boo_Won_Part);



        // Initialisation (String) Combinaison en lettres capitales
        String str_Combination_UpperCase = new String();
        logger.info("Initialisation (String) Combinaison en lettres capitales");



        // Lancement du compteur de tours
        logger.info("Lancement du compteur de tours");
        for (int i = 0; i < int_Mastermind_NumberOfChances; i++) {



            // Mode "Défense"
            if (array_str_Main_Menu_Choices[1].equals("Défense") || array_str_Main_Menu_Choices[1].equals("Duel")) {

                logger.trace("############################");
                logger.trace("<<< START >>> Mode \"Défense\"");
                logger.trace("############################");

                // IF - Mode "Duel"
                logger.info("IF - Mode \"Duel\"");
                if (array_str_Main_Menu_Choices[1].equals("Duel")) {

                    // Màj - (String) Sous-mode (Pour mode "Duel")
                    str_SubMode = "Défense";
                    logger.debug("Màj - (String) Sous-mode (Pour mode \"Duel\") : " + str_SubMode);
                }



                // SI - Premier tour
                if (i == 0) {
                    logger.info("SI - Premier tour");

                    // Affiche "But du jeu :"
                    texts_Games.display_BUT_DU_JEU();



                    // SI - Mode "Duel", affiche l'énoncé
                    if (array_str_Main_Menu_Choices[1].equals("Duel")) {
                        logger.info("SI - Mode \"Duel\", affiche l'énoncé");

                        // Affichage énoncé en mode "Duel"
                        texts_Games.display_Duel_Statement();
                    }



                    // Affiche l'éenoncé en mode "Défense"
                    texts_Mastermind.display_Defense_Statement(int_Mastermind_NumberOfLetters, array_ch_SelectedLetters);



                    // Affiche "A vous de jouer !"
                    texts_Games.display_A_VOUS_DE_JOUER();



                    // Initialisation (boolean) La combinaison est validée
                    boolean boo_Combination_Treatment = false;
                    logger.debug("Initialisation (boolean) La combinaison est validée : " + boo_Combination_Treatment);

                    // DO {} WHILE - La combinaison n'est pas validée
                    logger.info("DO {} WHILE - La combinaison n'est pas validée");
                    do {

                        // Lance le scanner pour la combinaison
                        Scanner sc_Combination = methods_Games.run_sc_Combination(array_str_Main_Menu_Choices, str_SubMode);
                        logger.info("Lance le scanner pour la combinaison");

                        // Vérifie que la combinaison ne contient que des lettres
                        String str_Combination_Regex = methods_Mastermind.run_Combination_Regex(int_Mastermind_NumberOfLetters, array_str_Main_Menu_Choices, str_SubMode, array_ch_SelectedLetters, sc_Combination);
                        logger.info("Vérifie que la combinaison ne contient que des lettres");

                        // Converti la combinaison en lettres capitales
                        str_Combination_UpperCase = str_Combination_Regex.toUpperCase();
                        logger.info("Converti la combinaison en lettres capitales");

                        // (boolean) La combinaison est de la bonne longeur
                        boolean boo_Combination_GoodLenght = methods_Mastermind.run_Combination_GoodLenght(int_Mastermind_NumberOfUnities, str_Combination_UpperCase);
                        logger.debug("(boolean) La combinaison est de la bonne longeur : " + boo_Combination_GoodLenght);

                        // Initialisation (boolean) La combinaison est composée des lettres autorisées
                        boolean boo_Combination_GoodLetters = false;
                        logger.debug("Initialisation (boolean) La combinaison est composée des lettres autorisées : " + boo_Combination_GoodLetters);

                        // IF - La combinaison de la bonne longueur
                        if (boo_Combination_GoodLenght) {
                            logger.info("IF - La combinaison de la bonne longueur");

                            // Vérifie que la combinaison contient uniquement des lettres autorisées
                            boo_Combination_GoodLetters = methods_Mastermind.run_Combination_GoodCharacters(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, array_ch_SelectedLetters, str_Combination_UpperCase);
                            logger.debug("(boolean) la combinaison contient uniquement des lettres autorisées : " + boo_Combination_GoodLetters);

                            // IF - La combinaison ne contient pas que des lettres autorisées
                            if (!boo_Combination_GoodLetters) {
                                logger.warn("IF - La combinaison ne contient pas que des lettres autorisées");

                                // Affiche "La combinaison doit être composée des lettres ..., ..., ..."
                                texts_Mastermind.display_LA_COMBINAISON_DOIT_ETRE_COMPOSEE_DES_LETTRES(int_Mastermind_NumberOfLetters, array_ch_AllLetters);
                            }
                        }
                        // ELSE - La combinaison n'est pas de la bonne longueur
                        else {
                            logger.warn("ELSE - La combinaison n'est pas de la bonne longueur");

                            // Affiche "La combinaison soit être composée de ... lettres"
                            texts_Mastermind.display_LA_COMBINAISON_DOIT_ETRE_COMPOSEE_DE(int_Mastermind_NumberOfUnities);
                        }

                        // IF - La combinaison est de la bonne longueur et qu'elle ne contient que des lettres autorisées
                        if (boo_Combination_GoodLenght && boo_Combination_GoodLetters) {
                            logger.info("IF - La combinaison est de la bonne longueur et qu'elle ne contient que des lettres autorisées");

                            // MàJ - (boolean) La combinaison est validée
                            boo_Combination_Treatment = true;
                            logger.debug("MàJ - (boolean) La combinaison est validée : " + boo_Combination_Treatment);
                        }

                        logger.debug("(boolean) Combinaison validée : " + boo_Combination_Treatment);

                    } while (!boo_Combination_Treatment);

                    // Conversion (char[]) Combinaison secrète contenue dans la chaîne de caractère
                    array_ch_Combination = utilities_Games.run_str_TO_chArray(int_Mastermind_NumberOfUnities, str_Combination_UpperCase);
                    logger.debug("Conversion (char[]) Combinaison secrète contenue dans la chaîne de caractère : " + Arrays.toString(array_ch_Combination));

                    // Injection (char[]) Combinaison secrète
                    al_Mastermind_Defense.set(1, array_ch_Combination);
                    logger.info("Injection (char[]) Combinaison secrète");

                    // MàJ - (int[]) Nombre de chaque lettre dans la combinaison
                    array_int_NumberOfEachLettersInCombinason = methods_Mastermind.run_array_int_NumberOfEachLetters(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, array_ch_SelectedLetters, array_ch_Combination);
                    logger.debug("MàJ - (int[]) Nombre de chaque lettre dans la combinaison : " + Arrays.toString(array_int_NumberOfEachLettersInCombinason));

                    // Injection (int[]) Nombre de chaque lettre dans la combinaison
                    al_Mastermind_Defense.set(2, array_int_NumberOfEachLettersInCombinason);
                    logger.info("Injection (int[]) Nombre de chaque lettre dans la combinaison");

                    // Conversion (String) Combinaison secrète contenue dans le tableau de caractères
                    String str_Combination = utilities_Games.run_arrayCh_TO_str(int_Mastermind_NumberOfUnities, array_ch_Combination);
                    logger.info("Conversion (String) Combinaison secrète contenue dans le tableau de caractères");

                    // Affiche la combinaison secrète
                    texts_Games.display_VOTRE_COMBINAISON(str_Combination);
                }

                // Lancement de la défense du jeu "Mastermind"
                al_Mastermind_Defense = defense_Mastermind.run_Defense(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, array_str_Main_Menu_Choices, i, al_Mastermind_Defense);

                // Affichage "al_Mastermind_Defense"
                display_al_Mastermind_Defense.display_al_Mastermind_Defense(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, al_Mastermind_Defense);

                // Récupération (char[]) Nouvelle proposition de l'ordinateur
                array_ch_NewComputerProposal = (char[]) al_Mastermind_Defense.get(5);
                logger.info("Récupération (char[]) Nouvelle proposition de l'ordinateur");

                // Conversion (String) Proposition de l'ordinateur
                String str_ComputerProposal = utilities_Games.run_arrayCh_TO_str(int_Mastermind_NumberOfUnities, array_ch_NewComputerProposal);
                logger.debug("Conversion (String) Proposition de l'ordinateur : " + str_ComputerProposal);

                // Affiche la proposition de l'ordinateur
                texts_Games.display_PROPOSITION_DE_L_ORDINATEUR(str_ComputerProposal, i);

                // Lancement de la comparaison entre la proposition de l'ordinateur et la combinaison secrète
                array_int_NewComparisonResult = defense_Mastermind.run_al_NewComparisonResult(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, str_SubMode, al_Mastermind_Defense);
                logger.info("Lancement de la comparaison entre la proposition de l'ordinateur et la combinaison secrète");

                // Affichage résultat de la comparaison
                texts_Mastermind.display_RESULTAT_DE_LA_COMPARAISON(array_int_NewComparisonResult);

                // Injection (int[]) Nouvelle Comparaison
                al_Mastermind_Defense.set(7, array_int_NewComparisonResult);
                logger.info("Injection (int[]) Nouvelle Comparaison");

            }
        }
    }
}
