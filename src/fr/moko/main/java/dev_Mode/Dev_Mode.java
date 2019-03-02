package fr.moko.main.java.dev_Mode;

import fr.moko.main.java.delay.Delay;
import fr.moko.main.java.games_Launchers.Games.Utilities_Games;



/**
 * Méthodes attenantes au mode développeur
 *
 * @author : Moko
 * @version : 1.0
 */
public class Dev_Mode {

    // Instance "Delay"
    Delay delay = new Delay();

    // Instance "Utilities_Games"
    Utilities_Games utilities_Games = new Utilities_Games();



    /**
     * Affiche "Vous êtes en mode développeur"
     */
    public void display_VOUS_ETES_EN_MODE_DEVELOPPEUR() {

        delay.delay_Text();
        System.out.println("|||||||||||||||||| Vous êtes en mode développeur ||||||||||||||||||\n");
    }


    /**
     * Affiche la combinaison générée par l'ordinateur pour le jeu "Recherche +/-"
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param array_int_RandomNumber : (int[]) Nombre généré de maniére aléatoire
     */
    public void display_Combination_Recherche(int int_Recherche_NumberOfUnities, int array_int_RandomNumber[]){

        String str_RandomNumber = utilities_Games.run_arrayInt_TO_str(int_Recherche_NumberOfUnities, array_int_RandomNumber);

        System.out.println("\n[devMode]-----------------------------------------------------------------------> " + str_RandomNumber);
    }


    /**
     * Affiche la combinaison générée par l'ordinateur en mode développeur
     *
     * @param int_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param array_ch_RandomNumber : (int[]) Nombre généré de maniére aléatoire
     */
    public void display_Combination_Mastermind(int int_NumberOfUnities, char array_ch_RandomNumber[]){

        String str_RandomNumber = utilities_Games.run_arrayCh_TO_str(int_NumberOfUnities, array_ch_RandomNumber);

        System.out.println("\n[devMode]-----------------------------------------------------------------------> " + str_RandomNumber);
    }
}
