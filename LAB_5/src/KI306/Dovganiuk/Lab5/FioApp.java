package KI306.Dovganiuk.Lab5;

import java.io.*;
import java.util.*;

/**
 * Main class for the application.
 */
public class FioApp {
    /**
     * Main method of the application.
     * @param args command line arguments
     * @throws FileNotFoundException if the file is not found
     * @throws IOException if an I/O error occurs
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        CalcWFio obj = new CalcWFio();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter data: ");
        double data = s.nextDouble();
        obj.calculate(data);
        System.out.println("Result is: " + obj.getResult());
        obj.writeResTxt("textRes.txt");
        obj.writeResBin("BinRes.bin");
        obj.readResBin("BinRes.bin");
        System.out.println("Result is: " + obj.getResult());
        obj.readResTxt("textRes.txt");
        System.out.println("Result is: " + obj.getResult());
    }
}

/**
 * Class for calculations with file input/output.
 */
class CalcWFio {
    /**
     * Writes the result to a text file.
     * @param fName the name of the file
     * @throws FileNotFoundException if the file is not found
     */
    public void writeResTxt(String fName) throws FileNotFoundException {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%E ", result);
        f.close();
    }

    /**
     * Reads the result from a text file.
     * @param fName the name of the file
     */
    public void readResTxt(String fName) {
        try {
            File f = new File(fName);
            if (f.exists()) {
                Scanner s = new Scanner(f);
                result = s.nextDouble();
                s.close();
            } else {
                throw new FileNotFoundException("File " + fName + " not found");
            }
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        }
    }

    /**
     * Writes the result to a binary file.
     * @param fName the name of the file
     * @throws FileNotFoundException if the file is not found
     * @throws IOException if an I/O error occurs
     */
    public void writeResBin(String fName) throws FileNotFoundException, IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }

    /**
     * Reads the result from a binary file.
     * @param fName the name of the file
     * @throws FileNotFoundException if the file is not found
     * @throws IOException if an I/O error occurs
     */
    public void readResBin(String fName) throws FileNotFoundException, IOException {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }

    /**
     * Calculates the result.
     * @param x the input value
     */
    public void calculate(double x) {
        Equations eq = new Equations();
        result = eq.calculate(x);
    }

    /**
     * Returns the result.
     * @return the result
     */
    public double getResult() {
        return result;
    }

    private double result;
}