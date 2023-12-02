package advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class C1P2
{
    private static final String PATH = "src/inputfiles/c123.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        int total = 0;
        while(scanner.hasNextLine()) {
            String line = findNumbers(scanner.nextLine());

            line = line.replaceAll("[^\\d.]", "");
            int score = 0;
            if (line.length() == 1) {
                String nl = line + line;
                score = Integer.parseInt(nl);
            }
            else if (line.length() > 1) {
                String front = String.valueOf(line.charAt(0));
                String back = String.valueOf(line.charAt(line.length()-1));
                StringBuilder str = new StringBuilder();
                str.append(front); str.append(back);
                score = Integer.parseInt(str.toString());
            }
            total += score;
            System.out.println(line);
        }
        scanner.close();
        System.out.println(total);
    }

    private static String findNumbers(String line) {
        HashMap<Integer, String> map = new HashMap<>();
        ArrayList<Pair> pairs = new ArrayList<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.put(4,"four");
        map.put(5,"five");
        map.put(6,"six");
        map.put(7,"seven");
        map.put(8,"eight");
        map.put(9,"nine");
        for (int i = 1; i <= 9; i++) {
            String currStr = map.get(i);
            if (line.contains(currStr))
                pairs.add(new Pair(i,line.indexOf(currStr)));
        }
        StringBuilder str = new StringBuilder(line);
        for (Pair pair : pairs) {
            str.setCharAt(pair.index, Character.forDigit(pair.num, 10));
        }
        System.out.println(str);
        System.out.println("---");
        return line;
    }
    private static class Pair {
        public int num;
        public int index;

        public Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }

        public String toString() {
            return num +" " +index;
        }
    }
}
