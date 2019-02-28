package fr.moko.main.java.configuration;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * <p>Récupère des valeurs de configuration
 *
 * <ul>
 *     <li>(boolean) Mode développeur</li>
 *     <li>(int) Nombre d'unités des combinaisons du jeu "Recherche +/-"</li>
 *     <li>(int) Nombre d'unités des combinaisons du jeu "Mastermind"</li>
 *     <li>(int) Nombre de lettres utilsées pour le jeu "Mastermind"</li>
 *     <li>(int) Nombre de chances du jeu "Recherche +/-"</li>
 *     <li>(int) Nombre de chances du jeu "Mastermind"</li>
 * </ul>
 *
 * @author : Moko
 * @version : 1.0
 */
public class Configuration {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();


    /**
     * Récupération des valeurs de configurations
     *
     * @param al_Configuration : (ArrayList) Valeurs de configuration
     *
     * @return : (ArrayList) Valeurs de configuration
     */
    public ArrayList get_Configuration(ArrayList al_Configuration) {

        logger.trace("#############################################");
        logger.trace("<<< START >>> Méthode : get_PropertiesValue()");
        logger.trace("#############################################");

        InputStream inputStream;

        // Initialisation (String) des variables
        String str_DevMode = new String();

        String str_Recherche_NumberOfUnities = new String();
        String str_Recherche_NumberOfChances = new String();

        String str_Mastermind_NumberOfUnities = new String();
        String str_Mastermind_NumberOfLetters = new String();
        String str_Mastermind_NumberOfChances = new String();

        // Instance "Properties"
        Properties properties = new Properties();

        // Initialisation "input"
        FileInputStream input = null;

        try {

            // Flux d'entrée de fichier
            input = new FileInputStream("config.properties");

            // Chargement du fichier
            properties.load(input);

            // Récuperation (String) valeurs dans "config.properties"
            str_DevMode =  properties.getProperty("boo_DevMode");

            str_Recherche_NumberOfUnities =  properties.getProperty("int_Recherche_NumberOfUnities");
            str_Recherche_NumberOfChances =  properties.getProperty("int_Recherche_NumberOfChances");

            str_Mastermind_NumberOfUnities =  properties.getProperty("int_Mastermind_NumberOfUnities");
            str_Mastermind_NumberOfLetters =  properties.getProperty("int_Mastermind_NumberOfLetters");
            str_Mastermind_NumberOfChances =  properties.getProperty("int_Mastermind_NumberOfChances");
        }
        catch (IOException io) {

            io.printStackTrace();
        }

        // Initialisation, récupération et injection - (boolean) Mode développeur
        boolean boo_DevMode = Boolean.parseBoolean(str_DevMode);
        al_Configuration.add(0, boo_DevMode);



        // Initialisation, récupération et injection - (int) Nombre d'unités des combinaisons du jeu "Recherche +/-"
        int int_Recherche_NumberOfUnities = Integer.parseInt(str_Recherche_NumberOfUnities);
        al_Configuration.add(1, int_Recherche_NumberOfUnities);

        // Initialisation, récupération et injection - (int) Nombre de chances du jeu "Mastermind"
        int int_Mastermind_NumberOfChances = Integer.parseInt(str_Mastermind_NumberOfChances);
        al_Configuration.add(2, int_Mastermind_NumberOfChances);



        // Initialisation, récupération et injection - (int) Nombre d'unités des combinaisons du jeu "Mastermind"
        int int_Mastermind_NumberOfUnities = Integer.parseInt(str_Mastermind_NumberOfUnities);
        al_Configuration.add(3, int_Mastermind_NumberOfUnities);

        // Initialisation, récupération et injection - (int) Nombre de lettres utilisées pour le jeu "Mastermind"
        int int_Mastermind_NumberOfLetters = Integer.parseInt(str_Mastermind_NumberOfLetters);
        al_Configuration.add(4, int_Mastermind_NumberOfLetters);

        // Initialisation, récupération et injection - (int) Nombre de chances du jeu "Recherche +/-"
        int int_Recherche_NumberOfChances = Integer.parseInt(str_Recherche_NumberOfChances);
        al_Configuration.add(5, int_Recherche_NumberOfChances);

        logger.trace("###########################################");
        logger.trace("<<< END >>> Méthode : get_PropertiesValue()");
        logger.trace("###########################################\n");

        return al_Configuration;
    }
}
