/*
 * Used to generate n sets of random numbers
 * as input for PancakeStack.
 * Writes to `input` file.
 * author: iuhiah
 */

import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;

public class RNG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // change this if not running from `PancakeStack.java`
            FileWriter writer = new FileWriter(args[0]);
            
            System.out.println("Number of pancakes to generate: ");
            int n = sc.nextInt();
            Random rand = new Random();

            writer.write(n + "\n");
            for (int i=0; i<n; i++) {
                writer.write(
                    // to avoid 0 size
                    rand.nextInt((int) Math.pow(n, 2) + 1) + " " +
                    rand.nextInt(2) + "\n"
                );
            }
            writer.close();

            System.out.println("Generated " + n + " sets of random numbers.");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
