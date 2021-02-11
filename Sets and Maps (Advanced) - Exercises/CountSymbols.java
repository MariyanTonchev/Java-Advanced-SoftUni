import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<Character, Integer> symbols = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!symbols.containsKey(c)) {
                symbols.put(c, 1);
            } else {
                symbols.put(c, symbols.get(c) + 1);
            }
        }
        symbols.forEach((key, value) -> System.out.println(key + ": " + value + " time/s"));
    }
}