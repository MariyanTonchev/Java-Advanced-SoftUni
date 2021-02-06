import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        LinkedHashMap<Double, Integer> newValues = new LinkedHashMap<>();
        for (double number : numbers) {
            if (!newValues.containsKey(number)) {
                newValues.put(number, 1);
            } else {
                newValues.put(number, newValues.get(number) + 1);
            }
        }
        for (Double key : newValues.keySet()) {
            System.out.printf("%.1f -> %d%n", key, newValues.get(key));
        }
    }
}