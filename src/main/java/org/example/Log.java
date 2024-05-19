package org.example;

import java.io.IOException;
import java.util.logging.*;

public class Log {
    public Logger logger;

    public Log(String fileName) {
        logger = Logger.getLogger(fileName);
        try {
            FileHandler fh = new FileHandler(fileName, true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.WARNING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
