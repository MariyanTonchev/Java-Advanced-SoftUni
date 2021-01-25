import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '('){
                stack.push(i);
            } else if(c == ')'){
                String content = input.substring(stack.pop(), i + 1);
                System.out.println(content);
            }
        }
    }
}