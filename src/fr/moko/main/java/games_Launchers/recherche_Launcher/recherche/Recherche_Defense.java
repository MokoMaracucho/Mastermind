package fr.moko.main.java.games_Launchers.recherche_Launcher.recherche;

import fr.moko.main.java.games_Launchers.Games.Texts_Games;
import fr.moko.main.java.games_Launchers.Games.Utilities_Games;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Méthodes attenantes au mode "Défense" du jeu "Recherche +/-"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Recherche_Defense {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance : "Texts_Games"
    Texts_Games texts_Games = new Texts_Games();

    // Instance : "Utilities_Games"
    Utilities_Games utilities_Games = new Utilities_Games();

    // Instance : "Texts_Recherche"
    Texts_Recherche texts_Recherche = new Texts_Recherche();


    /**
     * Initialisation du jeu "Recherche +/-" en mode "Défense"
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_Recherche_NumberOfChances : (int) Nombre de chances
     * @param array_str_Main_Menu_Choices : (String[]) Choix du menu principal
     * @param str_Sub_Mode : (String) Sous-mode en mode "Duel"
     * @param i : (int) Nombre de tours
     * @param al_Recherche_Defense : (ArrayList) Données défense
     *
     * @return : (ArrayList) données défense
     */
    public ArrayList run_Defense(int int_Recherche_NumberOfUnities, int int_Recherche_NumberOfChances, String array_str_Main_Menu_Choices[], String str_Sub_Mode, int i, ArrayList al_Recherche_Defense) {

        logger.trace("#####################################");
        logger.trace("<<< START >>> Méthode : run_Defense()");
        logger.trace("#####################################");

        // Lance la nouvelle proposition de l'ordinateur
        al_Recherche_Defense = run_al_NewComputerProposal(int_Recherche_NumberOfUnities, int_Recherche_NumberOfChances, array_str_Main_Menu_Choices, str_Sub_Mode, i, al_Recherche_Defense);
        logger.info("Lance la nouvelle proposition de l'ordinateur");

        // Récupération (int[]) Proposition de l'ordinateur
        int array_int_ComputerProposal[] = (int[]) al_Recherche_Defense.get(3);
        logger.debug("(int[]) Proposition de l'ordinateur : " + Arrays.toString(array_int_ComputerProposal));

        // Conversion (String) Proposition de l'ordinateur
        String str_ComputerProposal = utilities_Games.run_arrayInt_TO_str(int_Recherche_NumberOfUnities, array_int_ComputerProposal);
        logger.debug("Conversion (String) Proposition de l'ordinateur : " + str_ComputerProposal);

        // Affiche la proposition de l'ordinateur
        texts_Games.display_PROPOSITION_DE_L_ORDINATEUR(str_ComputerProposal, i);

        // Lancement de la comparaison entre la proposition de l'ordinateur et la combinaison secrète
        al_Recherche_Defense = run_array_ch_ComparisonResult(int_Recherche_NumberOfUnities, al_Recherche_Defense);
        logger.info("Lancement de la comparaison entre la proposition de l'ordinateur et la combinaison secrète");

        // Récupération (char[]) Résultat de la comparaison
        char array_ch_ComparisonResult_Defense[] = (char[]) al_Recherche_Defense.get(4);
        logger.debug("Récupération (char[]) Résultat de la comparaison : " + Arrays.toString(array_ch_ComparisonResult_Defense));

        // Conversion (String) Résultat de la comparaison
        String str_ComparisonResult_Defense = utilities_Games.run_arrayCh_TO_str(int_Recherche_NumberOfUnities, array_ch_ComparisonResult_Defense);
        logger.debug("Conversion (String) Résultat de la comparaison : " + str_ComparisonResult_Defense);

        // Affichage du résultat de la comparaison
        texts_Recherche.display_RESULTAT_DE_LA_COMPARAISON(array_str_Main_Menu_Choices, str_Sub_Mode, str_ComparisonResult_Defense);

        logger.trace("###################################");
        logger.trace("<<< END >>> Méthode : run_Defense()");
        logger.trace("###################################\n");

        return al_Recherche_Defense;
    }

    /**
     * Nouvelles propositions de l'ordinateur
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_Recherche_NumberOfChances : (int) Nombre de chances
     * @param array_str_Main_MenuChoices : (String[]) Choix du menu principal
     * @param str_Sub_Mode : (String) Sous-mode en mode "Duel"
     * @param i : (int) Nombre de tours
     * @param al_Recherche_Defense : (ArrayList) Données défense
     *
     * @return : (ArrayList) Donnéées défense
     */
    public ArrayList run_al_NewComputerProposal(int int_Recherche_NumberOfUnities, int int_Recherche_NumberOfChances, String array_str_Main_MenuChoices[], String str_Sub_Mode, int i, ArrayList al_Recherche_Defense) {

        logger.trace("####################################################");
        logger.trace("<<< START >>> Méthode : run_al_NewComputerProposal()");
        logger.trace("####################################################");

        // IF - Premier tour
        if (i == 0) {
            logger.info("IF - Premier tour");

            // Lancement première proposition de l'ordinateur
            al_Recherche_Defense = run_array_int_FirstTypeComputerProposal(int_Recherche_NumberOfUnities, al_Recherche_Defense);
            logger.info("Lance première proposition de l'ordinateur");
        }
        // SINON - Aprés premier tour
        else {
            logger.info("SINON - Aprés premier tour");

            // Affichage du nombre de chances restantes
            texts_Games.display_RemainingChances(int_Recherche_NumberOfChances, array_str_Main_MenuChoices, str_Sub_Mode, i);

            // MàJ - Derniers inférieurs
            al_Recherche_Defense = run_array_int_LastInferiorUpdate(int_Recherche_NumberOfUnities, al_Recherche_Defense);

            // MàJ - Derniers supérieurs
            al_Recherche_Defense = run_array_int_LastSuperiorUpdate(int_Recherche_NumberOfUnities, al_Recherche_Defense);

            // Lancement second type de proposition
            al_Recherche_Defense = run_array_int_SecondTypeComputerProposal(int_Recherche_NumberOfUnities, al_Recherche_Defense);
            logger.info("Lancement second type de proposition");
        }

        logger.trace("##################################################");
        logger.trace("<<< END >>> Méthode : run_al_NewComputerProposal()");
        logger.trace("##################################################\n");

        return al_Recherche_Defense;
    }


    /**
     * Premier type de proposition pour l'ordinateur
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param al_Recherche_Defense : (ArrayList) Données défense
     *
     * @return : (int[]) Première proposition de l'ordinateur
     */
    public ArrayList run_array_int_FirstTypeComputerProposal(int int_Recherche_NumberOfUnities, ArrayList al_Recherche_Defense){

        logger.trace("#############################################################");
        logger.trace("### START ### Méthode : run_array_int_FirstComputerProposal()");
        logger.trace("#############################################################");

        // Initialisation (int[]) Première proposition de l'ordinateur
        int array_int_FirstTypeComputerProposal[] = new int[int_Recherche_NumberOfUnities];

        // Injection de 5 dans première proposition de l'ordinateur
        logger.info("Injection de 5 dans première proposition de l'ordinateur");
        for (int i = 0; i < int_Recherche_NumberOfUnities; i++){

            array_int_FirstTypeComputerProposal[i] = 5;
        }

        logger.debug("(int[]) Première proposition de l'ordinateur : " + Arrays.toString(array_int_FirstTypeComputerProposal));

        // Injection de la première proposition de l'ordinateur dans "al_RecherchePlusMoins_Defense"
        al_Recherche_Defense.set(3, array_int_FirstTypeComputerProposal);

        logger.trace("###########################################################");
        logger.trace("### END ### Méthode : run_array_int_FirstComputerProposal()");
        logger.trace("###########################################################\n");

        return al_Recherche_Defense;
    }


    /**
     * Mise-à-jour des derniers inférieurs
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param al_Recherche_Defense : (ArrayList) Données défense
     *
     * @return : Derniers inférieurs mise-à-jour dans "al_RecherchePlusMoins_Defense"
     */
    public ArrayList run_array_int_LastInferiorUpdate(int int_Recherche_NumberOfUnities, ArrayList al_Recherche_Defense){

        logger.trace("##########################################################");
        logger.trace("### START ### Méthode : run_array_int_LastInferiorUpdate()");
        logger.trace("##########################################################");

        // Récupération (int[]) derniers inférieurs
        int array_int_LastInferior[] = (int[]) al_Recherche_Defense.get(1);
        logger.debug("(int[]) Derniers inférieurs : " + Arrays.toString(array_int_LastInferior));

        // Récupération (int[]) proposition de l'ordianteur
        int array_int_ComputerProposal[] = (int[]) al_Recherche_Defense.get(3);
        logger.debug("(int[]) Proposition de l'ordinateur : " + Arrays.toString(array_int_ComputerProposal));

        // Récupération (char[]) résultat de la comparaison
        char array_ch_ComparisonResult[] = (char[]) al_Recherche_Defense.get(4);
        logger.debug("(char[]) Résultat de la comparaison : " + Arrays.toString(array_ch_ComparisonResult));

        // FOR - Les positions '+'
        logger.info("FOR - Les positions '+'");
        for (int i = 0; i < int_Recherche_NumberOfUnities; i++){

            // IF - L'uniteé de la combinaison secrète = '+'
            if (array_ch_ComparisonResult[i] == '+') {

                // MàJ - (char[]) Derniers inférieurs
                array_int_LastInferior[i] = array_int_ComputerProposal[i];
            }
        }

        logger.debug("MàJ - (int[]) Derniers inférieurs : " + Arrays.toString(array_int_LastInferior));

        // Injection des derniers inférieurs dans "al_RecherchePlusMoins_Defense"
        al_Recherche_Defense.set(1, array_int_LastInferior);

        logger.trace("########################################################");
        logger.trace("### END ### Méthode : run_array_int_LastInferiorUpdate()");
        logger.trace("########################################################\n");

        return al_Recherche_Defense;
    }


    /**
     * Mise-à-jour des derniers supérieurs
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param al_Recherche_Defense : (ArrayList) Données défense
     *
     * @return : Derniers supérieurs mise-à-jour dans "al_RecherchePlusMoins_Defense"
     */
    public ArrayList run_array_int_LastSuperiorUpdate(int int_Recherche_NumberOfUnities, ArrayList al_Recherche_Defense){

        logger.trace("##########################################################");
        logger.trace("### START ### Méthode : run_array_int_LastSuperiorUpdate()");
        logger.trace("##########################################################");

        // Récupération (int[]) derniers supérieurs
        int array_int_LastSuperior[] = (int[]) al_Recherche_Defense.get(2);
        logger.debug("(int[]) Derniers supérieurs : " + Arrays.toString(array_int_LastSuperior));

        // Récupération (int[]) proposition de l'ordianteur
        int array_int_ComputerProposal[] = (int[]) al_Recherche_Defense.get(3);
        logger.debug("(int[]) Proposition de l'ordianteur : " + Arrays.toString(array_int_ComputerProposal));

        // Récupération (char[]) résultat de la comparaison
        char array_ch_ComparisonResult[] = (char[]) al_Recherche_Defense.get(4);
        logger.debug("(char[]) Résultat de la comparaison : " + Arrays.toString(array_ch_ComparisonResult));

        // FOR - Les positions '-'
        logger.info("FOR - Les positions '-'");
        for (int i = 0; i < int_Recherche_NumberOfUnities; i++){

            if (array_ch_ComparisonResult[i] == '-') {

                array_int_LastSuperior[i] = array_int_ComputerProposal[i];
            }
        }

        logger.debug("(array int) Derniers supérieurs MàJ : " + Arrays.toString(array_int_LastSuperior));

        // Injection des derniers supérieurs dans "al_RecherchePlusMoins_Defense"
        al_Recherche_Defense.set(2, array_int_LastSuperior);

        logger.trace("########################################################");
        logger.trace("### END ### Méthode : run_array_int_LastSuperiorUpdate()");
        logger.trace("########################################################\n");

        return al_Recherche_Defense;
    }


    /**
     * Second type de proposition pour l'ordinateur
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param al_Recherche_Defense : (ArrayList) Données défense
     *
     * @return : Nouvelle proposition de l'ordinateur dans "al_RecherchePlusMoins_Defense"
     */
    public ArrayList run_array_int_SecondTypeComputerProposal(int int_Recherche_NumberOfUnities, ArrayList al_Recherche_Defense){

        logger.trace("##############################################################");
        logger.trace("### START ### Méthode : run_array_int_SecondComputerProposal()");
        logger.trace("##############################################################");

        // Récupération (int[]) Derniers inférieurs
        int array_int_LastInferior[] = (int[]) al_Recherche_Defense.get(1);
        logger.debug("Récupération (char[]) Derniers inférieurs : " + Arrays.toString(array_int_LastInferior));

        // Récupération (int[]) Derniers supérieurs
        int array_int_LastSuperior[] = (int[]) al_Recherche_Defense.get(2);
        logger.debug("Récupération (char[]) Derniers supérieurs : " + Arrays.toString(array_int_LastSuperior));

        // Récupération (int[]) Proposition de l'ordinateur
        int array_int_ComputerProposal[] = (int[]) al_Recherche_Defense.get(3);
        logger.debug("Récupération (char[]) Proposition de l'ordinateur : " + Arrays.toString(array_int_ComputerProposal));

        // Récupération (char[]) Résultat de la comparaison
        char array_ch_ComparisonResult[] = (char[]) al_Recherche_Defense.get(4);
        logger.debug("Récupération (char[]) Résultat de la comparaison : " + Arrays.toString(array_ch_ComparisonResult));

        // Initialisation (int[]) Nouvelle proposition de l'ordinateur
        int array_int_NewComputerProposal[] = new int[int_Recherche_NumberOfUnities];
        logger.debug("Initialisation (int[]) Nouvelle proposition de l'ordinateur : " + Arrays.toString(array_ch_ComparisonResult));

        // FOR - Injection de la nouvelle proposition de l'ordinateur
        logger.info("FOR - Injection de la nouvelle proposition de l'ordinateur");
        for (int i = 0; i < int_Recherche_NumberOfUnities; i++){

            // IF - L'unité du résultat de la comparaison = '-'
            if (array_ch_ComparisonResult[i] == '-'){
                logger.info("IF - L'unité du résultat de la comparaison = '-'");

                if (array_int_ComputerProposal[i] != 1) {

                    array_int_NewComputerProposal[i] = array_int_ComputerProposal[i] - ((array_int_ComputerProposal[i] - array_int_LastInferior[i]) / 2);
                }
                else{

                    array_int_NewComputerProposal[i] = 0;
                }
            }
            // IF - L'unité du résultat de la comparaison = '+'
            else if (array_ch_ComparisonResult[i] == '+'){
                logger.info("IF - L'unité du résultat de la comparaison = '+'");


                if (array_int_ComputerProposal[i] != 8) {

                    array_int_NewComputerProposal[i] = array_int_ComputerProposal[i] + ((array_int_LastSuperior[i] - array_int_ComputerProposal[i]) / 2);
                }
                else{

                    array_int_NewComputerProposal[i] = 9;
                }
            }
            // IF - L'unité du résultat de la comparaison = '='
            else {
                logger.info("IF - L'unité du résultat de la comparaison = '='");

                array_int_NewComputerProposal[i] = array_int_ComputerProposal[i];
            }
        }

        logger.debug("(array int) Nouvelle proposition de l'ordinateur : " + Arrays.toString(array_int_NewComputerProposal));

        // Injection de la nouvelle proposition dans "al_RecherchePlusMoins_Defense"
        al_Recherche_Defense.set(3, array_int_NewComputerProposal);

        logger.trace("############################################################");
        logger.trace("### END ### Méthode : run_array_int_SecondComputerProposal()");
        logger.trace("############################################################\n");

        return al_Recherche_Defense;
    }


    /**
     * Comparation de la proposition de l'ordinateur avec la combinaison secrète
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param al_RecherchePlusMoins_Defense : (ArrayList) Données défense
     *
     * @return : Le résultat de la comparaison
     */
    public ArrayList run_array_ch_ComparisonResult(int int_Recherche_NumberOfUnities, ArrayList al_RecherchePlusMoins_Defense) {

        logger.trace("#######################################################");
        logger.trace("### START ### Méthode : run_array_ch_ComparisonResult()");
        logger.trace("#######################################################");

        // Récupération de la combinaison secrète
        int array_int_Base[] = (int[]) al_RecherchePlusMoins_Defense.get(0);
        logger.debug("(int[]) Combinaison secrète : " + Arrays.toString(array_int_Base));

        // Récupération de la proposition de l'ordinateur
        int array_int_ToCompare[] = (int[]) al_RecherchePlusMoins_Defense.get(3);
        logger.debug("(int[]) Proposition de l'ordinateur : " + Arrays.toString(array_int_ToCompare));

        // Initialisation (char[]) Résultat de la comparaison
        char array_ch_ComparisonResult[] = new char[int_Recherche_NumberOfUnities];
        logger.debug("(char[]) Initialisation du résultat de la comparaison : " + Arrays.toString(array_ch_ComparisonResult));

        // FOR - Comparaison de chaque unité de la proposition de l'ordinateur et de la combinaison secrète
        logger.info("FOR - Comparaison de chaque unité de la proposition de l'ordinateur et de la combinaison secrète");
        for (int i = 0; i < int_Recherche_NumberOfUnities; i++) {

            // IF - L'unité de la proposition de l'ordinateur < à l'unité de la combinaison secrète
            if (array_int_ToCompare[i] < array_int_Base[i]) {
                logger.info("IF - L'unité de la proposition de l'ordinateur < à l'unité de la combinaison secrète");

                // Injection '+'
                array_ch_ComparisonResult[i] = '+';

                // IF - L'unité de la proposition de l'ordinateur > à l'unité de la combinaison secrète
            } else if (array_int_ToCompare[i] > array_int_Base[i]) {
                logger.info("IF - L'unité de la proposition de l'ordinateur > à l'unité de la combinaison secrète");

                // Injection '-'
                array_ch_ComparisonResult[i] = '-';

                // IF - Les unités de la proposition de l'ordinateur et de la combinaison secrète sont égales
            } else {
                logger.info("IF - Les unités de la proposition de l'ordinateur et de la combinaison secrète sont égales");

                // Injection '='
                array_ch_ComparisonResult[i] = '=';
            }
        }

        logger.debug("(char[]) MàJ résultat de la comparaison : " + Arrays.toString(array_ch_ComparisonResult));

        // Injection du résultat de la comparaison dans "array_ch_ComparisonResult"
        al_RecherchePlusMoins_Defense.set(4, array_ch_ComparisonResult);

        logger.trace("######################################################");
        logger.trace("### End ### Méthode : run_array_ch_ComparisonResult()");
        logger.trace("######################################################\n");

        return al_RecherchePlusMoins_Defense;
    }
}
