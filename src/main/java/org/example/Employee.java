package org.example;

public class Employee extends Person {
    private static final Log employeeLog = new Log("logs/employee.log");
    private String name;

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
}
