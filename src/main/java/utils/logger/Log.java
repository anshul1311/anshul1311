package utils.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log {
    private static final Logger log = LogManager.getLogger(Log.class.getName());


    /**
     * method to display errors in log.
     *
     * @param className name of class in which error occurred.
     * @param methodName name of method in which error occurred.
     * @param exception stack trace of exception
     */
    public static void logError(String className, String methodName, String exception) {
        log.info("ClassName :" + className);
        log.info("MethodName :" + methodName);
        log.info("Exception :" + exception);
        log.info("-----------------------------------------------------------------------------------");
    }

    /**
     * method to display information in logs
     *
     * @param message message to be displayed
     */
    public static void info(String message) {

        log.info(message);
    }
}
