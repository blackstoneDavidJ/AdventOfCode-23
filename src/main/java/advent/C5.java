package advent;

import javax.print.attribute.standard.PresentationDirection;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class C5 {
    private static final String PATH = "src/inputfiles/c5.txt";
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        String[] labels = {"seed-to-soil","soil-to-fertilizer", "fertilizer-to-water",
                "water-to-light", "light-to-temperature", "temperature-to-humidity", "humidity-to-location"};
        HashMap<String, List<String>> map = makeMapHelper(labels, scanner);
        long[] results = map.get("seeds").stream().mapToLong(Long::parseLong).toArray();
        for(String label : labels) {
            results = getNextMapResults(results, map, label);
        }
        for(long l : results) {
            System.out.println(l);
        }
    }
    private static long[] getNextMapResults(long[] input, HashMap<String, List<String>> map, String label) {
        //solve this againnmnnnnnnnnnnnnnnnn!
    }

    private static HashMap<String, List<String>> makeMapHelper(String[] labels, Scanner scanner) {
        HashMap<String, List<String>> maps = new HashMap<>();
        String line = scanner.nextLine();
        int index = 0;
        maps.put("seeds", Stream.of(line.split(":")[1].split(" "))
                .filter(n -> !n.isEmpty())
                .toList());
        while (scanner.hasNextLine()) {
            if (line.contains(labels[index])) {
                maps.put(labels[index], getList(scanner));
                index++;
            }
            if (scanner.hasNextLine()) line = scanner.nextLine();
        }
        scanner.close();
        return maps;
    }
    private static List<String> getList(Scanner scanner) {
        List<String> list = new ArrayList<>();
        String line = "placeholder";
        while (scanner.hasNextLine() && !line.isEmpty()) {
            line = scanner.nextLine();
            if (!line.isEmpty()) list.add(line);
        }
        return list;
    }
}
