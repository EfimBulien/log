package org.example;

public class Work{
    private String task;
    private static final Log workLog = new Log("logs/work.log");

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
}
