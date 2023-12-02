package advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class C1
{
    private static final String PATH = "src/inputfiles/c123.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        int total = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
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
            //System.out.println(line);
        }
        scanner.close();
        System.out.println(total);
    }
}
