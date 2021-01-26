import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        if (input.length() % 2 != 0) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < input.length(); i++) {
                char temp = input.charAt(i);
                if (temp == '(' || temp == '[' || temp == '{') {
                    stack.push(temp);
                } else {
                    switch (temp) {
                        case ')':
                            if (stack.peek().equals('('))
                                stack.pop();
                            break;
                        case ']':
                            if (stack.peek().equals('['))
                                stack.pop();
                            break;
                        case '}':
                            if (stack.peek().equals('{'))
                                stack.pop();
                            break;
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}