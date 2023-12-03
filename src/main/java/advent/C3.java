package advent;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class C3
{
    private static final String PATH = "src/inputfiles/c323.txt";
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        ArrayList<String> lines = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        System.out.println(getSum(lines));

        scanner.close();
    }

    private static int getSum(ArrayList<String> lines) {
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
                    if (hasAdjacent(chars, i, j, numStr.length()-1)) {
                        System.out.println(num);
                        total += num;
                    }
                    j = y-1;
                }
            }
        }
        return total;
    }

    private static boolean hasAdjacent(char[][] chars, int i, int j, int j2) {
        int rows = chars.length;
        int cols = chars[0].length;
        char[] symbols = {'#', '#','$', '@', '%', '&', '/', '!','+','-','*'};
        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},   // Up, Down, Left, Right
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  // Diagonals
        };

        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                for (char symbol : symbols) {
                    if (chars[newRow][newCol] == symbol) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
