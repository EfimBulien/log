package org.example;

import java.io.File;

public class Person {
    private String name;
    static Log personLog;

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

    static {
        try {
            File file = new File("logs/person.log");
            if (!file.exists()) {
                file.createNewFile();
            }
            personLog = new Log("logs/person.log");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}