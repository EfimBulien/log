package org.example;

import java.io.File;

public class Work{
    String task;
    private static Log workLog;

    public Work(String task) {
        workLog.logger.info("Work task: " + task);
        try {
            this.task = task;
        } catch (Exception e) {
            workLog.logger.warning(e.getMessage());
            workLog.logger.severe(e.getMessage());
        }
    }

    public void setTask(String task) {
        workLog.logger.info("Work task: " + task);
        try {
            this.task = task;
        } catch (Exception e) {
            workLog.logger.warning(e.getMessage());
            workLog.logger.severe(e.getMessage());
        }
    }

    public String getTask() {
        workLog.logger.info("Work task: " + task);
        try {
            return task;
        } catch (Exception e) {
          workLog.logger.warning(e.getMessage());
          workLog.logger.severe(e.getMessage());
          return null;
        }
    }

    static {
        try {
            File file = new File("logs/work.log");
            if (!file.exists()) {
                file.createNewFile();
            }
            workLog = new Log("logs/work.log");
        } catch (Exception e) {
            if (workLog != null) {
                workLog.logger.warning(e.getMessage());
                workLog.logger.severe(e.getMessage());
            }
        }
    }
}
