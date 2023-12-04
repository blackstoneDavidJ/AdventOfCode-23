package advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class C4
{
    private static final String PATH = "src/inputfiles/c423.txt";
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        int sum = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] cards = line.split("\\|");
            String[] winningCards2 = Arrays.stream(cards[0].split(":")[1].split(" "))
                    .filter(s -> !s.isEmpty())
                    .toArray(String[]::new);
            ArrayList<String> bagCards = new ArrayList<>(List.of(cards[1].split(" ")));
            int total = 0;
            for(String card : winningCards2) {
                if (bagCards.contains(card)) {
                    if (total == 0) total = 1;
                    else total *= 2;
                }
            }
            sum += total;
        }
        System.out.println(sum);

        scanner.close();
    }
}