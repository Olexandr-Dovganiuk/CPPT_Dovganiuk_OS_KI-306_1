package KI306.Dovganiuk.Lab4;

import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;

/**
 * Main class of the program.
 */
public class Main {

    /**
     * The main method of the program.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            out.print("Enter file name: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName));

            try {
                Equations eq = new Equations();
                out.print("Enter X: ");
                fout.print(eq.calculate(in.nextInt()));
            } catch (ArithmeticException ex) {
                // This block catches exceptions during calculations
                out.print(ex.getMessage());
            } finally {
                // This block will be executed regardless of the circumstances
                fout.flush();
                fout.close();
            }

        } catch (FileNotFoundException ex) {
            // This block catches file handling exceptions even if they
            // occurred in the finally block
            out.print("Exception reason: Perhaps wrong file path");
        }
    }
}