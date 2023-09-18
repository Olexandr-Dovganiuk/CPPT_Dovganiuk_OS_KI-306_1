import java.io.*;
import java.util.*;

/**
 * The Lab1DovganiukKI306 class implements a program for generating and inferring a jagged array of characters.
 *
 * @author Donganiuk Olexandr
 * @version 1.0
 * @since version 1.0
 */
public class Lab1DovganiukKI306 {
    /**
     * The static main method is the entry point into the program
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        int nRows;
        char[][] arr;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);
        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        in.nextLine();
        arr = new char[nRows][];

        /*
        for (int i = 0; i < nRows; i++) {
            if (i < nRows/2) {
                arr[i]= new char[2 * (i + 1)];
            }
            else if (2 * (i + 1) > nRows + 2) {
                arr[i] = new char[2 * (nRows - i)];
            }
            else {
                arr[i] = new char[nRows];
            }

        }
*/
        for (int i = 0; i < nRows; i++) {
            arr[i] =  i < nRows / 2 ?
                    new char[2 * (i + 1)] :
                    2 * (i + 1) > nRows + 2 ?
                            new char[2 * (nRows - i)] :
                            new char[nRows];
        }

        System.out.print("Введіть символ-заповнювач: ");
        String filler = in.nextLine();

        if (filler.isEmpty()) {
            System.out.print("\nНе введено символ заповнювач");
            return;
        }
        else if (filler.length() != 1) {
            System.out.print("\nЗабагато символів заповнювачів");
            return;
        }

        System.out.println("\nЗубчатий масив:");

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = filler.charAt(0);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nЗадана матриця:");


        for (int i = 0; i < nRows; i++) {
            int k = 0;
            for (int j = 0; j < nRows; j++) {
                if (i == j || j == nRows - 1 - i || (i + j < nRows && i - j > 0) || (i + j + 1 > nRows && i - j < 0)) {
                    System.out.print(arr[i][k] + " ");
                    fout.print(arr[i][k] + " ");
                    k++;
                }
                else {
                    System.out.print("  ");
                    fout.print("  ");
                }
            }
            System.out.println();
            fout.println();
        }

        fout.flush();
        fout.close();
    }
}
