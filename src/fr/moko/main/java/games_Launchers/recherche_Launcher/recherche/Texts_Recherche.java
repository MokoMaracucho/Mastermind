package fr.moko.main.java.games_Launchers.recherche_Launcher.recherche;

import fr.moko.main.java.delay.Delay;



/**
 * Textes attenants au jeu "Recherche +/-"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Texts_Recherche {

    // Instance "Delay"
    Delay delay = new Delay();

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
}
