import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxInt = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        int max = Integer.MIN_VALUE;
        maxInt.push(max);
        for (int i = 0; i < n; i++) {
            int cmd = scanner.nextInt();
            switch (cmd) {
                case 1:
                    stack.push(scanner.nextInt());
                    if (stack.peek() > maxInt.peek()) {
                        maxInt.push(stack.peek());
                    }
                    break;
                case 2:
                    if (stack.peek().equals(maxInt.peek())) {
                        maxInt.remove();
                    }
                    if (stack.size() > 0) {
                        stack.remove();
                    }
                    break;
                case 3:
                    System.out.println(maxInt.peek());
                    break;
            }
        }
    }
}