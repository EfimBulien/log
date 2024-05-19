package org.example;

import java.io.File;

public class Employee extends Person {
    static public Log employeeLog;
    String name;

    public Employee(String name) {
        employeeLog.logger.info("Employee name: " + name);
        try {
            this.name = name;
        } catch (Exception e) {
            employeeLog.logger.warning(e.getMessage());
            employeeLog.logger.severe(e.getMessage());
        }
    }

    public void setName(String name) {
        employeeLog.logger.info("Employee name: " + name);
        try {
            this.name = name;
        } catch (Exception e) {
            employeeLog.logger.warning(e.getMessage());
            employeeLog.logger.severe(e.getMessage());
        }
    }

    public String getName() {
        employeeLog.logger.info("Employee name: " + name);
        try {
            return name;
        } catch (Exception e) {
            employeeLog.logger.warning(e.getMessage());
            employeeLog.logger.severe(e.getMessage());
            return null;
        }
    }

    static {
        try {
            File file = new File("logs/employee.log");
            if (!file.exists()) {
                file.createNewFile();
            }
            employeeLog = new Log("logs/employee.log");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}