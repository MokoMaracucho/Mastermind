package fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind;

import fr.moko.main.java.delay.Delay;



/**
 * Textes attenants au jeu "Mastermind"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Texts_Mastermind {

    // Instance "Delay"
    Delay delay = new Delay();

    // Instance "Texts_Methods_Mastermind"
    Texts_Methods_Mastermind texts_Methods_Mastermind = new Texts_Methods_Mastermind();





    /**
     * Affiche l'énoncé en mode "Défense"
     *
     * @param int_Mastermind_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param array_ch_SelectedLetters : (char[]) Lettres sélectionnées pour le jeu "Mastermind"
     */
    public void display_Defense_Statement(int int_Mastermind_NumberOfUnities, char array_ch_SelectedLetters[]){

        delay.delay_Text();
        System.out.println("\tA vous de choisir la combinaison !");
        delay.delay_Text();
        System.out.println("\n\tC'est à l'ordinateur de la retrouver.");

        String str_LettersForCombination = texts_Methods_Mastermind.run_str_LettersForCombination(int_Mastermind_NumberOfUnities, array_ch_SelectedLetters);

        delay.delay_Text();
        System.out.println("\nSaisissez une combinaison de " + int_Mastermind_NumberOfUnities + " lettres en utilisant : " + str_LettersForCombination + ".\n");
    }


    /**
     * Affiche : "La combinaison doit être composée des lettres ..., ..., ..."
     *
     * @param int_Mastermind_NumberOfLetters : (int) Nombre de lettres utilisées pour les combinaisons
     * @param array_ch_SelectedLetters : (char[]) Lettres sélectionnées pour le jeu "Mastermind"
     */
    public void display_LA_COMBINAISON_DOIT_ETRE_COMPOSEE_DES_LETTRES(int int_Mastermind_NumberOfLetters, char array_ch_SelectedLetters[]){

        String str_LettersForCombination = texts_Methods_Mastermind.run_str_LettersForCombination(int_Mastermind_NumberOfLetters, array_ch_SelectedLetters);

        delay.delay_Text();
        System.out.print("\nLa combinaison doit être composée des lettres : " + str_LettersForCombination + ".\n");
    }



    /**
     * Affiche : "La combinaison doit être composée de ... lettres !"
     *
     * @param int_Mastermind_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     */
    public void display_LA_COMBINAISON_DOIT_ETRE_COMPOSEE_DE(int int_Mastermind_NumberOfUnities){

        delay.delay_Text();
        System.out.print("\nLa combinaison doit être composée de " + int_Mastermind_NumberOfUnities + " lettres !\n");
    }
}
