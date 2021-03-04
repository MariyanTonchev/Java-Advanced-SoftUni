package GenericSwapMethodString;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String> list = new Box<>();
        for (int i = 0; i < n; i++) {
            list.addToList(scanner.nextLine());
        }
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int a = arr[0];
        int b = arr[1];
        list.swap(a, b);
        System.out.println(list);
    }
}
