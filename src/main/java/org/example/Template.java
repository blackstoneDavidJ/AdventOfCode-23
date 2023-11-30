package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Template
{
    private static final String PATH = "src/inputfiles/c2.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

        }
        scanner.close();
    }
}
