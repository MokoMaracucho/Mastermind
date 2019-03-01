package fr.moko.main.java.games_Launchers.Games;

import fr.moko.main.java.delay.Delay;



/**
 * Textes attenants aux jeux
 *
 * @author : Moko
 * @version : 1.0
 */
public class Texts_Games {

    // Instances "Delay"
    Delay delay = new Delay();



    /**
     *  Affiche "But du jeu :"
     */
    public void display_BUT_DU_JEU() {

        delay.delay_Text();
        System.out.println("But du jeu :\n");
    }



    /**
     * Affiche l'énoncé en mode "Duel"
     */
    public void display_Duel_Statement(){

        delay.delay_Text();
        System.out.println("\tVous allez jouer contre l'ordinateur !\n");
        delay.delay_Text();
        System.out.println("\tChacun votre tour, vous tenterez de découvrir la combinaison de l'adversaire.\n");
        delay.delay_Text();
        System.out.println("\tLe premier ayant trouvé la combinaison aura gagné !\n");
    }



    /**
     * Affiche "A vous de jouer !"
     */
    public void display_A_VOUS_DE_JOUER(){

        delay.delay_Text();
        System.out.println("A vous de jouer !\n");
    }



    /**
     * Affiche "Saisissez votre combinaison : "
     */
    public void display_SAISISSEZ_VOTRE_COMBINAISON(){

        delay.delay_Text();
        System.out.print("Saisissez votre combinaison : \n");
    }



    /**
     * Affiche "Faites votre proposition : "
     */
    public void display_FAITES_VOTRE_PROPOSITION(){

        delay.delay_Text();
        System.out.print("Faites votre proposition : ");
    }



    /**
     * Affiche "Veuillez réessayer."
     */
    public void display_VEUILLEZ_REESSAYER(){

        delay.delay_Text();
        System.out.println("Veuillez réessayer.\n");
    }



    /**
     * Affiche "Votre combinaison ..."
     *
     * @param str_Combination : (String) Combinaison sous forme de chaîne de caractères
     */
    public void display_VOTRE_COMBINAISON(String str_Combination){

        delay.delay_Text();
        System.out.print("Votre combinaison :                                " + str_Combination + "\n");
    }
}
