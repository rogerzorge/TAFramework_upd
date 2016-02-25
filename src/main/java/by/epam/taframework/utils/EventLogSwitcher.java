package by.epam.taframework.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Yahor_Faliazhynski on 2/25/2016.
 */
public class EventLogSwitcher {

    public static void eventLogger(String eventType, String eventDescription) {
        Logger logger = LogManager.getRootLogger();
        switch (eventType) {
            case "info":
                logger.info(eventDescription);
                break;
            case "warn":
                logger.warn(eventDescription);
                break;
            case "error":
                logger.error(eventDescription);
                break;
        }
    }

}
