package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class C3P2
{
    private static final String PATH = "src/inputfiles/c3.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        ArrayList<String> lineList = new ArrayList<>();
        int priorities = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineList.add(line);
            if (lineList.size() % 3 == 0) {
                priorities += getPriority(lineList);
                lineList.clear();
            }
        }
        System.out.println(priorities);
        scanner.close();
    }

    private static int getPriority(ArrayList<String> lineList) {
        HashMap<String,Integer> letters = getLetterValues();
        String l1 = lineList.get(0);
        String currChar = null;
        for (int i = 0; i < l1.length(); i++) {
            currChar = String.valueOf(l1.charAt(i));
            int c = 0;
            for (String l : lineList)
                if (l.contains(currChar)) c++;
            if (c == 3) break;
        }
        return letters.get(currChar);
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
