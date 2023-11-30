package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class C1
{
    private static final String PATH = "src/inputfiles/c1.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        int totalCalories = 0, biggestCalories = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                totalCalories += Integer.parseInt(line);
            }
            else {
                if (totalCalories > biggestCalories)
                    biggestCalories = totalCalories;
                totalCalories = 0;
            }
        }
        System.out.println("largest: " +biggestCalories);
        scanner.close();
    }
}
