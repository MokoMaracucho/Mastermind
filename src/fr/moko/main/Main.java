package fr.moko.main;

import fr.moko.main.java.Game_Launchers.Game_Launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class "Main {}"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Main {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();

    /**
     * Méthode "main(String[] args)"
     *
     * @param args : ...
     */
    public static void main(String[] args) {

        // Loggers
        logger.trace("msg de trace"); // E/S methods
        logger.debug("msg de debogage"); // Display values of datas
        logger.info("msg d'information"); //loading of conf file, beg/end long process
        logger.warn("msg d'avertissement"); // error login, invalid data
        logger.error("msg d'erreur"); // all throwned exceptions
        logger.fatal("msg d'erreur fatale");  // error DB, exceptions which stop the program
        System.out.print("\n");



        // Instance "Game_Launcher"
        Game_Launcher game_Launcher = new Game_Launcher();
        game_Launcher.game_Launcher();
    }
}
