package KI306.Dovganiuk.Lab2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Клас, що представляє літак
 */
public class Airplane {
    private String model;
    private Engine engine;
    private Avionics avionics;
    private Body body;
    private double fuelCapacity;
    private boolean isFlying;
    private int currentAltitude;
    private boolean landingGearDeployed;
    private int passengersOnBoard;
    private boolean lightsOn;

    /**
     * Конструктор, що створює літак з заданими параметрами
     * @param model модель літака
     * @param engine двигун літака
     * @param avionics авіоніка літака
     * @param body кабіна літака
     */
    public Airplane(String model, Engine engine, Avionics avionics, Body body) {
        this.model = model;
        this.engine = engine;
        this.avionics = avionics;
        this.body = body;
    }

    /**
     * Конструктор, що створює літак з заданою моделлю
     * @param model модель літака
     */
    public Airplane(String model) {
        this.model = model;
        this.engine = null;
        this.avionics = null;
        this.body = null;
    }

    /**
     * Метод, що викликає взлет літака
     */
    public void takeOff() {
        logAction("Взлетів");
        isFlying = true;
    }

    /**
     * Метод, що викликає приземлення літака
     */
    public void land() {
        logAction("Приземлився");
        logAction("Приземлення успішне!!!! \n=============================================");
        isFlying = false;
    }

    /**
     * Метод, що змінює висоту польоту літака
     * @param altitude висота польоту
     */
    public void fly(int altitude) {
        if (isFlying) {
            currentAltitude = altitude;
            logAction("Летить на висоті " + altitude + " метрів");
        } else {
            logAction("Літак не в повітрі. Неможливо змінити висоту.");
        }
    }

    /**
     * Метод, що встановлює двигун літака
     * @param engine двигун літака
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
        logAction("Двигун встановлено");
    }

    /**
     * Метод, що видаляє двигун з літака
     */
    public void removeEngine() {
        this.engine = null;
        logAction("Двигун видалено");
    }

    /**
     * Метод, що висунути шасі
     */
    public void deployLandingGear() {
        if (isFlying) {
            landingGearDeployed = true;
            logAction("Висування шасі");
        } else {
            logAction("Літак не в повітрі. Неможливо висунути шасі.");
        }
    }

    /**
     * Метод, що закрити шасі
     */
    public void retractLandingGear() {
        if (isFlying) {
            landingGearDeployed = false;
            logAction("Закриття шасі");
        } else {
            logAction("Літак не в повітрі. Неможливо закрити шасі.");
        }
    }

    /**
     * Метод, що додає пасажирів на борт
     * @param count кількість пасажирів
     */
    public void addPassengers(int count) {
        if (!isFlying || body.seats >= count) {
            passengersOnBoard += count;
            logAction("Пасажирів на борту: " + passengersOnBoard);
        } else if (isFlying) {
            logAction("Літак у повітрі. Неможливо додати пасажирів.");
        } else {
            logAction("Літак вміщує не більше " + body.seats + " пасажирів");
        }
    }

    /**
     * Метод, що увімкне освітлення
     */
    public void turnOnLights() {
        lightsOn = true;
        logAction("Увімкнено освітлення");
    }

    /**
     * Метод, що вимкне освітлення
     */
    public void turnOffLights() {
        lightsOn = false;
        logAction("Вимкнено освітлення");
    }

    /**
     * Метод, що поповнює пальне
     * @param liters кількість літрів пального
     */
    public void refuel(double liters) {
        fuelCapacity += liters;
        logAction("Поповнено пальне. Поточний об'єм пального: " + fuelCapacity + " л");
    }

    /**
     * Метод, що записує дію в файл логу
     * @param action дія
     */
    public void logAction(String action) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log_lab2.txt", true));
            writer.write(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)+"   "+model + ": " + action);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Клас, що представляє двигун
     */
    public static class Engine {
        private String type;

        /**
         * Конструктор, що створює двигун з заданим типом
         * @param type тип двигуна
         */
        public Engine(String type) {
            this.type = type;
        }
    }

    /**
     * Клас, що представляє авіоніку
     */
    public static class Avionics {
        private String equipment;

        /**
         * Конструктор, що створює авіоніку з заданим обладнанням
         * @param equipment обладнання авіоніки
         */
        public Avionics(String equipment) {
            this.equipment = equipment;
        }
    }

    /**
     * Клас, що представляє кабіну
     */
    public static class Body {
        private int seats;

        /**
         * Конструктор, що створює кабіну з заданою кількістю місць
         * @param seats кількість місць
         */
        public Body(int seats) {
            this.seats = seats;
        }
    }

/**
 * Метод, що закриває файл
 */
    public static void closeLogFile() {
        //logAction("--------------File Close----------------");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log_lab2.txt", true));
            writer.write(LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + "   " + "-------------- Закриття файлу логу--------------\n");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
