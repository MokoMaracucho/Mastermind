package fr.moko.main.java.games_Launchers.recherche_Launcher.recherche;

import fr.moko.main.java.delay.Delay;
import fr.moko.main.java.dev_Mode.Dev_Mode;


/**
 * Textes attenants au jeu "Recherche +/-"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Texts_Recherche {

    // Instance "Delay"
    Delay delay = new Delay();

    // Instance "Dev_Mode"
    Dev_Mode dev_Mode = new Dev_Mode();

    // Instance "Methods_Texts_Recherche"
    Methods_Texts_Recherche methods_Texts_Recherche = new Methods_Texts_Recherche();



    /**
     * Affiche l'énoncé en mode défense
     *
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     */
    public void display_Defense_Statement(int int_Recherche_NumberOfUnities){

        delay.delay_Text();
        System.out.println("\tA vous de choisir la combinaison !\n");
        delay.delay_Text();
        System.out.println("\tC'est à l'ordinateur de la retrouver.\n");

        delay.delay_Text();
        System.out.println("Saisissez un nombre entre 0 et " + methods_Texts_Recherche.run_str_NumberMax(int_Recherche_NumberOfUnities) + " !\n");
    }



    /**
     * Affiche "Ceci n'est pas un nombre !"
     */
    public void display_CECI_N_EST_PAS_UN_NOMBRE(){

        delay.delay_Text();
        System.out.println("\nCeci n'est pas un nombre !");
    }



    /**
     * Affiche "Ce nombre est négatif !"
     */
    public void display_CE_NOMBRE_EST_NEGATIF(){

        delay.delay_Text();
        System.out.println("\nCe nombreux est négatif !");
    }



    /**
     * Affiche "Il faut que vous saisissiez un entier positif."
     */
    public void display_IL_FAUT_QUE_VOUS_SAISISSIEZ_UN_ENTIER_POSITIF(){

        delay.delay_Text();
        System.out.println("Il faut que vous saisissiez un entier positif.");
    }



    /**
     * Affiche "Ce nombre est trop grand !"
     */
    public void display_CE_NOMBRE_EST_TROP_GRAND(){

        delay.delay_Text();
        System.out.println("\nCe nombre est trop grand !");
    }


    /**
     * Affiche "Le nombre doit être inférieur à ..."
     *
     * @param int_NumberOfUnities : (int) Nombre d'unités utilisé pour les combinaisons
     */
    public void display_LE_NOMBRE_DOIT_ETRE_INFERIEUR_A(int int_NumberOfUnities){

        delay.delay_Text();
        System.out.println("Le nombre doit être inférieur à "+ methods_Texts_Recherche.run_str_NumberMax(int_NumberOfUnities));
    }


    /**
     * Affiche le résultat de la comparaison
     *
     * @param array_str_Main_Menu_Choices : (String[]) Choix du menu principal
     * @param str_SubMode : (String) Sous-mode en mode "Duel"
     * @param str_ComparisonResult : (String) Résultat de la comparaison
     */
    public void display_RESULTAT_DE_LA_COMPARAISON(String array_str_Main_Menu_Choices[], String str_SubMode, String str_ComparisonResult){

        String str_NewLine = new String();

        switch (array_str_Main_Menu_Choices[1]){

            case "Challenger" :

                str_NewLine = "\n";

                break;

            case "Défense" :

                str_NewLine = "";

                break;

            case "Duel" :

                switch (str_SubMode){

                    case "Challenger" :

                        str_NewLine = "\n";

                        break;

                    case "Défense" :

                        str_NewLine = "";

                        break;
                }
                break;
        }

        delay.delay_Text();
        System.out.println(str_NewLine + "Résultat de la comparaison :                       " + str_ComparisonResult);
    }


    /**
     * Affiche l'enoncé en mode "Challenger"
     *
     * @param boo_DevMode : (boolean) Si en mode développeur
     * @param int_Recherche_NumberOfUnities : (int) Nombre d'unités utilisées pour les combinaisons
     * @param int_Recherche_NumberOfChances : (int) Nombre de chances
     * @param array_int_RandomNumber : (int[]) Combinaison générée de manière aléatoire
     */
    public void display_Challenger_Statement(boolean boo_DevMode, int int_Recherche_NumberOfUnities, int int_Recherche_NumberOfChances, int array_int_RandomNumber[]){

        delay.delay_Text();
        System.out.println("\n\tTrouvez la combinaison générée par l'ordinateur !");

        if (boo_DevMode) {

            dev_Mode.display_Combination_Recherche(int_Recherche_NumberOfUnities, array_int_RandomNumber);
        }

        delay.delay_Text();
        System.out.println("\n\tAprès chaques propositions, un indice vous sera donné pour chaque chiffre.\n");

        delay.delay_Text();
        System.out.println("\t\t- \"-\" : le chiffre est plus petit;");
        delay.delay_Text();
        System.out.println("\t\t- \"+\" : le chiffre est plus grand;");
        delay.delay_Text();
        System.out.println("\t\t- \"=\" : vous avez trouvé le bon chiffre.");

        delay.delay_Text();
        System.out.println("\nSaisissez un nombre entre 0 et " + methods_Texts_Recherche.run_str_NumberMax(int_Recherche_NumberOfUnities) + ".");
        System.out.println("\nVous avez " + int_Recherche_NumberOfChances + " chances !");
    }


    /**
     * Affiche "Votre proposition ..."
     *
     * @param str_Proposition (String) Proposition en chaîne de caractère
     */
    public void display_VOTRE_PROPOSITION(String str_Proposition){

        delay.delay_Text();
        System.out.print("\nVotre proposition :                                " + str_Proposition);
    }
}
