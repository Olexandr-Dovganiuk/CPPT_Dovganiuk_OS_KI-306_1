package KI306.Dovganiuk.Lab3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * This class represents an airplane.
 */
public class Airplane {
    private String model;
    private Engine engine;
    private Avionics avionics;
    private Body body;
    private double fuelCapacity;
    protected boolean isFlying;
    private int currentAltitude;
    private boolean landingGearDeployed;
    private int passengersOnBoard;
    private boolean lightsOn;

    /**
     * Constructor for Airplane class.
     * @param model The model of the airplane.
     * @param engine The engine of the airplane.
     * @param avionics The avionics of the airplane.
     * @param body The body of the airplane.
     */
    public Airplane(String model, Engine engine, Avionics avionics, Body body) {
        this.model = model;
        this.engine = engine;
        this.avionics = avionics;
        this.body = body;
    }

    /**
     * Constructor for Airplane class.
     * @param model The model of the airplane.
     */
    public Airplane(String model) {
        this.model = model;
        this.engine = null;
        this.avionics = null;
        this.body = null;
    }

    /**
     * Method to take off the airplane.
     */
    public void takeOff() {
        logAction("Взлетів");
        isFlying = true;
    }

    /**
     * Method to land the airplane.
     */
    public void land() {
        logAction("Приземлився");
        logAction("Приземлення успішне!!!!\n=============================================");
        isFlying = false;
    }

    /**
     * Method to fly the airplane at a certain altitude.
     * @param altitude The altitude at which the airplane is flying.
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
     * Method to set the engine of the airplane.
     * @param engine The engine to be set.
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
        logAction("Двигун встановлено");
    }

    /**
     * Method to remove the engine of the airplane.
     */
    public void removeEngine() {
        this.engine = null;
        logAction("Двигун видалено");
    }

    /**
     * Method to deploy the landing gear of the airplane.
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
     * Method to retract the landing gear of the airplane.
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
     * Method to add passengers to the airplane.
     * @param count The number of passengers to be added.
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
     * Method to turn on the lights of the airplane.
     */
    public void turnOnLights() {
        lightsOn = true;
        logAction("Увімкнено освітлення");
    }

    /**
     * Method to turn off the lights of the airplane.
     */
    public void turnOffLights() {
        lightsOn = false;
        logAction("Вимкнено освітлення");
    }

    /**
     * Method to refuel the airplane.
     * @param liters The amount of fuel to be added.
     */
    public void refuel(double liters) {
        fuelCapacity += liters;
        logAction("Поповнено пальне. Поточний об'єм пального: " + fuelCapacity + " л");
    }

    /**
     * Method to log an action.
     * @param action The action to be logged.
     */
    public void logAction(String action) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log_lab3.txt", true));
            writer.write(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)+"   "+model + ": " + action);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This class represents an engine.
     */
    public static class Engine {
        private String type;

        /**
         * Constructor for Engine class.
         * @param type The type of the engine.
         */
        public Engine(String type) {
            this.type = type;
        }
    }

    /**
     * This class represents an avionics.
     */
    public static class Avionics {
        private String equipment;

        /**
         * Constructor for Avionics class.
         * @param equipment The equipment of the avionics.
         */
        public Avionics(String equipment) {
            this.equipment = equipment;
        }
    }

    /**
     * This class represents a body.
     */
    public static class Body {
        private int seats;

        /**
         * Constructor for Body class.
         * @param seats The number of seats in the body.
         */
        public Body(int seats) {
            this.seats = seats;
        }
    }

    /**
     * Method to close the log file.
     */
    public static void closeLogFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log_lab3.txt", true));
            writer.write(LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + "   " + "-------------- Закриття файлу логу--------------\\n");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}