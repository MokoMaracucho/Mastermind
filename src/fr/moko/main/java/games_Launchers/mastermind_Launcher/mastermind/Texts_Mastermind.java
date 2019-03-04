package fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind;

import fr.moko.main.java.delay.Delay;
import fr.moko.main.java.dev_Mode.Dev_Mode;

import java.util.ArrayList;


/**
 * Textes attenants au jeu "Mastermind"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Texts_Mastermind {

    // Instance "Delay"
    Delay delay = new Delay();

    // Instance "Dev_Mode"
    Dev_Mode dev_Mode = new Dev_Mode();

    // Instance "Texts_Methods_Mastermind"
    Texts_Methods_Mastermind texts_Methods_Mastermind = new Texts_Methods_Mastermind();





    /**
     * Affiche l'énoncé en mode "Défense"
     *
     * @param int_Mastermind_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param array_ch_SelectedLetters : (char[]) Lettres sélectionnées pour le jeu "Mastermind"
     */
    public void display_Defense_Statement(int int_Mastermind_NumberOfUnities, int int_Mastermind_NumberOfLetters, char array_ch_SelectedLetters[]){

        delay.delay_Text();
        System.out.println("\tA vous de choisir la combinaison !");
        delay.delay_Text();
        System.out.println("\n\tC'est à l'ordinateur de la retrouver.");

        String str_LettersForCombination = texts_Methods_Mastermind.run_str_LettersForCombination(int_Mastermind_NumberOfLetters, array_ch_SelectedLetters);

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



    /**
     * Affiche le résultat de la comparaison
     *
     * @param array_int_NewComparisonResult : (int[]) Résultat de la comparaison
     */
    public void display_RESULTAT_DE_LA_COMPARAISON(int array_int_NewComparisonResult[]){

        delay.delay_Text();
        System.out.println("Résultats de la comparaison :\n");

        delay.delay_Text();
        System.out.println("\t - Nombre de lettres bien placées : " + array_int_NewComparisonResult[0]);
        delay.delay_Text();
        System.out.println("\t - Nombre de lettres présentes mais mal placées : " + array_int_NewComparisonResult[1]);
        delay.delay_Text();
        System.out.println("\t - Nombre de lettres non présentes : " + array_int_NewComparisonResult[2] + "\n");
    }


    /**
     * Affiche l'énoncé en mode "Mastermind"
     *
     * @param int_Mastermind_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param al_Mastermind_Challenger :
     */
    public void display_Challenger_Statement(int int_Mastermind_NumberOfUnities, int int_Mastermind_NumberOfLetters, int int_Mastermind_NumberOfChances, boolean boo_DevMode, ArrayList al_Mastermind_Challenger){

        char array_ch_SelectedLetters[] = (char[]) al_Mastermind_Challenger.get(0);

        char array_ch_RandomCombinasion[] = (char[]) al_Mastermind_Challenger.get(1);

        delay.delay_Text();
        System.out.println("\n\tTrouvez la combinaison générée par l'ordinateur !");

        if (boo_DevMode) {

            dev_Mode.display_Combination_Mastermind(int_Mastermind_NumberOfUnities, array_ch_RandomCombinasion);
        }

        delay.delay_Text();
        System.out.println("\n\tAprès chaques propositions, des indices vous seront donnés :\n");

        delay.delay_Text();
        System.out.println("\t\t- Le nombre de lettres bien placées;");
        delay.delay_Text();
        System.out.println("\t\t- Le nombre de lettres présentes mais mal placées;");
        delay.delay_Text();
        System.out.println("\t\t- Les lettres qui ne sont pas présentes.\n");

        delay.delay_Text();
        System.out.println("\tVous devez découvrir une combinaison composée de " + int_Mastermind_NumberOfUnities + " lettres.");
        System.out.println("\n\tLa combinaison est composée des lettres suivantes : " + texts_Methods_Mastermind.run_str_LettersForCombination(int_Mastermind_NumberOfLetters, array_ch_SelectedLetters) + ".");
        System.out.println("\n\tVous avez " + int_Mastermind_NumberOfChances + " chances !");
    }
}
