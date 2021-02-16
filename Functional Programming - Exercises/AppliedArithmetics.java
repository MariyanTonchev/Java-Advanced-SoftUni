import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], int[]> addOne = arr -> Arrays.stream(arr).map(num -> num += 1).toArray();
        Function<int[], int[]> subtractOne = arr -> Arrays.stream(arr).map(num -> num -= 1).toArray();
        Function<int[], int[]> multiplyTwo = arr -> Arrays.stream(arr).map(num -> num *= 2).toArray();
        Consumer<int[]> print = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        String cmd = "";
        while (!"end".equals(cmd = scanner.nextLine())) {
            switch (cmd) {
                case "add":
                    numbers = addOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyTwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractOne.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
        }
    }
}