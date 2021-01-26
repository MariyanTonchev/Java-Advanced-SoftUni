import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] numbers = scanner.nextLine().split("\\s+");
        for (String number : numbers) {
            stack.push(Integer.parseInt(number));
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
    }
}