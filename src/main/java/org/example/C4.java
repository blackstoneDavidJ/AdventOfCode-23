package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class C4
{
    private static final String PATH = "src/inputfiles/c4.txt";
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        int pairCnt = 0;
        while(scanner.hasNextLine()) {

            String[] pairs = scanner.nextLine().split(",");
            System.out.println(pairs[0] +" " + pairs[1]);
            pairCnt += isPair(pairs);
        }
        scanner.close();
        System.out.println(pairCnt);
    }
    private static int isPair(String[] p) {
        String[] p1 = p[0].split("-");
        String[] p2 = p[1].split("-");

        int start1 = Integer.parseInt(p1[0]);
        int end1   = Integer.parseInt(p1[1]);
        int start2 = Integer.parseInt(p2[0]);
        int end2   = Integer.parseInt(p2[1]);

        String pair1 = getPairString(start1, end1).toString();
        String pair2 = getPairString(start2, end2).toString();

        System.out.println(pair1);
        System.out.println(pair2);
        int contains = 0;
        return contains;
    }

    private static StringBuilder getPairString(int start, int end) {
        StringBuilder pair = new StringBuilder();
        int cnt = 1;
        for(int i = start; i <= end; i++) {
            pair.append(i);
        }
        return pair;
    }

}
