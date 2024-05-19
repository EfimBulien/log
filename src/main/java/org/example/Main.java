package org.example;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static Log log;

    static {
        try {
            File file = new File("logs/main.log");
            if (!file.exists()) {
                file.createNewFile();
            }
            log = new Log("logs/main.log");
        } catch (Exception e) {
            e.printStackTrace();
            log.logger.warning(e.getMessage());
            log.logger.severe(e.getMessage());
        }
    }

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
        boolean isRunning = true;
        int index;

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
                int num = 1;

                System.out.println("Выберите действие на заводе:");

                for (String functionName : functionNames) {
                    System.out.println(num + ". " + functionName);
                    num++;
                }

                System.out.println("0. Выйти из программы");

                int choice = scanner.nextInt();

                if (choice == 1) factoryStatus();
                else if (choice == 2) {
                    String output = getWork();
                    System.out.println(output);
                }
                else if (choice == 3) {
                    String output = getRandomEmployee();
                    System.out.println(output);
                }
                else if (choice == 4) {
                    String output = getPackedHammer();
                    System.out.println(output);
                }
                else if (choice == 5) {
                    String output = getRawHammer();
                    System.out.println(output);
                }
                else if (choice == 6) {
                    System.out.println("Выберете молоток: ");
                    index = scanner.nextInt();
                    addHammers(index);
                    String output = "Молоток " + index + " добавлен";
                    System.out.println(output);
                }
                else if (choice == 7) {
                    System.out.println("Выберете молоток: ");
                    index = scanner.nextInt();
                    sealHammer(index);
                    String output = "Молоток " + index + " упакован";
                    System.out.println(output);
                }
                else if (choice == 0) {
                    System.out.println("Удачного вам дня!");
                    isRunning = false;
                }
                else {
                    System.out.println("Некорректный ввод");
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
        try {
            int index = new Random().nextInt(packedHammers.size());
            return packedHammers.get(index).getHammer();
        } catch (Exception e) {
            log.logger.warning(e.getMessage());
            log.logger.severe(e.getMessage());
            return null;
        }
    }

    public static String getRawHammer() {
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