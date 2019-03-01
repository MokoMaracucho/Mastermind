package fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind;

/**
 * Méthodes attenantes aux textes du jeu "Mastermind"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Texts_Methods_Mastermind {



    /**
     * Mise en page de l'énumération des lettres utilisées pour le jeu "Mastermind"
     *
     * @param int_Mastermind_NumberOfLetters : (int) Nombre de lettres utilisées pour les combinaisons
     * @param array_ch_SelectedLetters : (char[]) Lettres sélectionnées pour le jeu "Mastermind"
     *
     * @return : (String) Mise en page de l'énumération des lettres utilisées pour le jeu "Mastermind"
     */
    public String run_str_LettersForCombination(int int_Mastermind_NumberOfLetters, char array_ch_SelectedLetters[]) {

        String str_LettersForCombination = new String();

        for (int i = 0; i < int_Mastermind_NumberOfLetters; i++) {

            if (i != int_Mastermind_NumberOfLetters - 2 && i != int_Mastermind_NumberOfLetters - 1) {

                str_LettersForCombination += "'" + array_ch_SelectedLetters[i] + "', ";
            } else if (i == int_Mastermind_NumberOfLetters - 2) {

                str_LettersForCombination += "'" + array_ch_SelectedLetters[i] + "' et ";
            } else {

                str_LettersForCombination += "'" + array_ch_SelectedLetters[i] + "'";
            }
        }
        return str_LettersForCombination;
    }
}
