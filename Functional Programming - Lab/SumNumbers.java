import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(",\\s+");
        if (arr.length < 2) {
            System.out.println("Count = " + arr.length);
            System.out.println("Sum = " + arr[0]);
        } else {
            Function<String, Integer> parser = x -> Integer.parseInt(x);
            int sum = 0;
            for (String s : arr) sum += parser.apply(s);
            System.out.println("Count = " + arr.length);
            System.out.println("Sum = " + sum);
        }
    }
}