import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(i -> Integer.parseInt(i)).toArray();
        Function<int[], Integer> getMinElement = n -> Arrays.stream(arr).min().getAsInt();
        int minElement = getMinElement.apply(arr);
        System.out.println(minElement);
    }
}