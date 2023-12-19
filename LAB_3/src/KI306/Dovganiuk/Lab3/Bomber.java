package KI306.Dovganiuk.Lab3;

/**
 * Interface Bombardier, which describes methods for dropping bombs.
 */
interface Bombardier {
    /**
     * Method for dropping a specified number of bombs.
     * @param count the number of bombs to drop.
     */
    void dropBombs(int count);
}

/**
 * Class Bomber, which inherits from the Airplane class and implements the Bombardier interface.
 */
public class Bomber extends Airplane implements Bombardier {

    private int bombCount; // The number of bombs in the plane.

    /**
     * Constructor for the Bomber class with parameters.
     * @param model the model of the plane.
     * @param engine the engine of the plane.
     * @param avionics the avionics of the plane.
     * @param body the body of the plane.
     * @param bombCount the number of bombs in the plane.
     */
    public Bomber(String model, Engine engine, Avionics avionics, Body body, int bombCount) {
        super(model, engine, avionics, body);
        this.bombCount = bombCount;
    }

    /**
     * Constructor for the Bomber class with the model of the plane.
     * @param model the model of the plane.
     */
    public Bomber(String model) {
        super(model);
        this.bombCount = 0;
    }

    /**
     * Method for dropping a specified number of bombs.
     * @param count the number of bombs to drop.
     */
    public void dropBombs(int count) {
        if (isFlying && bombCount >= count) {
            bombCount -= count;
            logAction("Відпустив " + count + " бомб");
        } else if (isFlying && bombCount < count){
            logAction("В літаку всього " + bombCount + " бомб");
        } else {
            logAction("Літак не в повітрі. Неможливо скинути бомби.");
        }
    }

    /**
     * Method for loading a specified number of bombs.
     * @param count the number of bombs to load.
     */
    public void loadBombs(int count) {
        if (!isFlying) {
            bombCount += count;
            logAction("Завантажено " + count + " бомб");
        } else {
            logAction("Літак в повітрі. Неможливо завантажити бомби.");
        }
    }
}