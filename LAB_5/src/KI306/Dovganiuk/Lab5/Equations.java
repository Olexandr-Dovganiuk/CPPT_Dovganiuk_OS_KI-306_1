package KI306.Dovganiuk.Lab5;

import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;

/**
 * Class <code>Equations</code> implements method for ((2 / tg(x)) / x) expression calculation
 */
class Equations {

    /**
     * Method calculates the (y=tg(x)/sin(2x)) expression
     * @param x Angle in degrees
     * @throws ArithmeticException
     */
    public double calculate(double x) throws ArithmeticException {
        double y;
        try {
            y = Math.tan(x) / Math.sin(2 * x);
            // If the result is not a number, generate an exception
            if (y == Double.NaN || y == Double.NEGATIVE_INFINITY || y == Double.POSITIVE_INFINITY || Math.sin(2 * x) == 0)
                throw new ArithmeticException();
        } catch (ArithmeticException ex) {
            // Create a higher-level exception with an explanation of the cause of the error
            if (Math.sin(2 * x) == 0)
                throw new ArithmeticException("Exception reason: Devin by sin(2x) = 0 (cos(x) = 0 or sin(x) = 0)");
            else
                throw new ArithmeticException("Unknown reason of the exception during exception calculation");
        }
        return y;
    }
}