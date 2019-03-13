package fr.moko.main.java.games_Launchers.recherche_Launcher.recherche;

import fr.moko.main.java.games_Launchers.Games.Methods_Games;
import fr.moko.main.java.games_Launchers.Games.Texts_Games;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;



/**
 * Méthodes attenantes au jeu "Recherche +/-"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Methods_Recherche {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance : "Methods_Games"
    Methods_Games methods_Games = new Methods_Games();

    // Instance : "Texts_Games"
    Texts_Games texts_Games = new Texts_Games();

    // Instance : "Texts_Recherche"
    Texts_Recherche texts_Recherche = new Texts_Recherche();

    // Instance : "Methods_Texts_Recherche"
    Methods_Texts_Recherche methods_Texts_Recherche = new Methods_Texts_Recherche();



    /**
     * Défini la résultat gagnant
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unité utilisées pour les combinaisons
     *
     * @return (String) Résultat gagnant
     */
    public String run_str_WinningResult(int int_Recherche_NumberOfUnities){

        // Initialisation (String) Résultat gagnant
        String str_WinningResult = "";
        logger.info("Initialisation (String) Résultat gagnant");

        // FOR - Incrémentate "=" au résultat gagnant
        logger.info("FOR - Incrémentation \"=\" au résultat gagnant");
        for(int i = 0; i < int_Recherche_NumberOfUnities; i++){

            // Incrémentatation "=" au résultat gagnant
            str_WinningResult += "=";
        }

        logger.debug("Résultat gagnant : " + str_WinningResult);

        return str_WinningResult;
    }



    /**
     * Teste si la combinaison ne contient bien que des nombres
     *
     * @param array_str_Main_Menu_Choices : (String[]) Choix du menu principal
     * @param str_Sub_Mode : (String) Sous-mode en mode "Duel"
     * @param sc_Combinaison : (Scanner) Contenant la combinaison à tester
     * @param int_Combination_TryCatch : (int[]) Combinaison ne contenat que des chiffres
     *
     * @return : (int) La combinaison
     */
    public int run_Combination_TryCatch(String[] array_str_Main_Menu_Choices, String str_Sub_Mode, Scanner sc_Combinaison, int int_Combination_TryCatch) {

        // Initialisation (boolean) Que des nombres
        boolean boo_OnlyNumbers = false;
        logger.debug("Initialisation (boolean) Que des nombres : " + boo_OnlyNumbers);

        // DO {} WHILE - Il n'y a pas que des nombres
        do {
            logger.info("DO {} WHILE - Il n'y a pas que des nombres");

            try {
                logger.info("try");

                // Récupération (int) du contenu du scanner
                int_Combination_TryCatch = sc_Combinaison.nextInt();
                logger.debug("Récupération (int) du contenu du scanner : " + int_Combination_TryCatch);

                // MàJ - (boolean) Il n'y a que des nombres
                boo_OnlyNumbers = true;
                logger.debug("MàJ - (boolean) Il n'y a que des nombres : " + boo_OnlyNumbers);

            }

            catch (InputMismatchException e) {
                logger.warn("catch");

                // Affiche "Ceci n'est pas un nombre !"
                texts_Recherche.display_CECI_N_EST_PAS_UN_NOMBRE();

                // Affiche "Veuillez réessayer."
                texts_Games.display_VEUILLEZ_REESSAYER();

                // Initialise le scanner pour la proposition
                sc_Combinaison = methods_Games.run_sc_Combination(array_str_Main_Menu_Choices, str_Sub_Mode);
                logger.info("Initialise le scanner pour la proposition");

                // MàJ - (boolean) Il n'y a pas que des nombres
                boo_OnlyNumbers = false;
                logger.debug("MàJ - (boolean) Il n'y a pas que des nombres : " + boo_OnlyNumbers);
            }
        } while (!boo_OnlyNumbers);

        return int_Combination_TryCatch;
    }



    /**
     * Vérifie la validité de la combinaison
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_Combination_TryCatch : (int) Combinaison après vérification qu'elle ne contient que des nombres
     * @param boo_Combination_Validated : (boolean) Combinaison validée
     *
     * @return : "true" si combinaison valide / "false" si combinaison non valide
     */
    public boolean run_Combination_Treatment(int int_Recherche_NumberOfUnities, int int_Combination_TryCatch, boolean boo_Combination_Validated){

        // Initialisation (boolean) Le nombre est négatif
        boolean negativeNumber = run_IfNegative(int_Combination_TryCatch);
        logger.debug("Initialisation (boolean) Le nombre est négatif : " + negativeNumber);

        // Initialisation (boolean) Le nombre est trop grand
        boolean tooBigNumber = run_IfTooBig(int_Recherche_NumberOfUnities, int_Combination_TryCatch);
        logger.debug("Initialisation (boolean) Le nombre est trop grand : " + tooBigNumber);

        // IF - Nombre positif et pas trop grand
        if(negativeNumber == false && tooBigNumber == false){
            logger.info("IF - Nombre positif et pas trop grand");

            // MàJ - (boolean) Combinaison valide
            boo_Combination_Validated = true;
        }

        logger.debug("MàJ - (boolean) Combinaison valide : " + boo_Combination_Validated);

        return boo_Combination_Validated;
    }



    /**
     * Vérifie si le nombre est négatif
     *
     * @param int_Combination_TryCatch : (int) Combinaison après vérification qu'elle ne contient que des nombres
     *
     * @return : "true" si le nombre est négatif / "false" si le nombre est valide
     */
    public boolean run_IfNegative(int int_Combination_TryCatch){

        // Initialisation (boolean) Le nombre est négatif
        boolean boo_IfNegative = false;
        logger.debug("Initialisation (boolean) Le nombre est négatif : " + boo_IfNegative);

        // IF - Le nombre est négatif
        if (int_Combination_TryCatch < 0){
            logger.warn("IF - Le nombre est négatif");

            // Affiche "Ce nombre est négatif !"
            texts_Recherche.display_CE_NOMBRE_EST_NEGATIF();

            // Affiche "Il faut que vous saisissiez un nombre entier"
            texts_Recherche.display_IL_FAUT_QUE_VOUS_SAISISSIEZ_UN_ENTIER_POSITIF();

            // Affiche "Veuillez réessayer."
            texts_Games.display_VEUILLEZ_REESSAYER();

            // MàJ - (boolean) Le nombre est négatif
            boo_IfNegative = true;
        }

        logger.debug("(boolean) Le nombre est négatif : " + boo_IfNegative);

        return boo_IfNegative;
    }



    /**
     * Vérifie si le nombre est trop grand
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_Combination_TryCatch : (int) Combinaison après vérification qu'elle ne contient que des nombres
     *
     * @return : "true" si le nombre est trop grand / "false" si le nombre est valide
     */
    public boolean run_IfTooBig(int int_Recherche_NumberOfUnities, int int_Combination_TryCatch) {

        // Initialisation (boolean) Le nombre est trop grand
        boolean boo_TooBigNumber = false;
        logger.debug("Initialisation (boolean) Le nombre est trop grand : " + boo_TooBigNumber);

        // Initialisation (String) Nombre maximum
        String str_NumberMax = methods_Texts_Recherche.run_str_NumberMax(int_Recherche_NumberOfUnities);
        logger.debug("Initialisation (String) Nombre maximum : " + str_NumberMax);

        // Conversion (int) La chaîne de caractère contenant le nombre maximum
        int int_NumberMax = Integer.parseInt(str_NumberMax);
        logger.info("Conversion (int) La chaîne de caractère contenant le nombre maximum");

        // IF - Le nombre est trop grand
        if (int_Combination_TryCatch > int_NumberMax) {
            logger.warn("IF - Le nombre est trop grand");

            // Affiche "Ce nombre est trop grand !"
            texts_Recherche.display_CE_NOMBRE_EST_TROP_GRAND();

            // Affiche "Le nombre doit être inférieur à ..."
            texts_Recherche.display_LE_NOMBRE_DOIT_ETRE_INFERIEUR_A(int_Recherche_NumberOfUnities);

            // Affiche "Veuillez réessayer."
            texts_Games.display_VEUILLEZ_REESSAYER();

            // MàJ - (boolean) Le nombre est trop grand
            boo_TooBigNumber = true;
        }

        logger.debug("(boolean) Le nombre est trop grand : " + boo_TooBigNumber);

        return boo_TooBigNumber;
    }


    /**
     * Initialise le tableau des derniers supérieurs
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param al_Recherche_Defense : (ArrayList) Données en mode "Défense"
     *
     * @return : (int[]) Derniers entiers initialisé
     */
    public ArrayList run_arrayInt_LastSuperiorInitialization(int int_Recherche_NumberOfUnities, ArrayList al_Recherche_Defense){

        // Récupération (int[]) Derniers supérieur
        int array_int_LastSuperior[] = (int[]) al_Recherche_Defense.get(2);
        logger.debug("Récupération (int[]) Derniers supérieur : " + Arrays.toString(array_int_LastSuperior));

        // FOR - Chaque unité du tableau des derniers supérieurs
        logger.info("FOR - Chaque unité du tableau des derniers supérieurs");
        for (int i = 0; i < int_Recherche_NumberOfUnities; i++){

            // MàJ - Unité du tableau des dernier supérieurs
            array_int_LastSuperior[i] = 9;
        }

        logger.debug("(int[]) Derniers supérieurs : " + Arrays.toString(array_int_LastSuperior));

        al_Recherche_Defense.set(2, array_int_LastSuperior);

        return al_Recherche_Defense;
    }
}
