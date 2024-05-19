package org.example;

import java.io.File;

public class Hammer{
    String hammer;
    static Log hammerLog;

    public Hammer(String hammer) {
        hammerLog.logger.info("Hammer: " + hammer);
        try {
            this.hammer = hammer;
        } catch (Exception e) {
            hammerLog.logger.warning(e.getMessage());
            hammerLog.logger.severe(e.getMessage());
        }
    }

    public void setHammer(String hammer) {
        hammerLog.logger.info("Hammer: " + hammer);
        try {
            this.hammer = hammer;
        } catch (Exception e) {
            hammerLog.logger.warning(e.getMessage());
            hammerLog.logger.severe(e.getMessage());
        }
    }

    public String getHammer() {
        hammerLog.logger.info("Hammer: " + hammer);
        try {
            return hammer;
        } catch (Exception e) {
            hammerLog.logger.warning(e.getMessage());
            hammerLog.logger.severe(e.getMessage());
            return null;
        }
    }

    static {
        try {
            File file = new File("logs/hammer.log");
            if (!file.exists()) {
                file.createNewFile();
            }
            hammerLog = new Log("logs/hammer.log");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
