import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(HashSet::new));
        Predicate<Integer> isDiv = num -> {
            for (Integer integer : list) {
                if (num % integer != 0) {
                    return false;
                }
            }
            return true;
        };
        for (int i = 1; i <= n; i++) {
            if (isDiv.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}