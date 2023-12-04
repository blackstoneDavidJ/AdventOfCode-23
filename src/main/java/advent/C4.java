package advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class C4
{
    private static final String PATH = "src/inputfiles/c423.txt";
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] cards = line.split("\\|");
            HashMap<String, Integer> winningCards = buildMap(cards);
            ArrayList<String> bagCards = new ArrayList<>(List.of(cards[1].split(" ")));
            for(String card : winningCards.keySet()) {
                System.out.println(card);
                if (bagCards.contains(card)) {
                    if (winningCards.get(card) == 0)
                        winningCards.put(card, winningCards.get(card) + 1);
                    else
                        winningCards.put(card, winningCards.get(card) * 2);
                }
            }
            int total = 0;
            for(String card : winningCards.keySet())
            {
                total += winningCards.get(card);
            }
            System.out.println(total);
        }
        scanner.close();
    }

    private static HashMap<String, Integer> buildMap(String[] cards) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String card : cards) map.put(card, 0);
        return map;
    }
}