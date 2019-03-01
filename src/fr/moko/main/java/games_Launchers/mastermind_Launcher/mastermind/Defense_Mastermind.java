package fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



/**
 * Méthodes attenantes au mode "Défense" du jeu "Mastermind"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Defense_Mastermind {

    // Instance "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance : "Defense_Methods_Mastermind"
    Defense_Methods_Mastermind defense_Methods_Mastermind = new Defense_Methods_Mastermind();



    /**
     * Lancement du mode "Défense"
     *
     * @param int_Mastermind_NumberOfUnities   : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_Mastermind_NumberOfLetters   : (int) Nombre de lettres utilisées pour les combinaisons
     * @param array_str_Main_MenuChoices : (String[]) Choix du menu principal
     * @param i                     : (int) Nombre de tours
     * @param al_Mastermind_Defense : (ArrayList) Données défense
     *
     * @return : (ArrayList) Données défense
     */
    public ArrayList run_Defense(int int_Mastermind_NumberOfUnities, int int_Mastermind_NumberOfLetters, String array_str_Main_MenuChoices[], int i, ArrayList al_Mastermind_Defense) {

        logger.trace("#####################################");
        logger.trace("<<< START >>> Méthode : run_Defense()");
        logger.trace("#####################################");

        // IF - Premier tour
        if (i == 0) {
            logger.info("IF - Premier tour");

            // Lancement première proposition de l'ordinateur
            al_Mastermind_Defense = run_al_FirstTypeComputerProposal(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, al_Mastermind_Defense);
            logger.info("Lancement première proposition de l'ordinateur");
        }



        // IF - Aprés deuxième tour
        if (i > 0) {
            logger.trace("IF - Aprés deuxième tour");

            // Lancement deuxième type de proposition de l'ordinateur
            al_Mastermind_Defense = run_al_SecondTypeComputerProposal(int_Mastermind_NumberOfUnities, int_Mastermind_NumberOfLetters, al_Mastermind_Defense);
            logger.info("Lancement deuxième type de proposition de l'ordinateur");
        }

        logger.trace("###################################");
        logger.trace("<<< END >>> Méthode : run_Defense()");
        logger.trace("###################################\n");

        return al_Mastermind_Defense;
    }



    /**
     * Première proposition de l'ordinateur
     *
     * @param int_Mastermind_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_Mastermind_NumberOfLetters : (int) Nombre de lettres utilisées pour les combinaisons
     * @param al_Mastermind_Defense : (ArrayList) Données défense
     *
     * @return : (ArrayList) Données de défense
     */
    public ArrayList run_al_FirstTypeComputerProposal(int int_Mastermind_NumberOfUnities, int int_Mastermind_NumberOfLetters, ArrayList al_Mastermind_Defense) {

        logger.trace("##########################################################");
        logger.trace("<<< START >>> Méthode : run_al_FirstTypeComputerProposal()");
        logger.trace("##########################################################");

        // Récupération (char[]) Récupération des lettres sélectionnées pour le jeu
        char array_ch_SelectedLetters[] = (char[]) al_Mastermind_Defense.get(0);
        logger.debug("Récupération (char[]) Récupération des lettres sélectionnées pour le jeu");

        // Initialisation (char[]) Nouvelle proposition de l'ordinateur
        char array_ch_NewComputerProposal[] = new char[int_Mastermind_NumberOfUnities];
        logger.info("Initialisation (char[]) Nouvelle proposition de l'ordinateur");

        // FOR - Remplie le tableau de lettres choisies de manière aléatoire
        for (int i = 0; i < int_Mastermind_NumberOfUnities; i++) {

            // Intance "Random"
            Random random = new Random();

            // Initialisation (int) Nombre aléatoire
            int int_RandomNumber = random.nextInt(int_Mastermind_NumberOfLetters);

            // Injection (char[]) Nouvelle proposition de l'ordinateur
            array_ch_NewComputerProposal[i] = array_ch_SelectedLetters[int_RandomNumber];
        }

        logger.debug("Injection (char[]) Nouvelle proposition de l'ordinateur : " + Arrays.toString(array_ch_NewComputerProposal));

        // Injection mouvelle proposition de l'ordinateur dans données de défense
        al_Mastermind_Defense.set(5, array_ch_NewComputerProposal);
        logger.info("Injection mouvelle proposition de l'ordinateur dans données de défense");

        logger.trace("########################################################");
        logger.trace("<<< END >>> Méthode : run_al_FirstTypeComputerProposal()");
        logger.trace("########################################################\n");

        return al_Mastermind_Defense;
    }



    /**
     * Deuxième type de proposition de l'ordinateur
     *
     * @param int_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_NumberOfLetters : (int) Nombre de lettres utilisées pour les combinaisons
     * @param al_Mastermind_Defense : (ArrayList) Données défense
     *
     * @return : (ArrayList) Données de défense
     */
    public ArrayList run_al_SecondTypeComputerProposal(int int_NumberOfUnities, int int_NumberOfLetters, ArrayList al_Mastermind_Defense) {

        logger.trace("###########################################################");
        logger.trace("<<< START >>> Méthode : run_al_SecondTypeComputerProposal()");
        logger.trace("###########################################################");

        // Récupération (char) Lettres sélectionnées pour le jeu
        char array_ch_SelectedLetters[] = (char[]) al_Mastermind_Defense.get(0);
        logger.debug("Récupération (char) Lettres sélectionnées pour le jeu : " + Arrays.toString(array_ch_SelectedLetters));

        // array_ch_PreviousComputerProposal <- array_ch_NewComputerProposal
        al_Mastermind_Defense.set(4, al_Mastermind_Defense.get(5));
        logger.info("array_ch_PreviousComputerProposal <- array_ch_NewComputerProposal");

        // Récupération (char[]) Proposition précédente de l'ordinateur
        char array_ch_PreviousComputerProposal[] = (char[]) al_Mastermind_Defense.get(4);
        logger.debug("Récupération (char[]) Proposition précédente de l'ordinateur : " + Arrays.toString(array_ch_PreviousComputerProposal));

        // Récupération (char[]) Nouvelle proposition de l'ordinateur
        char array_ch_NewComputerProposal[] = (char[]) al_Mastermind_Defense.get(5);
        logger.debug("Récupération (char[]) Nouvelle proposition de l'ordinateur : " + Arrays.toString(array_ch_NewComputerProposal));

        // Récupération (boolean[]) Lettres de la combinaison trouvées
        boolean array_boo_FoundLetters[] = (boolean[]) al_Mastermind_Defense.get(10);
        logger.debug("Récupération (boolean[]) Lettres de la combinaison trouvées : " + Arrays.toString(array_boo_FoundLetters));

        // Initialisation (int) Position de remplacement
        int int_ReplacementPosition = 0;
        logger.debug("Initialisation (int) Position de remplacement : " + int_ReplacementPosition);

        // Initialisation (char) Lettre précédente
        char ch_PreviousLetter = ' ';
        logger.info("Initialisation (char) Lettre précédente");

        // FOR - Pour chaque unité du tableau des lettres trouvées
        for (int i = 0; i < int_NumberOfUnities; i++) {
            logger.info("FOR - Pour chaque unité du tableau des lettres trouvées");

            // IF - Si la lettre n'a pas encore été encore trouvée à cette position
            if (array_boo_FoundLetters[i] == false) {
                logger.info("IF - Si la lettre n'a pas encore été encore trouvée à cette position");

                // MàJ - (int) Position de remplacement
                int_ReplacementPosition = i;
                logger.debug("MàJ - (int) Position de remplacement : " + int_ReplacementPosition);

                // MàJ - (char) La lettre sélectionnées dans la combinaison, devient la lettre précédente
                ch_PreviousLetter = array_ch_NewComputerProposal[i];
                logger.debug(" MàJ - (char) La lettre sélectionnées dans la combinaison, devient la lettre précédente : " + ch_PreviousLetter);

                break;
            }
        }

        // Initialisation (char) Nouvelle lettre
        char ch_NewLetter = ' ';
        logger.info("Initialisation (char) Nouvelle lettre");

        // FOR - Chaque lettre sélectionnée pour le jeu
        logger.info("FOR - Chaque lettre sélectionnée pour le jeu");
        for (int i = 0; i < int_NumberOfLetters; i++) {

            // IF - La lettre précédente = lettre sélectionnée pour le jeu
            if (ch_PreviousLetter == array_ch_SelectedLetters[i]) {
                logger.info("IF - La lettre précédente = lettre sélectionnée pour le jeu");

                int int_IndexOfPreviousLetter = defense_Methods_Mastermind.run_int_IndexOfLetter(int_NumberOfLetters, al_Mastermind_Defense, ch_PreviousLetter);

                // Récupération (char[]) Analyse de la défense
                char array_ch_DefenseAnalys[][] = (char[][]) al_Mastermind_Defense.get(9);
                logger.info("Récupération (char[]) Analyse de la défense");

                // Initialisation (int) Index de la lettre
                int int_IndexOfNewLetter = 0;
                logger.debug("Initialisation (int) Index de la lettre : " + int_IndexOfNewLetter);

                // Initialisition (char) Lettre initiale
                char ch_InitialLetter = ch_PreviousLetter;
                logger.info("Initialisition (char) Lettre initiale");

                // Initialisation (char) Lettre suivante
                char ch_NextLetter = ' ';
                logger.info("Initialisation (char) Lettre suivante");

                int int_IndexOfInitialLetter = int_IndexOfPreviousLetter;

                // Initialisation (int) Index de la lettre suivante
                int int_IndexOfNextLetter = 0;

                //
                //
                //
                //
                //
                //
                //
                //
                //
                //
                //
                //
                // DO {} WHILE : La lettre n'a pas encore été testée à cette position
                logger.info("DO {} WHILE : La lettre n'a pas encore été testée à cette position");
                do {

                    int_IndexOfNextLetter = int_IndexOfNewLetter;


                    // Définition de la lettre suivante
                    logger.info("Définition de la lettre suivante");
                    ch_NextLetter = defense_Methods_Mastermind.run_NextLetter(int_NumberOfLetters, array_ch_SelectedLetters, int_IndexOfInitialLetter, ch_NextLetter);

                    // Lancement index de la lettre suivante
                    int_IndexOfNextLetter = defense_Methods_Mastermind.run_int_IndexOfLetter(int_NumberOfLetters, al_Mastermind_Defense, ch_NewLetter);
                    logger.info("Lancement index de la nouvelle lettre");

                    ch_InitialLetter = ch_NextLetter;

                    int_IndexOfInitialLetter = int_IndexOfNextLetter;

                } while (array_ch_DefenseAnalys[int_IndexOfNextLetter][int_ReplacementPosition] != ' ');

                ch_NewLetter = ch_NextLetter;

                // MàJ - (char[]) Nouvelle lettre dans la nouvelle combinaison de l'ordinateur
                array_ch_NewComputerProposal[int_ReplacementPosition] = ch_NewLetter;
                logger.info("MàJ - (char[]) Nouvelle lettre dans la nouvelle combinaison de l'ordinateur");

                // Injection (char[]) Nouvelle proposition de l'ordinateur
                al_Mastermind_Defense.set(5, array_ch_NewComputerProposal);
                logger.info("MàJ - (char[]) Nouvelle proposition de l'ordinateur");

                // Injection (int) Position de remplacement
                al_Mastermind_Defense.set(11, int_ReplacementPosition);
                logger.info("MàJ - (int) Position de remplacement");

                // Injection (char) Lettre précédente
                al_Mastermind_Defense.set(12, ch_PreviousLetter);
                logger.info("MàJ - (char) Lettre précédente");

                // Injection (char) Nouvelle lettre
                al_Mastermind_Defense.set(13, ch_NewLetter);
                logger.info(" MàJ - (char) Nouvelle lettre");
            }
        }



        logger.trace("#########################################################");
        logger.trace("<<< END >>> Méthode : run_al_SecondTypeComputerProposal()");
        logger.trace("#########################################################\n");

        return al_Mastermind_Defense;
    }


    /**
     *  Comparaison de la proposition de l'ordinateur avec la combinaision secrète
     *
     * @param int_Mastermind_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_Mastermind_NumberOfLetters : (int) Nombre de lettres utilisées pour les combinaisons
     * @param al_Mastermind_Defense : (ArrayList) Données défense
     *
     * @return : (ArrayList) Données de défense
     */
    public int[] run_al_NewComparisonResult(int int_Mastermind_NumberOfUnities, int int_Mastermind_NumberOfLetters, String str_SubMode, ArrayList al_Mastermind_Defense) {

        logger.trace("####################################################");
        logger.trace("<<< START >>> Méthode : run_al_NewComparisonResult()");
        logger.trace("####################################################");

        // Récupération (char[]) Lettres sélectionnées pour le "Mastermind"
        char array_ch_SelectedLetters[] = (char[]) al_Mastermind_Defense.get(0);
        logger.debug("Récupération (char[]) Lettres sélectionnées pour le \"Mastermind\" : " + Arrays.toString(array_ch_SelectedLetters));

        // Récupération (char[]) Combinaison secrète
        char array_ch_Combination[] = (char[]) al_Mastermind_Defense.get(1);
        logger.debug("Récupération (char[]) Combinaison secrète : " + Arrays.toString(array_ch_Combination));

        // Récupération (int[]) Nombre de chaque lettre dans la combinaison
        int array_int_NumberOfEachLettersInCombinaison[] = (int[]) al_Mastermind_Defense.get(2);
        logger.debug("Récupération (int[]) Nombre de chaque lettre dans la combinaison : " + Arrays.toString(array_int_NumberOfEachLettersInCombinaison));

        // Récupération (char[])  Nouvelle proposition de l'ordinateur
        char array_ch_NewComputerProposal[] = (char[]) al_Mastermind_Defense.get(5);
        logger.debug("Récupération (char[])  Nouvelle proposition de l'ordinateur : " + Arrays.toString(array_ch_NewComputerProposal));

        if (str_SubMode != "Challenger") {

            //array_int_PreviousComparisonResult <- array_int_NewCoparisonResult
            al_Mastermind_Defense.set(6, al_Mastermind_Defense.get(7));
            logger.info("array_int_PreviousComparisonResult <- array_int_NewCoparisonResult");
        }

        // Initilisation (int[]) Nouvelle comparaison
        int array_int_NewComparisonResult[] = new int[3];
        logger.debug("IInitilisation (int[]) Nouvelle comparaison : " + Arrays.toString(array_int_NewComparisonResult));

        // Injection (int[]) Nouvelle comparaison
        al_Mastermind_Defense.set(7, array_int_NewComparisonResult);
        logger.info("Injection (int[]) Nouvelle comparaison");

        // Récupération (boolean[]) lettres trouvées
        boolean array_boo_FoundLetters[] = (boolean[]) al_Mastermind_Defense.get(10);
        logger.debug("Récupération (boolean[]) lettres trouvées : " + Arrays.toString(array_boo_FoundLetters));

        // Initialisation (int[]) Compteur de lettres dans la combinaison secrète
        int array_int_CountingLetters[] = new int[int_Mastermind_NumberOfLetters];
        logger.debug("Initialisation (int[]) Compteur de lettres dans la combinaison secrète : " + Arrays.toString(array_int_CountingLetters));

        // Initialisation (boolean[]) Unités de la proposition de l'ordinateur déjà vérifiées
        boolean array_boo_AlreadyVerifiedProposal[] = new boolean[int_Mastermind_NumberOfUnities];
        logger.debug("Initialisation (boolean[]) Unités de la proposition de l'ordinateur déjà vérifiées : " + Arrays.toString(array_boo_AlreadyVerifiedProposal));

        // Initialisation (boolean[]) Unités de la combinaison secrète déjà vérifiées
        boolean array_boo_AlreadyVerifiedCombinaison[] = new boolean[int_Mastermind_NumberOfUnities];
        logger.debug("Initialisation (boolean[]) Unités de la combinaison secrète déjà vérifiées : " + Arrays.toString(array_boo_AlreadyVerifiedCombinaison));



        logger.trace("<<< 1st Part >>> Méthode : run_al_NewComparisonResult() : Lettres déjà trouvées");

        // FOR - Chaque unité
        logger.info("FOR - Chaque unité");
        for (int i = 0; i < int_Mastermind_NumberOfUnities; i++) {

            // IF - La lettre est déjà trouvée à cette position
            if (array_boo_FoundLetters[i] == true) {
                logger.info("IF - La lettre est déjà trouvée à cette position");

                // Incrémentation += 1 Nouvelle comparaison (lettre bien placée)
                array_int_NewComparisonResult[0] += 1;
                logger.debug("Incrémentation += 1 Nouvelle comparaison (lettre bien placée) : " + Arrays.toString(array_int_NewComparisonResult));

                // Initialisation (char) Lettre sélectionnée
                char ch_SelectedLetter = array_ch_NewComputerProposal[i];
                logger.debug("Initialisation (char) Lettre sélectionnée : " + ch_SelectedLetter);

                // Définition (int) Index de la lettre sélectionnée
                int int_IndexOfSelectedLetter = defense_Methods_Mastermind.run_int_IndexOfLetter(int_Mastermind_NumberOfLetters, al_Mastermind_Defense, ch_SelectedLetter);
                logger.debug("Définition (int) Index de la lettre sélectionnée : " + int_IndexOfSelectedLetter);

                // MàJ - (boolean[]) Unité de la proposition de l'ordinateur déjà vérifiée
                array_boo_AlreadyVerifiedProposal[i] = true;
                logger.debug("MàJ - (boolean[]) Unité de la proposition de l'ordinateur déjà vérifiée : " + Arrays.toString(array_boo_AlreadyVerifiedProposal));

                // MàJ - (boolean[]) Unité de la combinaison secrète déjà vérifiée
                array_boo_AlreadyVerifiedCombinaison[i] = true;
                logger.debug("MàJ - (boolean[]) Unité de la combinaison secrète déjà vérifiée : " + Arrays.toString(array_boo_AlreadyVerifiedCombinaison));

                // Incrémentation (int[]) Compteur de lettres
                array_int_CountingLetters[int_IndexOfSelectedLetter] += 1;
                logger.debug("Incrémentation (int[]) Compteur de lettres : " + Arrays.toString(array_int_CountingLetters));
            }
        }

        logger.trace("<<< 2nd Part >>> Méthode : run_al_NewComparisonResult() : Lettres bien placées mais pas trouvées");

        // FOR - Chaque unité
        logger.info("FOR - Chaque unité");
        for (int i = 0; i < int_Mastermind_NumberOfUnities; i++) {

            // IF - L'unité contient la bonne lettre à cette position && La lettre n'est pas encore trouvée
            if (array_ch_NewComputerProposal[i] == array_ch_Combination[i] && array_boo_FoundLetters[i] == false) {
                logger.info("IF - L'unité contient la bonne lettre à cette position && La lettre n'est pas encore trouvée");

                // Incrémentation (int[]) Résultat de la comparaison (lettre bien placée)
                array_int_NewComparisonResult[0] += 1;
                logger.debug("Incrémentation (int[]) Résultat de la comparaison (lettre bien placée) : " + Arrays.toString(array_int_NewComparisonResult));

                // Initialisation (char) Lettre sélectionnée
                char ch_SelectedLetter = array_ch_NewComputerProposal[i];
                logger.debug("Initialisation (char) Lettre sélectionnée (lettre bien placée) : " + ch_SelectedLetter);

                // Définition (int) Index de la lettre sélectionnée
                int int_IndexOfSelectedLetter = defense_Methods_Mastermind.run_int_IndexOfLetter(int_Mastermind_NumberOfLetters, al_Mastermind_Defense, ch_SelectedLetter);
                logger.debug("Définition (int) Index de la lettre sélectionnéee : " + int_IndexOfSelectedLetter);

                // MàJ - (boolean[]) Unité de la proposition de l'ordinateur déjà vérifiée
                array_boo_AlreadyVerifiedProposal[i] = true;
                logger.debug("MàJ - (boolean[]) Unité de la proposition de l'ordinateur déjà vérifiée : " + Arrays.toString(array_boo_AlreadyVerifiedProposal));

                // MàJ - (boolean[]) Unité de la combinaison secrète déjà vérifiée
                array_boo_AlreadyVerifiedCombinaison[i] = true;
                logger.debug("MàJ - (boolean[]) Unité de la combinaison secrète déjà vérifiée : " + Arrays.toString(array_boo_AlreadyVerifiedCombinaison));

                // Incrémentation (int[]) Compteur de lettres
                array_int_CountingLetters[int_IndexOfSelectedLetter] += 1;
                logger.debug("Incrémentation (int[]) Compteur de lettres : " + Arrays.toString(array_int_CountingLetters));
            }
        }

        logger.trace("<<< 3rd Part >>> Méthode : run_al_NewComparisonResult() : Lettres mal placées et absentess");

        // FOR - Chaque unité
        logger.info("FOR - Chaque unité");
        for (int i = 0; i < int_Mastermind_NumberOfUnities; i++) {

            // IF - L'unité sélectionnée n'est pas encore vérifiée dans la proposition de l'ordinateur
            if (!array_boo_AlreadyVerifiedProposal[i]){
                logger.info("IF - L'unité sélectionnée n'est pas encore vérifiée dans la proposition de l'ordinateur");

                // Initialisation (char) Lettre sélectionnée
                char ch_SelectedLetter = array_ch_NewComputerProposal[i];
                logger.debug("Initialisation (char) Lettre sélectionnée : " + ch_SelectedLetter);

                // MàJ - (boolean[]) Unité de la proposition de l'ordinateur déjà vérifiée
                array_boo_AlreadyVerifiedProposal[i] = true;
                logger.debug("MàJ - (boolean[]) Unité de la proposition de l'ordinateur déjà vérifiée : " + Arrays.toString(array_boo_AlreadyVerifiedProposal));

                // FOR - Chaque unité
                logger.info("FOR - Chaque unité");
                for (int j = 0; j < int_Mastermind_NumberOfUnities; j++) {

                    // IF - Lettre sélectionnée dans la proposition de l'ordinateur = Lettre sélectionnée dans la combinaison secrète && unités à cette posiition de la combinaison secrète n'a pas encore été vérifiée
                    if (ch_SelectedLetter == array_ch_Combination[j] && !array_boo_AlreadyVerifiedCombinaison[j]) {
                        logger.info("IF - Lettre sélectionnée dans la proposition de l'ordinateur = Lettre sélectionnée dans la combinaison secrète && unités à cette posiition de la combinaison secrète n'a pas encore été vérifiée");

                        // MàJ - (boolean[]) Unité de la combinaison secrète déjà vérifiée
                        array_boo_AlreadyVerifiedCombinaison[j] = true;
                        logger.debug("MàJ - (boolean[]) Unité de la combinaison secrète déjà vérifiée : " + Arrays.toString(array_boo_AlreadyVerifiedCombinaison));

                        logger.debug("array_ch_Combination[j] : " + array_ch_Combination[j]);

                        // FOR - Chaque lettre sélectionnée pour le "Mastermind"
                        logger.info("FOR - Chaque lettre sélectionnée pour le \"Mastermind\"");
                        for (int k = 0; k < int_Mastermind_NumberOfLetters; k++) {

                            // IF - Lettre sélectionnée = La lettre contenue dans l'unitié sélectionnée des lettres choisies pour le "Mastermind"
                            if (ch_SelectedLetter == array_ch_SelectedLetters[k]) {
                                logger.info("IF - Lettre sélectionnée = La lettre contenue dans l'unitié sélectionnée des lettres choisies pour le \"Mastermind\"");

                                // Incrémentation += 1 Compteur de lettres
                                array_int_CountingLetters[k] += 1;
                                logger.debug("Initialisation (char) Lettre sélectionnée : " + Arrays.toString(array_int_CountingLetters));

                                // IF - Le nombre de le lettre sélectionnée dans la proposition de l'ordianteur <= Nombre de la lettre sélectionnée dans la combinaison secrète
                                if (array_int_CountingLetters[k] <= array_int_NumberOfEachLettersInCombinaison[k]){
                                    logger.info("IF - Le nombre de le lettre sélectionnée dans la proposition de l'ordianteur <= Nombre de la lettre sélectionnée dans la combinaison secrète");

                                    // Incrémentation += 1 Nouvelle comparaison (Lettre présente mais mal placée)
                                    array_int_NewComparisonResult[1] += 1;
                                    logger.debug("Incrémentation += 1 Nouvelle comparaison (Lettre présente mais mal placée) : " + Arrays.toString(array_int_NewComparisonResult));

                                    break;
                                }
                            }
                        }
                        break;
                    }

                    // IF - Toutes les unités vérifiées
                    if (j == int_Mastermind_NumberOfUnities - 1) {
                        logger.info("IF - Toutes les unités vérifiées");

                        // Incrémentation += 1 Nouvelle comparaison (Lettre non présente)
                        array_int_NewComparisonResult[2] += 1;
                        logger.debug("Incrémentation += 1 Nouvelle comparaison (Lettre non présente) : " + Arrays.toString(array_int_NewComparisonResult));
                    }
                }
            }
        }

        logger.debug("array_int_NewComparisonResult[] : " + Arrays.toString(array_int_NewComparisonResult));

        logger.trace("##################################################");
        logger.trace("<<< End >>> Méthode : run_al_NewComparisonResult()");
        logger.trace("##################################################\n");

        return array_int_NewComparisonResult;
    }



    /**
     * Comparaison entre les deux dernières comparaisons avec la combinaison secrète
     *
     * @param al_Defense : (ArrayList) Données défense
     *
     * @return : (ArrayList) Données de défense
     */
    public ArrayList run_al_ComparisonOfComparisonResults(ArrayList al_Defense) {

        logger.trace("##############################################################");
        logger.trace("<<< START >>> Méthode : run_al_ComparisonOfComparisonResults()");
        logger.trace("##############################################################");

        // Récupération (int[]) Comparaison précédente
        int array_int_PreviousComparisonResult[] = (int[]) al_Defense.get(6);
        logger.debug("Récupération (int[]) Comparaison précédente : " + Arrays.toString(array_int_PreviousComparisonResult));

        // Récupération (int[]) Nouvelle comparaison
        int array_int_NewComparisonResult[] = (int[]) al_Defense.get(7);
        logger.debug("Récupération (int[]) Nouvelle comparaison : " + Arrays.toString(array_int_NewComparisonResult));

        // Initialisation (char[]) Comparaison des comparaisons
        char array_ch_ComparisonOfComparisonResults[] = new char[2];
        logger.debug("Initialisation (char[]) Comparaison des comparaisons : " + Arrays.toString(array_int_NewComparisonResult));

        // Calcule de la différence de lettres bien placées
        int int_RightLetterRightPlace = array_int_NewComparisonResult[0] - array_int_PreviousComparisonResult[0];
        logger.debug("Calcule de la différence de lettres bien placées : " + int_RightLetterRightPlace);

        // Calcule de la différence de lettres présentes mais mal placées
        int int_RightLetterWrongPlace = array_int_NewComparisonResult[1] - array_int_PreviousComparisonResult[1];
        logger.debug("Calcule de la différence de lettres présentes mais mal placées : " + int_RightLetterWrongPlace);

        // Calcule de la différence de lettres non présentes
        int int_MissingLetter = array_int_NewComparisonResult[2] - array_int_PreviousComparisonResult[2];
        logger.debug("Calcule de la différence de lettres non présentes : " + int_MissingLetter);

        // IF - Plus une lettre bien placée / Moins une lettre présente mais à la mauvaise place
        if (int_RightLetterRightPlace == 1 && int_RightLetterWrongPlace == -1) {
            logger.info("ELSE IF - Plus une lettre bien placée / Moins une lettre présente mais à la mauvaise place");

            // MàJ - (char[]) Comparaison des comparaisons
            array_ch_ComparisonOfComparisonResults[0] = '=';
            array_ch_ComparisonOfComparisonResults[1] = '≠';
            logger.debug("MàJ - (char[]) Comparaison des comparaisons : " + Arrays.toString(array_ch_ComparisonOfComparisonResults));

        }
        // ELSE IF - Plus une lettre bien placée / Moins une lettre non présente
        else if (int_RightLetterRightPlace == 1 && int_MissingLetter == -1) {
            logger.info("ELSE IF - Plus une lettre bien placée / Moins une lettre non présente");

            // MàJ - (char[]) Comparaison des comparaisons
            array_ch_ComparisonOfComparisonResults[0] = '=';
            array_ch_ComparisonOfComparisonResults[1] = '-';
            logger.debug("MàJ - (char[]) Comparaison des comparaisons : " + Arrays.toString(array_ch_ComparisonOfComparisonResults));
        }
        // ELSE IF - Plus une lettre présente mais à la mauvaise place / Moins une lettre bien placée
        else if (int_RightLetterWrongPlace == 1 && int_RightLetterRightPlace == -1) {
            logger.info("ELSE IF - Plus une lettre présente mais à la mauvaise place / Moins une lettre bien placée");

            // MàJ - (char[]) Comparaison des comparaisons
            array_ch_ComparisonOfComparisonResults[0] = '≠';
            array_ch_ComparisonOfComparisonResults[1] = '=';
            logger.debug("MàJ - (char[]) Comparaison des comparaisons : " + Arrays.toString(array_ch_ComparisonOfComparisonResults));
        }
        // ELSE IF - Plus une lettre présente mais à la mauvaise place / Moins une lettre non présente
        else if (int_RightLetterWrongPlace == 1 && int_MissingLetter == -1) {
            logger.info("ELSE IF - Plus une lettre présente mais à la mauvaise place / Moins une lettre non présente");

            // MàJ - (char[]) Comparaison des comparaisons
            array_ch_ComparisonOfComparisonResults[0] = '≠';
            array_ch_ComparisonOfComparisonResults[1] = '-';
            logger.debug("MàJ - (char[]) Comparaison des comparaisons : " + Arrays.toString(array_ch_ComparisonOfComparisonResults));
        }
        // ELSE IF - Plus une lettre non présente / Moins une lettre bien placée
        else if (int_MissingLetter == 1 && int_RightLetterRightPlace == -1) {
            logger.info("ELSE IF - Plus une lettre non présente / Moins une lettre bien placée");

            // MàJ - (char[]) Comparaison des comparaisons
            array_ch_ComparisonOfComparisonResults[0] = '-';
            array_ch_ComparisonOfComparisonResults[1] = '=';
            logger.debug("MàJ - (char[]) Comparaison des comparaisons : " + Arrays.toString(array_ch_ComparisonOfComparisonResults));
        }
        // ELSE IF - Plus une lettre non présente / Moins une lettre présente mais à la mauvaise place
        else if (int_MissingLetter == 1 && int_RightLetterWrongPlace == -1) {
            logger.info("ELSE IF - Plus une lettre non présente / Moins une lettre présente mais à la mauvaise place");

            // MàJ - (char[]) Comparaison des comparaisons
            array_ch_ComparisonOfComparisonResults[0] = '-';
            array_ch_ComparisonOfComparisonResults[1] = '≠';
            logger.debug("MàJ - (char[]) Comparaison des comparaisons : " + Arrays.toString(array_ch_ComparisonOfComparisonResults));
        }
        // ELSE IF - Plus une lettre non présente && Plus une lettre présente mais à la mauvaise place
        else if (int_MissingLetter == 1 && int_MissingLetter == 1) {
            logger.info("ELSE IF - Plus une lettre non présente && Plus une lettre présente mais à la mauvaise place");

            // MàJ - (char[]) Comparaison des comparaisons
            array_ch_ComparisonOfComparisonResults[0] = '=';
            array_ch_ComparisonOfComparisonResults[1] = '-';
            logger.debug("MàJ - (char[]) Comparaison des comparaisons : " + Arrays.toString(array_ch_ComparisonOfComparisonResults));
        }
        // ELSE - Sinon ...
        else {
            logger.info("ELSE - Sinon ...");

            // MàJ - (char[]) Comparaison des comparaisons
            array_ch_ComparisonOfComparisonResults[0] = '-';
            array_ch_ComparisonOfComparisonResults[1] = '-';
            logger.debug("MàJ - (char[]) Comparaison des comparaisons : " + Arrays.toString(array_ch_ComparisonOfComparisonResults));
        }

        // Injection (char[]) Comparaison des comparaisons
        al_Defense.set(8, array_ch_ComparisonOfComparisonResults);
        logger.debug("Injection (char[]) Comparaison des comparaisons] : " + Arrays.toString(array_ch_ComparisonOfComparisonResults));


        logger.trace("############################################################");
        logger.trace("<<< END >>> Méthode : run_al_ComparisonOfComparisonResults()");
        logger.trace("############################################################\n");

        return al_Defense;
    }



    /**
     * Lorsque "=" apparaît
     *
     * @param int_NumberOfUnities  : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_NumberOfLetters : (int) Nombre de lettres utilisées pour les combinaisons
     * @param al_Defense : (ArrayList) Données défense
     *
     * @return : (ArrayList) Données de défense
     */
    public ArrayList run_PositiveEquality(int int_NumberOfUnities, int int_NumberOfLetters, ArrayList al_Defense) {

        logger.trace("##############################################");
        logger.trace("<<< START >>> Méthode : run_PositiveEquality()");
        logger.trace("##############################################");

        // Récupération (char[]) Lettres sélectionnées pour le "Mastermind"
        char array_ch_SelectedLetters[] = (char[]) al_Defense.get(0);
        logger.info("Récupération (char[]) Lettres sélectionnées pour le \"Mastermind\"");

        // array_int_PreviousComputerProposal <- array_int_NewComputerProposal
        al_Defense.set(4, al_Defense.get(5));
        logger.info("array_int_PreviousComputerProposal <- array_int_NewComputerProposal");

        // Récupération (char[][]) Analyse de la défense
        char array_ch_DefenseAnalysis[][] = (char[][]) al_Defense.get(9);
        logger.info("Récupération (char[][]) Analyse de la défense");

        // Récupération (int) Position de remplacement
        int int_ReplacementPosition = (int) al_Defense.get(11);
        logger.info("Récupération (int) Position de remplacemente");

        // Récupération (char) Nouvelle lettre
        char ch_NewLetter = (char) al_Defense.get(13);
        logger.info("Récupération (char) Nouvelle lettre");

        // Lancement index de la nouvelle lettre
        int int_IndexNewLetter = defense_Methods_Mastermind.run_int_IndexOfLetter(int_NumberOfLetters, al_Defense, ch_NewLetter);
        logger.info("Lancement index de la nouvelle lettre");

        // FOR - Pour chaque lettre sélectionnée pour le "Mastermind"
        for (int i = 0; i < int_NumberOfLetters; i++) {
            logger.info("FOR - Pour chaque lettre sélectionnée pour le \"Mastermind\"");

            // IF - 'i' != Index nouvelle lettre
            if (i != int_IndexNewLetter) {
                logger.info("IF - 'i' != Index nouvelle lettre");

                // La lettre n'est présente à cette position = '†'
                array_ch_DefenseAnalysis[i][int_ReplacementPosition] = '†';
                logger.info("La lettre n'est présente à cette position = '†'");
            }
            // ELSE - 'i' = Index nouvelle lettre
            else {

                // La lettre est présente à cette position = 'NOUVELLE LETTRE'
                array_ch_DefenseAnalysis[i][int_ReplacementPosition] = ch_NewLetter;
                logger.info("La lettre est présente à cette position = 'NOUVELLE LETTRE'");
            }
        }

        // Injection - (char[]) Analyse de la défense
        al_Defense.set(9, array_ch_DefenseAnalysis);
        logger.info("MàJ - (char[]) Analyse de la défense");

        // Récupération (boolean[]) Lettres de la combinaison trouvées
        boolean array_boo_FoundLetters[] = (boolean[]) al_Defense.get(10);
        logger.info("Récupération (boolean[]) Lettres de la combinaison trouvées");

        // MàJ - (boolean[]) Lettres de la combinaison trouvées
        array_boo_FoundLetters[int_ReplacementPosition] = true;
        logger.debug("MàJ - (boolean[]) Lettres de la combinaison trouvées : " + Arrays.toString(array_boo_FoundLetters));

        // Injection - (boolean[]) Lettres de la combinaison trouvées
        al_Defense.set(10, array_boo_FoundLetters);
        logger.info("Injection - (boolean[]) Lettres de la combinaison trouvées");

        logger.trace("############################################");
        logger.trace("<<< END >>> Méthode : run_PositiveEquality()");
        logger.trace("############################################\n");

        return al_Defense;
    }
}
