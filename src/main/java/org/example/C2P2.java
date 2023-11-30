package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class C2P2 {
    private static final String PATH = "src/inputfiles/c2.txt";

    public static void main(String[] args) throws FileNotFoundException {
        //X = LOSE, Y = DRAW, Z = WIN
        //x = rock y = paper z = scissors
        HashMap<String,Integer> values = new HashMap<>();
        values.put("AX",1); // pick x
        values.put("AY",6); // pick z
        values.put("AZ",8); // pick y

        values.put("BX",1); // pick X
        values.put("BY",5); // pick y
        values.put("BZ",9); // pick z

        values.put("CX",2); // pick y
        values.put("CY",6); // pick z
        values.put("CZ",7); // pick x

        int score = 0;
        Scanner scanner = new Scanner(new File(PATH));
        while (scanner.hasNextLine()) {
            score += values.get(scanner.nextLine().replace(" ",""));
        }
        System.out.println(score);
        scanner.close();
    }
}