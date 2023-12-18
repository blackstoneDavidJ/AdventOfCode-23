package advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class C4P2
{
    private static final String PATH = "src/inputfiles/c423.txt";
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        int cardTotal = 220;
        int[] cardCount = new int [cardTotal];
        Arrays.fill(cardCount, 1);
        int cardId = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] cards = line.split("\\|");
            String[] winningCards = Arrays.stream(cards[0].split(":")[1].split(" "))
                    .filter(s -> !s.isEmpty())
                    .toArray(String[]::new);
            ArrayList<String> bagCards = new ArrayList<>(List.of(cards[1].split(" ")));

            int matchCount = (int) Arrays.stream(winningCards).filter(bagCards::contains).count();
            for (int i = 0; i < matchCount; i++)
                cardCount[cardId + 1 + i] += cardCount[cardId];
            cardId++;
        }

        System.out.println(Arrays.stream(cardCount).sum());

        scanner.close();
    }
}