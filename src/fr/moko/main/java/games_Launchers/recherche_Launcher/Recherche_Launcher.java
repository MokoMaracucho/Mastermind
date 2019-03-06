package fr.moko.main.java.games_Launchers.recherche_Launcher;

import fr.moko.main.java.games_Launchers.Games.Methods_Games;
import fr.moko.main.java.games_Launchers.Games.Texts_Games;
import fr.moko.main.java.games_Launchers.Games.Utilities_Games;
import fr.moko.main.java.games_Launchers.recherche_Launcher.recherche.Challenger_Recherche;
import fr.moko.main.java.games_Launchers.recherche_Launcher.recherche.Defense_Recherche;
import fr.moko.main.java.games_Launchers.recherche_Launcher.recherche.Methods_Recherche;
import fr.moko.main.java.games_Launchers.recherche_Launcher.recherche.Texts_Recherche;
import fr.moko.main.java.graphism.Graphism;
import org.apache.logging.log4j.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * Lance le jeu "Recherche +/-"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Recherche_Launcher {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance : "Methods_Games"
    Methods_Games methods_Games = new Methods_Games();

    // Instance : "Texts_Games"
    Texts_Games texts_Games = new Texts_Games();

    // Instance : "Defense_Recherche"
    Defense_Recherche defense_Recherche = new Defense_Recherche();

    // Instance : "Challenger_Recherche"
    Challenger_Recherche challenger_Recherche = new Challenger_Recherche();

    //Instance : "Utilities_Games"
    Utilities_Games utilities_Games = new Utilities_Games();

    // Instance : "Texts_Recherche"
    Texts_Recherche texts_Recherche = new Texts_Recherche();

    // Instance : "Methods_Recherche"
    Methods_Recherche methods_Recherche = new Methods_Recherche();

    // Instance : "Graphism"
    Graphism graphism = new Graphism();



    /**
     * Lancement du jeu "Recherche +/-"
     *
     * @param al_Configuration : (ArrayList) Valeurs de configuration
     * @param array_str_Main_Menu_Choices : (String[]) Choix du menu principal
     */
    public void recherche_Launcher(boolean boo_DevMode, ArrayList al_Configuration, String array_str_Main_Menu_Choices[]) {

        // Récupération des valeurs de configuration
        int int_Recherche_NumberOfUnities = (int) al_Configuration.get(1);
        int int_Recherche_NumberOfChances = (int) al_Configuration.get(2);
        logger.info("Récupération des valeurs de configuration");

        // Initialisation (String) Sous-mode en mode "Duel"
        String str_Sub_Mode = new String();



        // Initialisation (String) résultat gagnant
        String str_WinningResult = methods_Recherche.run_str_WinningResult(int_Recherche_NumberOfUnities);
        logger.debug("(String) Résultat gagnant : " + str_WinningResult);



        // Instance - (ArrayList) Données de défense
        ArrayList al_Recherche_Defense = new ArrayList();
        logger.info("Instance - (ArrayList) Données de défense");

        // Initialisation et injection - (int[]) Combinaison secrète
        int array_int_Combination[] = new int[int_Recherche_NumberOfUnities];
        logger.info("Initialisation et injection - (int[]) Combinaison secrète");
        al_Recherche_Defense.add(0, array_int_Combination);

        // Initialisation et injection - (int[]) Derniers inférieurs
        int array_int_LastInferior[] = new int[int_Recherche_NumberOfUnities];
        logger.info("Initialisation et injection - (int[]) Derniers inférieurs");
        al_Recherche_Defense.add(1, array_int_LastInferior);

        // Initialisation et injection - (int[]) Derniers supérieurs
        int array_int_LastSuperior[] = new int[int_Recherche_NumberOfUnities];
        al_Recherche_Defense.add(2, array_int_LastSuperior);
        logger.info("Initialisation et injection - (int[]) Derniers supérieurs");

        // Initialisation et injection - (int[]) Proposition de l'ordinateur
        int array_int_ComputerProposal[] = new int[int_Recherche_NumberOfUnities];
        al_Recherche_Defense.add(3, array_int_ComputerProposal);
        logger.info("Initialisation et injection - (int[]) Proposition de l'ordinateur");



        // Initialisation et injection - (char[]) Résultat de la comparaison
        char array_ch_ComparisonResult_Defense[] = new char[int_Recherche_NumberOfUnities];
        logger.info("Initialisation et injection - (char[]) Résultat de la comparaison");

        // Initialisation (int[]) Nombre aléatoire
        int array_int_RandomNumber[] = new int[int_Recherche_NumberOfUnities];
        logger.info("Initialisation (int[]) Nombre aléatoire");



        // Initialisation (boolean) L'ordinateur a gagné
        boolean boo_HE_WON = false;
        logger.debug("Initialisation (boolean) L'ordinateur a gagné : " + boo_HE_WON);

        // Initialisation (bolean) Partie gagnée
        boolean boo_Won_Part = false;
        logger.debug("Initialisation (bolean) Partie gagnée : " + boo_Won_Part);



        // Initialisation (String) résultat de la comparaison en mode "Défense"
        String str_ComparisonResult_Defense = new String();
        logger.info("Initialisation (String) résultat de la comparaison en mode \"Défense\"");
        al_Recherche_Defense.add(4, array_ch_ComparisonResult_Defense);

        // Initialisation (String) résultat de la comparaison en mode "Challenger"
        String str_ComparisonResult_Challenger = new String();
        logger.info("Initialisation (String) résultat de la comparaison en mode \"Challenger\"");



        // Lancement du compteur de tours
        logger.info("Lancement du compteur de tours");
        for (int i = 0; i < int_Recherche_NumberOfChances; i++) {

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

                    // Affichage énoncé en mode "Défense"
                    texts_Recherche.display_Defense_Statement(int_Recherche_NumberOfUnities);

                    // Affiche "A vous de jouer !"
                    texts_Games.display_A_VOUS_DE_JOUER();

                    // Initialisation (int) Combinaison Try Catch
                    int int_Combination_TryCatch = 0;
                    logger.debug("Initialisation (int) Combinaison Try Catch : " + int_Combination_TryCatch);

                    // Initialisation (boolean) Combinaison validée
                    boolean boo_Combination_Validated = false;
                    logger.debug("Initialisation (boolean) Combinaison validée : " + boo_Combination_Validated);

                    // DO {} WHILE - La Combinaison n'est pas validée
                    do {
                        logger.info("DO {} WHILE - La Combinaison n'est pas validée");

                        // Lance le scanner pour le combinaison secrète
                        Scanner sc_Combinaison = methods_Games.run_sc_Combination(array_str_Main_Menu_Choices, str_Sub_Mode);
                        logger.info("Lance le scanner pour le combinaison secrète");

                        // Vérifie si la combinaison secrète ne contient bien que des nombres
                        int_Combination_TryCatch = methods_Recherche.run_Combination_TryCatch(array_str_Main_Menu_Choices, str_Sub_Mode, sc_Combinaison, int_Combination_TryCatch);
                        logger.info("Vérifie si la combinaison secrète ne contient bien que des nombres");

                        // Vérifie la validité de la combinaison secrète
                        boo_Combination_Validated = methods_Recherche.run_Combination_Treatment(int_Recherche_NumberOfUnities, int_Combination_TryCatch, boo_Combination_Validated);
                        logger.info("Vérifie la validité de la combinaison secrète");

                    } while (!boo_Combination_Validated);
                    logger.info("DO {} WHILE - Sortie -> La combinaison est validée");

                    // Conversion (int[]) Combinaison secrète en tableau d'entiers
                    array_int_Combination = utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Combination_TryCatch);
                    logger.debug("Conversion (int[]) Combinaison secrète en tableau d'entiers : " + Arrays.toString(array_int_Combination));

                    // MàJ - Combinaison secrète dans ArrayList "al_RecherchePlusMoins_Defense"
                    al_Recherche_Defense.set(0, array_int_Combination);
                    logger.info("MàJ - Combinaison secrète dans ArrayList \"al_RecherchePlusMoins_Defense\"");

                    // Conversion (String) Combinaison secrète en chaîne de caractère
                    String str_Combination = utilities_Games.run_arrayInt_TO_str(int_Recherche_NumberOfUnities, array_int_Combination);

                    // Affiche la combinaison secrète
                    texts_Games.display_VOTRE_COMBINAISON(str_Combination);

                    // Initialisation des derniers supérieurs
                    al_Recherche_Defense = methods_Recherche.run_arrayInt_LastSuperiorInitialization(int_Recherche_NumberOfUnities, al_Recherche_Defense);
                }

                // Lancement de la défense du jeu "Recheche +/-"
                al_Recherche_Defense = defense_Recherche.run_Defense(int_Recherche_NumberOfUnities, int_Recherche_NumberOfChances, array_str_Main_Menu_Choices, str_Sub_Mode, i, al_Recherche_Defense);

                // Récupération (char[]) Résultat de la comparaison
                array_ch_ComparisonResult_Defense = (char[]) al_Recherche_Defense.get(4);
                logger.debug("Récupération (char[]) Résultat de la comparaison : " + Arrays.toString(array_ch_ComparisonResult_Defense));

                // Conversion (String) Résultat de la comparaison
                str_ComparisonResult_Defense = utilities_Games.run_arrayCh_TO_str(int_Recherche_NumberOfUnities, array_ch_ComparisonResult_Defense);
                logger.debug("Conversion (String) Résultat de la comparaison : " + str_ComparisonResult_Defense);
            }

            // IF - Le résultat de la comparaison est égale le résultat gagnant
            if (str_ComparisonResult_Defense.equals(str_WinningResult)) {
                logger.info("IF - Le résultat de la comparaison est égale le résultat gagnant");

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
                    i = int_Recherche_NumberOfChances - 1;
                    logger.info("Compteur de tours au dernier tour");
                }
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

                // IF - Premier tour
                if (i == 0) {
                    logger.info("// IF - Premier tour");

                    // Affiche "But du jeu :"
                    texts_Games.display_BUT_DU_JEU();

                    // Lance la génération d'une combinaison secrète aléatoire
                    array_int_RandomNumber = challenger_Recherche.run_RandomNumber(int_Recherche_NumberOfUnities, array_int_RandomNumber);
                    logger.debug("(int[]) Combinaison secrète aléatoire : " + array_int_RandomNumber);

                    // Affiche l'énoncé du mode "Challenger"
                    texts_Recherche.display_Challenger_Statement(boo_DevMode, int_Recherche_NumberOfUnities, int_Recherche_NumberOfChances, array_int_RandomNumber);
                }

                // Lance le mode "Challenger"
                str_ComparisonResult_Challenger = challenger_Recherche.run_RecherchePlusMoins_Challenger(int_Recherche_NumberOfUnities, int_Recherche_NumberOfChances, array_str_Main_Menu_Choices, boo_HE_WON, i, str_Sub_Mode, array_int_RandomNumber, str_ComparisonResult_Challenger);

                // IF - Mode "Challenger" && Le résultat de la comparaison = résultat gagnant
                if (array_str_Main_Menu_Choices[1] == "Challenger" && str_ComparisonResult_Challenger.equals(str_WinningResult)) {
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
                else if (str_ComparisonResult_Challenger.equals(str_WinningResult) && !boo_HE_WON) {
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
                else if (str_ComparisonResult_Challenger.equals(str_WinningResult) && boo_HE_WON) {
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
