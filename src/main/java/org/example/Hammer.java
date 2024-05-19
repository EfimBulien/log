package org.example;

public class Hammer{
    private String hammer;
    private static final Log hammerLog = new Log("logs/hammer.log");

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
}
