package fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind;

import org.apache.logging.log4j.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Méthodes attenantes au jeu "Mastermind" en mode "Challenger"
 */
public class Challenger_Mastermind {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance "Defense_Methods_Mastermind"
    Defense_Methods_Mastermind defense_Methods_Mastermind = new Defense_Methods_Mastermind();



    /**
     * Génére une combinaison aléatoire de lettres
     *
     * @param boo_DevMode : (boolean) Mode développeur
     * @param int_Mastermind_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_Mastermind_NumberOfLetters : (int) Nombre de lettres utilisées pour les combinaisons
     * @param al_Mastermind_Challenger : (ArrayList) Données challenger
     *
     * @return : (char[]) Combinaison aléatoire de lettres
     */
    public char[] run_array_ch_RandomLetter(boolean boo_DevMode, int int_Mastermind_NumberOfUnities, int int_Mastermind_NumberOfLetters, ArrayList al_Mastermind_Challenger) {

        logger.trace("###################################################");
        logger.trace("<<< START >>> Méthode : run_array_ch_RandomLetter()");
        logger.trace("###################################################");

        // Récupération (char[]) Récupération des lettres sélectionnées pour le jeu
        char array_ch_SelectedLetters[] = (char[]) al_Mastermind_Challenger.get(0);
        logger.debug("Récupération (char[]) Récupération des lettres sélectionnées pour le jeu");

        // Initialisation (char[]) Combinaison secrète
        char array_ch_RandomNumber[] = new char[int_Mastermind_NumberOfUnities];
        logger.info("Initialisation (char[]) Combinaison secrète");

        // FOR - Remplie le tableau de lettres choisies de manière aléatoire
        for (int i = 0; i < int_Mastermind_NumberOfUnities; i++) {

            // Intance "Random"
            Random random = new Random();

            // Initialisation (int) Nombre aléatoire
            int int_RandomNumber = random.nextInt(int_Mastermind_NumberOfLetters);

            // Injection (char[]) Combinaison secrète
            array_ch_RandomNumber[i] = array_ch_SelectedLetters[int_RandomNumber];
        }

        logger.debug("Injection (char[]) Combinaison secrète : " + Arrays.toString(array_ch_RandomNumber));

        logger.trace("#################################################");
        logger.trace("<<< END >>> Méthode : run_array_ch_RandomLetter()");
        logger.trace("#################################################\n");

        return array_ch_RandomNumber;
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
    public int[] run_al_NewComparisonResult(int int_Mastermind_NumberOfUnities, int int_Mastermind_NumberOfLetters, ArrayList al_Mastermind_Defense) {

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
}
