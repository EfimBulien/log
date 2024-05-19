package org.example;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static final Log log = new Log("logs/main.log");
    static Scanner scanner = new Scanner(System.in);

    public static ArrayList<Hammer> rawHammers = new ArrayList<>();
    public static ArrayList<Hammer> packedHammers = new ArrayList<>();

    public static Work[] works = {
            new Work("Собирать молотки"),
            new Work("Пилить ручки"),
            new Work("Делать бойки"),
            new Work("Упаковывать молотки")
    };

    public static Employee[] employees = {
            new Employee("Ходжахов Эмиль"),
            new Employee("Лысенко Семён"),
            new Employee("Солнцев Гоген")
    };

    public static void main(String[] args) {
        int index, num;
        boolean isRunning = true;

        String[] functionNames = {
                "Статус завода",
                "Взять работу",
                "Взять работника",
                "Получить упакованный молоток",
                "Получить неупакованный молоток",
                "Добавить молоток",
                "Упаковать молоток"
        };

        try {
            while (isRunning) {
                System.out.println("Выберите действие на заводе:");
                num = 1;

                for (String functionName : functionNames) {
                    System.out.println(num + ". " + functionName);
                    num++;
                }

                System.out.println("0. Выйти из программы");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        factoryStatus();
                        break;
                    case 2:
                        String workOutput = getWork();
                        System.out.println(workOutput);
                        break;
                    case 3:
                        String employeeOutput = getRandomEmployee();
                        System.out.println(employeeOutput);
                        break;
                    case 4:
                        String packedHammerOutput = getPackedHammer();
                        System.out.println(packedHammerOutput);
                        break;
                    case 5:
                        String rawHammerOutput = getRawHammer();
                        System.out.println(rawHammerOutput);
                        break;
                    case 6:
                        System.out.println("Выберете молоток: ");
                        index = scanner.nextInt();
                        addHammers(index);
                        System.out.println("Молоток " + index + " добавлен");
                        break;
                    case 7:
                        System.out.println("Выберете молоток: ");
                        index = scanner.nextInt();
                        sealHammer(index);
                        System.out.println("Молоток " + index + " упакован");
                        break;
                    case 0:
                        System.out.println("Удачного вам дня!");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Некорректный ввод");
                        break;
                }
            }
        } catch (Exception e) {
            log.logger.warning(e.getMessage());
            log.logger.severe(e.getMessage());
        }
    }

    public static void factoryStatus() {
        try {
            int hours = Integer.parseInt(new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()));

            if (hours < 8 || hours > 22) {
                System.out.println("Завод закрыт! Приходите завтра");
            }
            else {
                System.out.println("Рабочие работают, завод работает!");
            }
        } catch (NumberFormatException e) {
            log.logger.warning(e.getMessage());
            log.logger.severe(e.getMessage());
        }
    }

    public static String getWork() {
        try {
            return works[new Random().nextInt(works.length)].getTask();
        } catch (Exception e){
            log.logger.warning(e.getMessage());
            log.logger.severe(e.getMessage());
            return null;
        }
    }

    public static String getRandomEmployee() {
        try {
            return employees[new Random().nextInt(employees.length)].getName();
        } catch (Exception e){
            log.logger.warning(e.getMessage());
            log.logger.severe(e.getMessage());
            return null;
        }
    }

    public static String getPackedHammer() {
        return getString(packedHammers);
    }

    public static String getRawHammer() {
        return getString(rawHammers);
    }

    private static String getString(ArrayList<Hammer> rawHammers) {
        try {
            int index = new Random().nextInt(rawHammers.size());
            return rawHammers.get(index).getHammer();
        } catch (Exception e) {
            log.logger.warning(e.getMessage());
            log.logger.severe(e.getMessage());
            return null;
        }
    }

    public static void addHammers(int index) {
        try{
            for (int i = 1; i < index; i++) {
                rawHammers.add(new Hammer("МОЛОТОК " + i));
            }
        } catch (Exception e) {
            log.logger.warning(e.getMessage());
            log.logger.severe(e.getMessage());
        }
    }

    public static void sealHammer(int index) {
        try {
            Hammer hammer = rawHammers.get(index);
            packedHammers.add(hammer);
            rawHammers.remove(index);
        } catch (Exception e) {
            log.logger.warning(e.getMessage());
            log.logger.severe(e.getMessage());
        }
    }
}
