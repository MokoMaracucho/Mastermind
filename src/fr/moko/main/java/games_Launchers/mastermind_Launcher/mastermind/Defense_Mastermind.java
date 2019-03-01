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
}
