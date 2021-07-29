import java.util.Formatter;
import java.util.logging.*;

public class Main {
    private static void configureLogging() {
        final Logger LOGGER_A = Logger.getLogger("org.stepic.java.logging.ClassA");
        final Logger LOGGER_B = Logger.getLogger("org.stepic.java.logging.ClassB");
        final Logger LOGGER_UPPER = Logger.getLogger("org.stepic.java");
        LOGGER_A.setParent(LOGGER_UPPER);
        LOGGER_B.setParent(LOGGER_UPPER);
        LOGGER_UPPER.setUseParentHandlers(false);
        LOGGER_A.setLevel(Level.FINEST);
        LOGGER_B.setLevel(Level.WARNING);
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new XMLFormatter());
        LOGGER_UPPER.addHandler(consoleHandler);
    }
}

