package advent;

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
        long[] rts = map.get("seeds").stream().mapToLong(Long::parseLong).toArray();
        Pair[] results = Arrays.stream(rts).mapToObj(Pair::new).toArray(Pair[]::new);
        Arrays.stream(labels).forEach(l -> {
            getNextMapResults(results, map, l);
            Arrays.stream(results).forEach(p -> p.solved = false);
        });
        Arrays.stream(results).min(Comparator.comparingLong(p -> p.n)).ifPresent(System.out::println);
    }
    private static void getNextMapResults(Pair[] input, HashMap<String, List<String>> map, String label) {
        List<String> list = map.get(label);
        for(String param : list) {
            long[] p = Arrays.stream(param.split(" ")).mapToLong(Long::parseLong).toArray();
            for (Pair pair : input) {
                long seed = pair.n;
                long offset = seed - p[1];
                if (seed >= p[1] && offset <= p[2] && !pair.solved) {
                    pair.n = p[0] + offset;
                    pair.solved = true;
                }
            }
        }
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
    private static class Pair { boolean solved; long n; Pair(long n) { this.n = n; }
        @Override
        public String toString() { return "value: " +n; }
    }
}