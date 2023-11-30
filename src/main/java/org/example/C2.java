package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class C2 {
    private static final String PATH = "src/inputfiles/c2.txt";

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String,Integer> values = new HashMap<>();
        values.put("AX",4);
        values.put("AY",8);
        values.put("AZ",3);

        values.put("BX",1);
        values.put("BY",5);
        values.put("BZ",9);

        values.put("CX",7);
        values.put("CY",2);
        values.put("CZ",6);

        int score = 0;
        Scanner scanner = new Scanner(new File(PATH));
        while (scanner.hasNextLine()) {
            score += values.get(scanner.nextLine().replace(" ",""));
        }
        System.out.println(score);
        scanner.close();
    }
}