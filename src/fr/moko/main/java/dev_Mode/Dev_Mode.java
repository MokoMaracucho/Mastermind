package fr.moko.main.java.dev_Mode;

import fr.moko.main.java.delay.Delay;



/**
 * Méthodes attenantes au mode développeur
 *
 * @author : Moko
 * @version : 1.0
 */
public class Dev_Mode {

    // Instance "Delay"
    Delay delay = new Delay();



    /**
     * Affiche "Vous êtes en mode développeur"
     */
    public void display_VOUS_ETES_EN_MODE_DEVELOPPEUR() {

        delay.delay_Text();
        System.out.println("|||||||||||||||||| Vous êtes en mode développeur ||||||||||||||||||\n");
    }
}
