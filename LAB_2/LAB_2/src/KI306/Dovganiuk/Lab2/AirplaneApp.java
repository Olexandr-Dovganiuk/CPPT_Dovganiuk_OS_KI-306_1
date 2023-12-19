package KI306.Dovganiuk.Lab2;

/**
 * lab 2 package
 */
public class AirplaneApp {
    public static void main(String[] args) {
        // Приклад використання класу Airplane

        Airplane.Engine engine = new Airplane.Engine("Jet Engine");
        Airplane.Avionics avionics = new Airplane.Avionics("Advanced Avionics");
        Airplane.Body body = new Airplane.Body(250);

        Airplane airplane1 = new Airplane("Boeing 737", engine, avionics, body);
        airplane1.setEngine(engine);
        airplane1.turnOnLights();
        airplane1.takeOff();
        airplane1.retractLandingGear();
        airplane1.fly(10000);
        airplane1.addPassengers(100);
        airplane1.deployLandingGear();
        airplane1.land();
        airplane1.turnOffLights();

        airplane1.refuel(1000);
        airplane1.turnOnLights();
        airplane1.addPassengers(100);

        airplane1.takeOff();
        airplane1.retractLandingGear();
        airplane1.fly(3000);
        airplane1.deployLandingGear();
        airplane1.land();

        airplane1.removeEngine();
        airplane1.closeLogFile();
    }
}