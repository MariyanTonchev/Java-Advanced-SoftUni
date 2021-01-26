import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] nsx = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < nsx[0]; i++) {
            queue.add(numbers[i]);
        }
        for (int i = 0; i < nsx[1]; i++) {
            queue.poll();
        }
        if (queue.contains(nsx[2])) {
            System.out.println(true);
        } else if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < queue.size(); i++) {
                if (queue.peek() < min) {
                    min = queue.poll();
                }
            }
            System.out.println(min);
        }
    }
}