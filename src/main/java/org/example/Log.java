package org.example;

import java.io.IOException;
import java.util.logging.*;

public class Log {

    public Logger logger;

    FileHandler fh;

    public Log(String fileName) throws SecurityException ,IOException {
        fh = new FileHandler(fileName, true);
        logger = Logger.getLogger("logger");
        logger.addHandler(fh);
        logger.setLevel(Level.INFO);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }
}
