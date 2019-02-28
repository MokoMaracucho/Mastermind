package fr.moko.main.java.delay;



/**
 * <p>Délais d'affichage</p>
 *
 * <ul>
 *     <li>Textes : "int_DelayText"</li>
 *     <li>Images : "int_DelayImage"</li>
 * </ul>
 *
 * @author : Moko
 * @version : 1.0
 */
public class Delay {

    // Initialisation - (int) Délais textes et images
    int int_DelayText = 200;
    int int_DelayImage = 250;



    /**
     * Délai d'affichage des textes
     */
    public void delay_Text() {

        try {

            Thread.sleep(int_DelayText);
        }
        catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }



    /**
     * Délai d'affichage des images
     */
    public void delay_Image() {

        try {

            Thread.sleep(int_DelayImage);
        }
        catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}
