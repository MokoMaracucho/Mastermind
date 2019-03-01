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
        System.out.print("Saisissez votre combinaison : ");
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
        System.out.print("\nVotre combinaison :                                " + str_Combination);
    }



    /**
     * Affiche le nombre de chances restantes
     *
     * @param int_NumberOfChances : (int) Nombre de chances
     * @param array_str_Main_Menu_Choices : (array String) Choix du menu principal
     * @param str_Sub_Mode: (String) Sous-mode en mode "Duel"
     * @param i : (int) Nombre de tours
     */
    public void display_RemainingChances(int int_NumberOfChances, String array_str_Main_Menu_Choices[], String str_Sub_Mode, int i){

        String str_Vous_OU_Lui = run_str_Vous_OU_Lui(array_str_Main_Menu_Choices, str_Sub_Mode);

        String str_Chance_S = run_str_Chance_S(int_NumberOfChances, i);

        delay.delay_Text();
        System.out.println("\n\nIl " + str_Vous_OU_Lui + " reste " + (int_NumberOfChances - i) + " " + str_Chance_S + " !\n");
    }


    /**
     * Retourne "vous" ou "lui"
     *
     * @param array_str_MenuChoices : (array String) Tableau contenant les choix du menu principal
     * @param str_SubMode : (String) Sous-mode si en mode "Duel"
     *
     * @return : (String) "vous" ou "lui"
     */
    public String run_str_Vous_OU_Lui(String array_str_MenuChoices[], String str_SubMode) {

        String str_Vous_OU_Lui = new String();

        switch (array_str_MenuChoices[1]) {

            case "Challenger" :

                str_Vous_OU_Lui = "vous";

                break;

            case "Défense":

                str_Vous_OU_Lui = "lui";

                break;

            case "Duel" :

                switch (str_SubMode) {

                    case "Challenger" :

                        str_Vous_OU_Lui = "vous";

                        break;

                    case "Défense":

                        str_Vous_OU_Lui = "lui";

                        break;
                }
        }

        return str_Vous_OU_Lui;
    }



    /**
     * Retourne "chance" ou "chances"
     *
     * @param int_NumberOfChances : (int) Nombre de chances
     * @param i : (int) Compteur de tours
     *
     * @return : (String) "chance" ou "chances"
     */
    public String run_str_Chance_S(int int_NumberOfChances, int i){

        String str_Chance_S = "";

        if ((int_NumberOfChances - i) == 1) {

            str_Chance_S = "chance";
        }
        else {

            str_Chance_S = "chances";
        }

        return str_Chance_S;
    }



    /**
     * Affiche "Proposition de l'ordinateur"
     *
     * @param str_ComputerProposal : (String) Proposition de l'ordinateur
     * @param i : (int) Nombre de tours
     */
    public void display_PROPOSITION_DE_L_ORDINATEUR(String str_ComputerProposal, int i){

        String str_NewLine = new String();

        if (i == 0) {

            str_NewLine = "\n\n";
        }
        else {

            str_NewLine = "\n";
        }

        delay.delay_Text();
        System.out.println(str_NewLine + "Proposition de l'ordinateur :                      " + str_ComputerProposal + "\n");
    }



    /**
     * Affiche "C'est votre dernière chance !!!"
     */
    public void display_C_EST_VOTRE_DERNIERE_CHANCE(){

        delay.delay_Text();
        System.out.print("\nC'est votre dernière chance !!!");
    }
}
