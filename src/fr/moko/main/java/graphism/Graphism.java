package fr.moko.main.java.graphism;

import fr.moko.main.java.delay.Delay;



/**
 * Graphismes du jeu
 *
 * @author : Moko
 * @version : 1.0
 */
public class Graphism {

    // Instance "Delay"
    Delay delay = new Delay();



    /**
     * Affiche "MOKO GAMES INDUSTRY"
     *
     */
    public void display_MOKO_GAMES_INDUSTRY(){

        delay.delay_Image();
        System.out.println("\n /$$$          /$$$                  /$$$   /$$$");
        delay.delay_Image();
        System.out.println("| $$$$        /$$$$                 | $$$  /$$$");
        delay.delay_Image();
        System.out.println("| $$$$$      /$$$$$                 | $$$ /$$$");
        delay.delay_Image();
        System.out.println("| $$$$$$    /$$$$$$    /$$$$$$$$$   | $$$/$$$          /$$$$$$$$$");
        delay.delay_Image();
        System.out.println("| $$$ $$$  /$$$ $$$   /$$$____ $$$  | $$$$$$          /$$$____ $$$");
        delay.delay_Image();
        System.out.println("| $$$\\ $$$$$$$| $$$  /$$$     \\ $$$ | $$$  $$$$      /$$$     \\ $$$");
        delay.delay_Image();
        System.out.println("| $$$ \\ $$$$$ | $$$ |  $$$    /$$$  | $$$\\_  $$$$   |  $$$    /$$$");
        delay.delay_Image();
        System.out.println("| $$$  \\ $$$  | $$$  \\  $$$$$$$$$   | $$$  \\_  $$$$  \\  $$$$$$$$$");
        delay.delay_Image();
        System.out.println(" \\__/   \\__/   \\__/   \\_________/    \\__/    \\____/   \\_________/");
        delay.delay_Image();
        System.out.println("\n---------------------------------------------------- GAMES INDUSTRY\n");
    }



    /**
     * Affiche "GO"
     */
    public void display_GO() {

        delay.delay_Image();
        System.out.println("\n\n / $$$$$$$    / $$$$$$$     /$$$");
        delay.delay_Image();
        System.out.println("| $$$__ $$$  | $$$__ $$$   | $$$");
        delay.delay_Image();
        System.out.println("| $$$ |___/  | $$$ | $$$   | $$$");
        delay.delay_Image();
        System.out.println("| $$$ /$$$$$ | $$$ | $$$   | $$$");
        delay.delay_Image();
        System.out.println("| $$$|_ $$$  | $$$ | $$$   | $$$");
        delay.delay_Image();
        System.out.println("| $$$ | $$$  | $$$ | $$$   |___/");
        delay.delay_Image();
        System.out.println("|  $$$$$$$   |  $$$$$$$     /$$$");
        delay.delay_Image();
        System.out.println(" \\_______/    \\_______/    |___/");
    }



    /**
     * Affiche "HE WON !"
     */
    public void display_HE_WON(){
        delay.delay_Image();
        System.out.println("\n\n /$$$  /$$$  /$$$$$$$$$    /$$$        /$$$  / $$$$$$$   /$$$  /$$$     /$$$");
        delay.delay_Image();
        System.out.println("| $$$ | $$$ | $$$_____/   | $$$       | $$$ | $$$__ $$$ | $$$$| $$$    | $$$");
        delay.delay_Image();
        System.out.println("| $$$ | $$$ | $$$         | $$$  /$$$ | $$$ | $$$ | $$$ | $$$$$ $$$    | $$$");
        delay.delay_Image();
        System.out.println("| $$$$$$$$$ | $$$$$$      | $$$ | $$$ | $$$ | $$$ | $$$ | $$$$$$$$$    | $$$");
        delay.delay_Image();
        System.out.println("| $$$_  $$$ | $$$__/      |  $$$|$$$$$|$$$  | $$$ | $$$ | $$$ $$$$$    | $$$");
        delay.delay_Image();
        System.out.println("| $$$ | $$$ | $$$          \\ $$$$$$ $$$$$$  | $$$ | $$$ | $$$\\ $$$$    |___/");
        delay.delay_Image();
        System.out.println("| $$$ | $$$ | $$$$$$$$$     | $$$$ | $$$$   |  $$$$$$$  | $$$ \\ $$$     /$$$");
        delay.delay_Image();
        System.out.println("|___/ |___/ |_________/      \\___/  \\___/    \\_______/  |___/  \\__/    |___/\n\n");
    }
}
