package advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class C3P2
{
    private static final String PATH = "src/inputfiles/c323.txt";
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        ArrayList<String> lines = new ArrayList<>();
        HashMap<String,ArrayList<Integer>> star = new HashMap<>();
        int lc = 0;
        int starIndex = -1;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
            while ((starIndex = line.indexOf('*', starIndex + 1)) != -1) {
                star.put(lc +"-" +starIndex, new ArrayList<>());
            }
            lc++;
        }

        System.out.println(getSum(star, lines));

        scanner.close();
    }

    private static int getSum(HashMap<String,ArrayList<Integer>> star, ArrayList<String> lines) {
        int dimX = lines.size();
        int dimY = lines.get(0).length();
        char[][] chars = new char[dimX][dimY];
        for(int i = 0; i < dimX; i++) {
            chars[i] = lines.get(i).toCharArray();
        }
        int total = 0;
        for(int i = 0; i < dimX; i++) {
            for(int j = 0; j < dimY; j++) {
                char tmp = chars[i][j];
                if (Character.isDigit(tmp)) {
                    StringBuilder numStr = new StringBuilder().append(tmp);
                    int y;
                    boolean notDigit = false;
                    for (y = j+1; y < dimY && !notDigit; y++) {
                        char c1 = chars[i][y];
                        if (Character.isDigit(c1)) {
                            numStr.append(c1);
                        }
                        else notDigit = true;
                    }
                    int num = Integer.parseInt(numStr.toString());
                    for (int t = (y-numStr.length()-1); t < (y-1); t++) {
                        String symbolPos = getAdjacent(chars, i, t);
                        if (star.containsKey(symbolPos)) {
                            ArrayList<Integer> tmpAL = star.get(symbolPos);
                            tmpAL.add(num);
                            star.put(symbolPos,tmpAL);
                            break;
                        }
                    }
                    j = y-1;
                }
            }
        }

        return caculateLegalSymbol(star);
    }

    private static int caculateLegalSymbol(HashMap<String, ArrayList<Integer>> star) {
        int total = 0;
        for(String key : star.keySet()) {
            if (star.get(key).size() == 2) {
                total += (star.get(key).get(0) * star.get(key).get(1));
            }
        }
        return total;
    }

    private static String getAdjacent(char[][] chars, int i, int j) {
        int rows = chars.length;
        int cols = chars[0].length;
        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},   // Up, Down, Left, Right
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  // Diagonals
        };

        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                if (chars[newRow][newCol] == '*') {
                    return newRow +"-" +newCol;
                }
            }
        }

        return "";
    }

}
