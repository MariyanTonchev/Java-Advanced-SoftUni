import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        String text = "";
        for (int i = 0; i < num; i++) {
            String[] data = scanner.nextLine().split(" ");
            switch (data[0]) {
                case "1":
                    stack.push(text);
                    text += data[1];
                    break;
                case "2":
                    stack.push(text);
                    int count = Integer.parseInt(data[1]);
                    text = text.substring(0, text.length() - count);
                    break;
                case "3":
                    int index = Integer.parseInt(data[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    text = stack.pop();
                    break;
            }
        }
    }
}