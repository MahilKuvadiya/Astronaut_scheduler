package config;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class LoggerConfig {
    public static Logger setupLogger(String fileName) {
        Logger logger = Logger.getLogger(fileName);
        try {
            // Ensure the logs directory exists
            File logsDir = new File("logs");
            if (!logsDir.exists()) {
                logsDir.mkdirs();
            }

            // Create the full path for the log file
            String fullPath = "logs" + File.separator + fileName;

            // Create FileHandler with the full path
            FileHandler fileHandler = new FileHandler(fullPath, true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);

            // Set the log level (adjust as needed)
            logger.setLevel(Level.ALL);

        } catch (IOException e) {
            System.err.println("Error setting up logger: " + e.getMessage());
            e.printStackTrace();
        }
        return logger;
    }
}