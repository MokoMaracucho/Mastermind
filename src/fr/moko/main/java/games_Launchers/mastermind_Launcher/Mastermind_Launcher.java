package fr.moko.main.java.games_Launchers.mastermind_Launcher;

import fr.moko.main.java.games_Launchers.Games.Methods_Games;
import fr.moko.main.java.games_Launchers.Games.Texts_Games;
import fr.moko.main.java.games_Launchers.Games.Utilities_Games;
import fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind.Challenger_Mastermind;
import fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind.Defense_Mastermind;
import fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind.Methods_Mastermind;
import fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind.Texts_Mastermind;
import fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind.Utilities.Display_Array_Defense;
import fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind.Utilities.Display_al_Mastermind_Defense;

import fr.moko.main.java.graphism.Graphism;
import org.apache.logging.log4j.*;

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

    // Instance : "Graphism"
    Graphism graphism = new Graphism();

    // Instance : "Methods_Games"
    Methods_Games methods_Games = new Methods_Games();

    // Instance : "Texts_Games"
    Texts_Games texts_Games = new Texts_Games();

    // Instance : "Utilities_Games"
    Utilities_Games utilities_Games = new Utilities_Games();

    // Instance : "Defense_Mastermind"
    Defense_Mastermind defense_Mastermind = new Defense_Mastermind();

    // Instance : "Challenger_Mastermind"
    Challenger_Mastermind challenger_Mastermind = new Challenger_Mastermind();

    // Instance : "Methods_Mastermind"
    Methods_Mastermind methods_Mastermind = new Methods_Mastermind();

    // Instance : "Display_al_Mastermind_Defense"
    Display_al_Mastermind_Defense display_al_Mastermind_Defense = new Display_al_Mastermind_Defense();

    // Instance : "Texts_Mastermind"
    Texts_Mastermind texts_Mastermind = new Texts_Mastermind();

    // Instance : "Display_Array_Defense"
    Display_Array_Defense display_Array_Defense = new Display_Array_Defense();



    /**
     * Lancement du jeu "Mastermind"
     *
     * @param al_Configuration : (ArrayList) Valeurs de configuration
     * @param array_str_Main_Menu_Choices : (String[]) Choix du menu principal
     */
    public void mastermind_Launcher(boolean boo_DevMode, ArrayList al_Configuration, String array_str_Main_Menu_Choices[]) {

        // Récupération des valeurs de configuration
        int int_Mastermind_NumberOfUnities = (int) al_Configuration.get(3);
        int int_Mastermind_NumberOfLetters = (int) al_Configuration.get(4);
        int int_Mastermind_NumberOfChances = (int) al_Configuration.get(5);
        logger.info("Récupération des valeurs de configuration");



        // Initialisation (String) Sous-mode en mode "Duel"
        String str_Sub_Mode = new String();
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



        // Instance (ArrayList) Données challenger
        ArrayList al_Mastermind_Challenger = new ArrayList();
        logger.info("Instance (ArrayList) Données défense");

        // Injection (char[]) Lettres sélectionnées pour le jeu dans données défense
        al_Mastermind_Challenger.add(0, array_ch_SelectedLetters);
        logger.debug("Injection (char[]) Lettres sélectionnées pour le jeu dans données défense : " + Arrays.toString(array_ch_SelectedLetters));

        // Initialisation et injection (char[]) Combinaison secrète
        char array_ch_RandomNumber[] = new char[int_Mastermind_NumberOfUnities];
        al_Mastermind_Challenger.add(1, array_ch_RandomNumber);
        logger.info("Initialisation et injection (char[]) Combinaison secrète");

        // Initialisation et injection (int[]) Nombre de chaque lettre dans la combinaison
        int array_int_NumberOfEachLettersInCombinasion_Challenger[] = new int[int_Mastermind_NumberOfUnities];
        al_Mastermind_Challenger.add(2, array_int_NumberOfEachLettersInCombinasion_Challenger);
        logger.info("Initialisation et injection (int[]) Nombre de chaque lettre dans la combinaison");

        // Initialisation et injection (int) Compteur de tours
        int int_NumberOfRoundsCounter_Challenger = 0;
        al_Mastermind_Challenger.add(3, int_NumberOfRoundsCounter_Challenger);
        logger.info("Initialisation et injection (int) Compteur de chances");

        // Initialisation case vide
        String str_NULL = "Null";
        al_Mastermind_Challenger.add(4, str_NULL);

        // Initialisation et injection (char[]) Nouvelle proposition de l'utilisateur
        char array_ch_NewPlayerProposal_Challenger[] = new char[int_Mastermind_NumberOfUnities];
        al_Mastermind_Challenger.add(5, array_ch_NewPlayerProposal_Challenger);
        logger.info("Initialisation et injection (char[]) Nouvelle proposition de l'ordinateur");

        // Initialisation case vide
        al_Mastermind_Challenger.add(6, str_NULL);

        // Initialisation et injection (int[]) Nouvelle comparaison
        int array_int_NewComparisonResult_Challenger[] = new int[3];
        al_Mastermind_Challenger.add(7, array_int_NewComparisonResult_Challenger);
        logger.info("Initialisation et injection (int[]) Nouvelle comparaison");

        // Initialisation case vide
        al_Mastermind_Challenger.add(8, str_NULL);

        // Initialisation case vide
        al_Mastermind_Challenger.add(9, str_NULL);

        // Initialisation et injection (boolean[]) Lettres de la combinaison trouvées
        boolean array_boo_FoundLetters_Challenger[] = new boolean[int_Mastermind_NumberOfUnities];
        al_Mastermind_Challenger.add(10, array_boo_FoundLetters_Challenger);
        logger.info("Initialisation et injection (boolean[]) Lettres de la combinaison trouvées");



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
                    str_Sub_Mode = "Défense";
                    logger.debug("Màj - (String) Sous-mode (Pour mode \"Duel\") : " + str_Sub_Mode);
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
                    texts_Mastermind.display_Defense_Statement(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, array_ch_SelectedLetters);



                    // Affiche "A vous de jouer !"
                    texts_Games.display_A_VOUS_DE_JOUER();



                    // Initialisation (boolean) La combinaison est validée
                    boolean boo_Combination_Treatment = false;
                    logger.debug("Initialisation (boolean) La combinaison est validée : " + boo_Combination_Treatment);

                    // DO {} WHILE - La combinaison n'est pas validée
                    logger.info("DO {} WHILE - La combinaison n'est pas validée");
                    do {

                        // Lance le scanner pour la combinaison
                        Scanner sc_Combination = methods_Games.run_sc_Combination(array_str_Main_Menu_Choices, str_Sub_Mode);
                        logger.info("Lance le scanner pour la combinaison");

                        // Vérifie que la combinaison ne contient que des lettres
                        String str_Combination_Regex = methods_Mastermind.run_Combination_Regex(int_Mastermind_NumberOfLetters, array_str_Main_Menu_Choices, str_Sub_Mode, array_ch_SelectedLetters, sc_Combination);
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
                array_int_NewComparisonResult = defense_Mastermind.run_al_NewComparisonResult(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, str_Sub_Mode, al_Mastermind_Defense);
                logger.info("Lancement de la comparaison entre la proposition de l'ordinateur et la combinaison secrète");

                // Affichage résultat de la comparaison
                texts_Mastermind.display_RESULTAT_DE_LA_COMPARAISON(array_int_NewComparisonResult);

                // Injection (int[]) Nouvelle Comparaison
                al_Mastermind_Defense.set(7, array_int_NewComparisonResult);
                logger.info("Injection (int[]) Nouvelle Comparaison");




                // IF - Le nombre de lettres bien placées = Au nombre d'unités utilisé pour les combinaisons
                if (array_int_NewComparisonResult[0] == int_Mastermind_NumberOfUnities) {

                    // SI - Mode "Défense"
                    if (array_str_Main_Menu_Choices[1].equals("Défense")) {
                        logger.info("SI - Mode \"Défense\"");

                        // Affiche "Il a gagné"
                        graphism.display_HE_WON();

                        // MàJ - (boolean) Partie gagnée
                        boo_Won_Part = true;
                        logger.debug("MàJ - (boolean) Partie gagnée");

                        logger.trace("##########################");
                        logger.trace("### END ### Mode \"Défense\"");
                        logger.trace("##########################");

                        break;
                    }



                    // SINON - Mode "Duel"
                    else {
                        logger.info("SINON - Mode \"Duel\"");

                        // MàJ - (boolean) Il a trouvé la combinaison secrète
                        boo_HE_WON = true;

                        // Affiche "C'est votre dernière chance !"
                        texts_Games.display_C_EST_VOTRE_DERNIERE_CHANCE();

                        // Compteur de tours au dernier tour
                        i = int_Mastermind_NumberOfChances - 1;
                        logger.info("Compteur de tours au dernier tour");
                    }
                }
                // ELSE - Affiche le nombre de chances restantes
                else {
                    logger.info("ELSE - Affiche le nombre de chances restantes");

                    // Récupération (int) Compteur de tours
                    int_NumberOfRoundsCounter = (int) al_Mastermind_Defense.get(3);
                    logger.info("Récupération (int) Nombre de tours restants");

                    // Incrémentation += 1 Compteur de tours
                    int_NumberOfRoundsCounter += 1;
                    logger.debug("Incrémentation += 1 Compteur de tours : " + int_NumberOfRoundsCounter);

                    // Injection (int) Compteur de tours
                    al_Mastermind_Defense.set(3, int_NumberOfRoundsCounter);
                    logger.info("Injection (int) Compteur de tours");

                    // Affichage du nombre de chances restantes
                    texts_Games.display_RemainingChances(int_Mastermind_NumberOfChances, array_str_Main_Menu_Choices, str_Sub_Mode, int_NumberOfRoundsCounter);
                }

                // IF - Après premier tour
                if (i > 0) {
                    logger.info("IF - Après premier tour");

                    // Lancement de la comparaison des comparaisons
                    al_Mastermind_Defense = defense_Mastermind.run_al_ComparisonOfComparisonResults(al_Mastermind_Defense);
                    logger.info("Lancement de la comparaison des comparaisons");

                    // Récupération (char[]) Comparaison des comparaisons
                    array_ch_ComparisonOfComparisonResults = (char[]) al_Mastermind_Defense.get(8);
                    logger.debug("Récupération (char[]) Comparaison des comparaisons : " + Arrays.toString(array_ch_ComparisonOfComparisonResults));



                    // IF - "=" apparaît
                    if (array_ch_ComparisonOfComparisonResults[0] == '=') {
                        logger.info("IF - \"=\" apparaît");

                        al_Mastermind_Defense = defense_Mastermind.run_PositiveEquality(int_Mastermind_NumberOfLetters, al_Mastermind_Defense);
                        logger.info("Lancement égalité positive");
                    }



                    // IF - "≠" n'est pas apparu et que "=" a disparu
                    if (array_ch_ComparisonOfComparisonResults[0] != '≠' && array_ch_ComparisonOfComparisonResults[1] == '=') {
                        logger.info("IF - \"≠\" n'est pas apparu et que \"=\" a disparu");

                        // Lancement égalité négative
                        al_Mastermind_Defense = defense_Mastermind.run_NegativeEquality(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, str_Sub_Mode, al_Mastermind_Defense);
                        logger.info("Lancement égalité négative");
                    }



                    // IF - "≠" apparaît
                    if (array_ch_ComparisonOfComparisonResults[0] == '≠') {
                        logger.info("IF - \"≠\" apparaît");

                        // Lancement différence positive
                        al_Mastermind_Defense = defense_Mastermind.run_PositiveDifference(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, int_Mastermind_NumberOfChances, array_str_Main_Menu_Choices, str_Sub_Mode, al_Mastermind_Defense, i, boo_Won_Part, boo_HE_WON);
                        logger.info("Lancement différence positive");
                    }



                    // IF - "≠" disparaît
                    if (array_ch_ComparisonOfComparisonResults[0] == '≠') {
                        logger.info("IF - \"≠\" disparaît");

                        // Lancement différence négative
                        //al_Mastermind_Defense = defense_Mastermind.run_NegativeDifference(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, int_Mastermind_NumberOfChances, array_str_Main_Menu_Choices, str_SubMode, al_Mastermind_Defense, i, boo_Won_Part, boo_HE_WON);
                        //al_Mastermind_Defense = defense_Mastermind.run_NegativeDifference(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, int_Mastermind_NumberOfChances, array_str_Main_Menu_Choices, str_SubMode, al_Mastermind_Defense, i, boo_Won_Part, boo_HE_WON);
                        logger.info("Lancement différence négative");
                    }
                }

                logger.trace("##########################");
                logger.trace("<<< END >>> Mode \"Défense\"");
                logger.trace("##########################\n");
            }



            if (array_str_Main_Menu_Choices[1].equals("Challenger") || array_str_Main_Menu_Choices[1].equals("Duel")) {

                logger.trace("###############################");
                logger.trace("### START ### Mode \"Challenger\"");
                logger.trace("###############################");

                // SI - Mode "Duel"
                if (array_str_Main_Menu_Choices[1].equals("Duel")) {
                    logger.info("SI - Node \"Duel\"");

                    // Màj - (String) Sous-mode (Pour mode "Duel")
                    str_Sub_Mode = "Challenger";
                    logger.debug("Màj - (String) Sous-mode (Pour mode \"Duel\") : " + str_Sub_Mode);
                }



                if (i == 0) {

                    // Génération de la combinaison secrète
                    array_ch_RandomNumber = challenger_Mastermind.run_array_ch_RandomLetter(boo_DevMode, int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, al_Mastermind_Challenger);
                    logger.info("Génération de la combinaison secrète");

                    // Injection (char[]) Combinaison secrète
                    al_Mastermind_Challenger.set(1, array_ch_RandomNumber);



                    array_int_NumberOfEachLettersInCombinasion_Challenger = methods_Mastermind.run_array_int_NumberOfEachLetters(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, array_ch_SelectedLetters, array_ch_RandomNumber);
                    al_Mastermind_Challenger.set(2, array_int_NumberOfEachLettersInCombinasion_Challenger);



                    texts_Mastermind.display_Challenger_Statement(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, int_Mastermind_NumberOfChances, boo_DevMode, al_Mastermind_Challenger);

                }

                texts_Games.display_A_VOUS_DE_JOUER();



                // Initialisation (String) Combinaison en lettres capitales
                String str_Combination_Challenger_UpperCase = new String();
                logger.info("Initialisation (String) Combinaison en lettres capitales");

                // Initialisation (boolean) La combinaison est validée
                boolean boo_Combination_Treatment = false;
                logger.debug("Initialisation (boolean) La combinaison est validée : " + boo_Combination_Treatment);



                // DO {} WHILE - La combinaison n'est pas validée
                logger.info("DO {} WHILE - La combinaison n'est pas validée");
                do {

                    // Lance le scanner pour la combinaison
                    Scanner sc_Combination = methods_Games.run_sc_Combination(array_str_Main_Menu_Choices, str_Sub_Mode);
                    logger.info("Lance le scanner pour la combinaison");

                    // Vérifie que la combinaison ne contient que des lettres
                    String str_Combination_Regex = methods_Mastermind.run_Combination_Regex(int_Mastermind_NumberOfLetters, array_str_Main_Menu_Choices, str_Sub_Mode, array_ch_SelectedLetters, sc_Combination);
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
                al_Mastermind_Challenger.set(5, array_ch_Combination);
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



                // Lancement de la comparaison entre votre proposition et la combinaison secrète
                array_int_NewComparisonResult = challenger_Mastermind.run_al_NewComparisonResult(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, al_Mastermind_Challenger);
                logger.info("Lancement de la comparaison entre votre proposition et la combinaison secrète");

                // Affichage résultat de la comparaison
                texts_Mastermind.display_RESULTAT_DE_LA_COMPARAISON(array_int_NewComparisonResult);

                // Injection (int[]) Nouvelle Comparaison
                al_Mastermind_Defense.set(7, array_int_NewComparisonResult);
                logger.info("Injection (int[]) Nouvelle Comparaison");



                // IF - Mode "Challenger" && Le résultat de la comparaison = résultat gagnant
                if (array_str_Main_Menu_Choices[1] == "Challenger" && array_int_NewComparisonResult[0] == int_Mastermind_NumberOfUnities) {
                    logger.info("// IF - Mode \"Challenger\" && Le résultat de la comparaison = résultat gagnant");

                    // Affiche "Vous avez gagné !"
                    graphism.display_YOU_WON();

                    // MàJ - (boolean) Partie gagnée
                    boo_Won_Part = true;
                    logger.debug("MàJ - (boolean) Partie gagnée : " + boo_Won_Part);

                    logger.trace("#############################");
                    logger.trace("### END ### Mode \"Challenger\"");
                    logger.trace("#############################");

                    break;

                }

                // ELSE IF - En mode "Duel", le résultat de la comparaison = résultat gagnant && Que l'ordinateur n'a pas gagné
                else if (array_int_NewComparisonResult[0] == int_Mastermind_NumberOfChances && !boo_HE_WON) {
                    logger.info("ELSE IF - En mode \"Duel\", le résultat de la comparaison = résultat gagnant && Que l'ordinateur n'a pas gagné");

                    // Affiche (Vous avez gagné !)
                    graphism.display_YOU_WON();

                    // MàJ - (boolean) Partie gagnée
                    boo_Won_Part = true;
                    logger.debug("MàJ - (boolean) Partie gagnée : " + boo_Won_Part);

                    logger.trace("#######################");
                    logger.trace("### END ### Mode \"Duel\"");
                    logger.trace("#######################\n");

                    break;

                }

                // ELSE IF - En mode "Duel", le résultat de la comparaison = résultat gagnant && Que l'ordinateur a gagné
                else if (array_int_NewComparisonResult[0] == int_Mastermind_NumberOfChances && boo_HE_WON) {
                    logger.info("ELSE IF - En mode \"Duel\", le résultat de la comparaison = résultat gagnant && Que l'ordinateur a gagné");

                    // Affiche "Match nul !"
                    graphism.display_DRAW();

                    // MàJ - (boolean) Partie gagnée
                    boo_Won_Part = true;
                    logger.debug("MàJ - (boolean) Partie gagnée : " + boo_Won_Part);

                    logger.trace("#######################");
                    logger.trace("### END ### Mode \"Duel\"");
                    logger.trace("#######################");

                    break;

                }

                // ELSE IF - En mode "Duel", le résultat de la comparaison ≠ résultat gagnant && Que l'ordinateur a gagné
                else if (boo_HE_WON) {
                    logger.info("ELSE IF - En mode \"Duel\", le résultat de la comparaison ≠ résultat gagnant && Que l'ordinateur a gagné");

                    // AFFICHE "Il a gagné !"
                    graphism.display_HE_WON();

                    // MàJ - (boolean) Partie gagnée
                    boo_Won_Part = true;
                    logger.debug("MàJ - (boolean) Partie gagnée : " + boo_Won_Part);

                    break;
                }

            }
        }

        // IF - La partie n'est pas gagnée
        if (!boo_Won_Part) {
            logger.info("IF - La partie n'est pas gagnée");

            // SWITCH - Mode du jeu "Recherche +/-"
            logger.info("SWITCH - Mode du jeu \"Recherche +/-\"");
            switch (array_str_Main_Menu_Choices[1]) {

                // CASE - Mode "Challenger"
                case "Challenger":
                    logger.info("CASE - Mode \"Challenger\"");

                    // Affiche la solution
                    texts_Mastermind.display_LA_COMBINAISON_ETAIT(int_Mastermind_NumberOfUnities, array_ch_RandomNumber);

                    // Affiche "Vous avez perdu ..."
                    graphism.display_YOU_LOOSE();

                    logger.trace("#############################");
                    logger.trace("### END ### Mode \"Challenger\"");
                    logger.trace("#############################");

                    break;

                // CASE - Mode "Défense"
                case "Défense":
                    logger.info("CASE - Mode \"Défense\"");

                    // Affiche "Il a perdu ..."
                    graphism.display_HE_LOOSE();

                    logger.trace("##########################");
                    logger.trace("### END ### Mode \"Défense\"");
                    logger.trace("##########################");

                    break;

                // CASE - Mode "Duel"
                case "Duel":
                    logger.info("CASE - Mode \"Duel\"");

                    // Affiche la solution
                    texts_Mastermind.display_LA_COMBINAISON_ETAIT(int_Mastermind_NumberOfUnities, array_ch_RandomNumber);

                    // Affiche "Vous avez perdu ..."
                    graphism.display_YOU_LOOSE();

                    logger.trace("#######################");
                    logger.trace("### END ### Mode \"Duel\"");
                    logger.trace("#######################");

                    break;
            }
        }
    }
}
