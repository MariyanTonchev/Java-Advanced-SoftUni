import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> browseHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();
        while (!input.equals("Home")) {
            switch (input) {
                case "back":
                    if (browseHistory.size() < 2) {
                        System.out.println("no previous URLs");
                    } else {
                        forwardHistory.addFirst(browseHistory.peek());
                        browseHistory.pop();
                        System.out.println(browseHistory.peek());
                    }
                    break;
                case "forward":
                    if (forwardHistory.size() < 1) {
                        System.out.println("no next URLs");
                    } else {
                        System.out.println(forwardHistory.peek());
                        browseHistory.push(forwardHistory.pop());
                    }
                    break;
                default:
                    System.out.println(input);
                    browseHistory.addFirst(input);
                    forwardHistory.clear();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}