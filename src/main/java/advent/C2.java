package advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class C2
{
    private static final String PATH = "src/inputfiles/c223.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        int sum = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] game = line.split(":");
            int id = Integer.parseInt(game[0].split(" ")[1]);
            String[] subsets = game[1].split(";");
            int red = 12, green = 13, blue = 14;
            boolean possible = true;
            for(String subset : subsets) {
                String[] items = subset.split(", ");
                for (String i : items) {
                    String[] ind = i.trim().split(" ");
                    if (ind[1].contains("red") && Integer.parseInt(ind[0]) > red)
                        possible = false;
                    else if (ind[1].contains("green") && Integer.parseInt(ind[0]) > green)
                        possible = false;
                    else if (ind[1].contains("blue") && Integer.parseInt(ind[0]) > blue)
                        possible = false;
                }
            }

            if (possible) sum += id;
        }
        System.out.println(sum);
        scanner.close();
    }
}
