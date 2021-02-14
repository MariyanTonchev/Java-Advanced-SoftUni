import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] bounds = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(a -> Integer.parseInt(a)).toArray();
        String cmd = scanner.nextLine();
        Predicate<Integer> test = createTester(cmd);
        print(bounds, test);
    }

    static Predicate<Integer> createTester(String cmd) {
        Predicate<Integer> tester = null;
        switch (cmd) {
            case "even":
                tester = t -> t % 2 == 0;
                break;
            case "odd":
                tester = t -> t % 2 == 1 || t % 2 == -1;
                break;
        }
        return tester;
    }

    static void print(int[] bounds, Predicate<Integer> predicate) {
        int lowerBound = bounds[0];
        int upperBound = bounds[1];
        for (int i = lowerBound; i <= upperBound; i++) {
            if (predicate.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}