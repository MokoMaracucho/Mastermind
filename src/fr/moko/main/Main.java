package fr.moko.main;

import fr.moko.main.java.games_Launchers.Games_Launcher;

import org.apache.logging.log4j.*;

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

        String str_DevMode = args[0];

        boolean boo_DevMode = Boolean.valueOf(str_DevMode);

        // Instance "Games_Launcher"
        Games_Launcher games_Launcher = new Games_Launcher();
        games_Launcher.games_Launcher(boo_DevMode);
    }
}
