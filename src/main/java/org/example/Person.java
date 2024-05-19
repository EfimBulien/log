package org.example;

public class Person {
    private String name;
    private static final Log personLog = new Log("logs/person.log");

    public Person() {
        personLog.logger.info("Person name: " + name);
    }

    public String getName() {
        personLog.logger.info("Person name: " + name);
        try {
            return name;
        } catch (Exception e) {
            personLog.logger.warning(e.getMessage());
            personLog.logger.severe(e.getMessage());
            return null;
        }
    }

    public void setName(String name) {
        personLog.logger.info("Person name: " + name);
        try {
            this.name = name;
        } catch (Exception e) {
            personLog.logger.warning(e.getMessage());
            personLog.logger.severe(e.getMessage());
        }
    }

    public static Person createPerson() {
        return new Person();
    }
}
