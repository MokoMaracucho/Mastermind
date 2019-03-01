package fr.moko.main.java.game_Launchers.recherche_Launcher;
import fr.moko.main.java.game_Launchers.recherche_Launcher.recherche.Recherche_Methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;



/**
 * Lance le jeu "Recherche +/-"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Recherche_Launcher {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance : "Recherche_Methods"
    Recherche_Methods recherche_Methods = new Recherche_Methods();



    /**
     * Lancement du jeu "Recherche +/-"
     *
     * @param al_Configuration : (ArrayList) Valeurs de configuration
     * @param array_str_Menu_Choices : (String[]) Choix du menu principal
     */
    public void recherche_Launcher(ArrayList al_Configuration, String array_str_Menu_Choices[]) {

        // Récupération des valeurs de configuration
        boolean boo_DevMode = (boolean) al_Configuration.get(0);
        int int_Recherche_NumberOfUnities = (int) al_Configuration.get(1);
        int int_Recherche_NumberOfChances = (int) al_Configuration.get(2);
        logger.info("Récupération des valeurs de configuration");

        // Initialisation (String) Sous-mode en mode "Duel"
        String str_Sub_Mode = new String();

        // Initialisation (String) résultat gagnant
        String str_WinningResult = recherche_Methods.run_str_WinningResult(int_Recherche_NumberOfUnities);
        logger.debug("(String) Résultat gagnant : " + str_WinningResult);

        if (array_str_Menu_Choices[1] == "Défense" || array_str_Menu_Choices[1] == "Duel"){

            // Instance - (ArrayList) Données de défense
            ArrayList al_Recherche_Defense = new ArrayList();
            logger.info("Instance - (ArrayList) Données de défense");

            // Initialisation et injection - (int[]) Combinaison secrète
            int array_int_Combination[] = new int[int_Recherche_NumberOfUnities];
            logger.debug("Initialisation et injection - (int[]) Combinaison secrète : " + array_int_Combination);
            al_Recherche_Defense.add(0, array_int_Combination);

            // Initialisation et injection - (int[]) Derniers inférieurs
            int array_int_LastInferior[] = new int[int_Recherche_NumberOfUnities];
            logger.debug("Initialisation et injection - (int[]) Derniers inférieurs : " + array_int_LastInferior);
            al_Recherche_Defense.add(1, array_int_LastInferior);

            // Initialisation et injection - (int[]) Derniers supérieurs
            int array_int_LastSuperior[] = new int[int_Recherche_NumberOfUnities];
            logger.debug("Initialisation et injection - (int[]) Derniers supérieurs : " + array_int_LastSuperior);
            al_Recherche_Defense.add(2, array_int_LastSuperior);

            // Initialisation et injection - (int[]) Proposition de l'ordinateur
            int array_int_ComputerProposal[] = new int[int_Recherche_NumberOfUnities];
            al_Recherche_Defense.add(3, array_int_ComputerProposal);
            logger.debug("Initialisation et injection - (int[]) Proposition de l'ordinateur : " + array_int_ComputerProposal);

            // Initialisation et injection - (char[]) Résultat de la comparaison
            char array_ch_ComparisonResult_Defense[] = new char[int_Recherche_NumberOfUnities];
            logger.debug("Initialisation et injection - (char[]) Résultat de la comparaison : " + array_ch_ComparisonResult_Defense);
            al_Recherche_Defense.add(4, array_ch_ComparisonResult_Defense);
        }
    }
}
