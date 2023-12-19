package KI306.Dovganiuk.Lab4;

/**
 * Class <code>Equations</code> implements method for (y=tg(x)/sin(2x)) expression calculation
 */
class Equations {

    /**
     * Method calculates the (y=tg(x)/sin(2x)) expression
     *
     * @param x Angle in degrees
     * @return the result of the calculation
     * @throws ArithmeticException if the result is not a number or if the denominator is zero
     */
    public double calculate(int x) throws ArithmeticException {
        double y;
        try {
            y = Math.tan(x) / Math.sin(2 * x);
            // If the result is not a number, generate an exception
            if (Double.isNaN(y) || y == Double.NEGATIVE_INFINITY || y == Double.POSITIVE_INFINITY || Math.sin(2 * x) == 0) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ex) {
            // Create a higher level exception with an explanation of the reason for the exception
            // The cause of the exception during the calculation
            if (Math.sin(2 * x) == 0) {
                throw new ArithmeticException("Exception reason: Division by zero (cos(x) = 0 or sin(x) = 0)");
            } else {
                throw new ArithmeticException("Unknown reason of the exception during exception calculation");
            }
        }
        return y;
    }
}