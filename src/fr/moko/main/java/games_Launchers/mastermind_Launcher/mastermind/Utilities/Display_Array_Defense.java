package fr.moko.main.java.games_Launchers.mastermind_Launcher.mastermind.Utilities;

import java.util.ArrayList;



/**
 * Affiche graphiquement le tableau de résolution du "Mastermind" en mode "Defense"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Display_Array_Defense {



    /**
     * Affichage graphiquement le tableau de résolution du "Mastermind" en mode "Defense"
     *
     * @param int_Mastermind_NumberOfUnities : (int) Nombre d'uniés utilisées pour les combinaisons
     * @param int_Mastermind_NumberOfLetters : (int) Nombre de lettres sélectionnées pour le "Mastermind"
     * @param al_Mastermind_Defense : (ArrayList) Données de défense
     */
    public void display_Array_Defense(int int_Mastermind_NumberOfUnities, int int_Mastermind_NumberOfLetters, ArrayList al_Mastermind_Defense) {

        char array_ch_SelectedLetters[] = (char[]) al_Mastermind_Defense.get(0);

        char array_ch_DefenseAnalysis[][] = (char[][]) al_Mastermind_Defense.get(9);

        String str_ColumnNumber = new String();

        for (int i = 0; i < int_Mastermind_NumberOfUnities; i++) {

            if (i == 0) {

                str_ColumnNumber += "  ";
            }

            str_ColumnNumber += " " + (i + 1);
        }

        String str_TopArray = new String();

        for (int i = 0; i < int_Mastermind_NumberOfUnities; i++) {

            if (i == 0) {

                str_TopArray += "  ";
            }

            str_TopArray += " _";
        }

        System.out.print("\n");

        for (int i = 0; i < int_Mastermind_NumberOfLetters; i++) {

            if (i == 0) {

                System.out.print(str_ColumnNumber);
                System.out.print("\n");
                System.out.print(str_TopArray);
                System.out.print("\n");
            }

            for (int j = 0; j < int_Mastermind_NumberOfUnities; j++) {

                if (j == 0) {

                    System.out.print(array_ch_SelectedLetters[i] + " ");
                }

                System.out.print("|" + array_ch_DefenseAnalysis[i][j]);

                if (j == int_Mastermind_NumberOfUnities - 1) {

                    System.out.print("|");
                }
            }

            for (int j = 0; j < int_Mastermind_NumberOfUnities; j++) {

                if (j == 0) {

                    System.out.print("\n  ");
                }

                System.out.print("|_");

                if (j == int_Mastermind_NumberOfUnities - 1) {

                    System.out.print("|");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }
}
