package observers;

import java.util.logging.Logger;
import config.LoggerConfig;

public class TaskConflictObserver implements Observer {
    private static final Logger LOGGER;

    static {
        LOGGER = LoggerConfig.setupLogger("conflict_observer.log");
    }

    @Override
    public void update(String message) {
        System.out.println("Conflict Alert: " + message);
        LOGGER.warning("Task Conflict: " + message);
    }
}