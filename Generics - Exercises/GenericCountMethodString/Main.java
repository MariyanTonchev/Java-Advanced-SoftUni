package GenericCountMethodString;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String> list = new Box<>();
        for (int i = 0; i < n; i++) {
            String value = scanner.nextLine();
            list.addToList(value);
        }
        String c = scanner.nextLine();

        System.out.println(list.count(c));
    }
}
