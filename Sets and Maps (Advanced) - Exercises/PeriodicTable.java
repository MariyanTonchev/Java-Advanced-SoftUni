import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> table = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            table.addAll(Arrays.asList(elements));
        }
        table.forEach(a -> System.out.print(a + " "));
    }
}