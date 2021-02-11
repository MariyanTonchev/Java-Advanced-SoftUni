import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        LinkedHashSet<Integer> nSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> mSet = new LinkedHashSet<>();
        for (int j = 0; j < input[0]; j++) {
            int number = Integer.parseInt(scanner.nextLine());
            nSet.add(number);
        }
        for (int i = 0; i < input[1]; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            mSet.add(number);
        }
        nSet.forEach(a -> {
            mSet.forEach(b -> {
                if (a.equals(b)){
                    System.out.print(a + " ");
                }
            });
        });
    }
}