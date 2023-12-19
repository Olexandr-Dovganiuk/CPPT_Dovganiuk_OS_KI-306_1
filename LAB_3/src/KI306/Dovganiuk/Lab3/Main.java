package KI306.Dovganiuk.Lab3;

public class Main {
    public static void main(String[] args)
    {
        Bomber bomber = new Bomber("B-2 Spirit", new Airplane.Engine("Twin-turbofan"), new Airplane.Avionics("GlobalSight"), new Airplane.Body(2), 10);

        bomber.takeOff();
        bomber.fly(1000);
        bomber.dropBombs(5);
        bomber.dropBombs(10);

        bomber.land();
        bomber.closeLogFile();
    }
}