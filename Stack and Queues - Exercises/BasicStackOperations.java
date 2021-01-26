import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] nsx = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < nsx[0]; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < nsx[1]; i++) {
            stack.pop();
        }
        if (stack.contains(nsx[2])) {
            System.out.println(true);
        } else if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < stack.size(); i++) {
                if (numbers[i] < min) {
                    min = numbers[i];
                }
            }
            System.out.println(min);
        }
    }
}