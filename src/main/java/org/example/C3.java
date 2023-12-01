package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class C3
{
    private static final String PATH = "src/inputfiles/c3.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        HashMap<String,Integer> letters = getLetterValues();
        int priorities = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String c1 = line.substring(0,(line.length()/2));
            String c2 = line.substring(line.length()/2);
            for (int i = 0; i < c1.length(); i++) {
                String currChar = String.valueOf(c1.charAt(i));
                if (c2.contains(currChar)) {
                    priorities += letters.get(currChar);
                    break;
                }
            }
        }
        System.out.println(priorities);
        scanner.close();
    }

    private static HashMap<String, Integer> getLetterValues()
    {
        HashMap<String, Integer> map = new HashMap<>();
        int value = 27;
        for (int i = 65; i <= 90; i++) {
            map.put(String.valueOf((char) i),value);
            value++;
        }
        int value2 = 1;
        for (int i = 97; i <= 122; i++) {
            map.put(String.valueOf((char) i),value2);
            value2++;
        }
        return map;
    }
}
