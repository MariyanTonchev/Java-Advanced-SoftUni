import java.util.*;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            list.add(j);
        }
        list.removeIf(i -> i % 2 == 1);
        print(list);
        list.sort((q, w) -> q.compareTo(w));
        print(list);
    }

    private static void print(List<Integer> list) {
        System.out.println(list.toString().replaceAll("[\\[\\]]", ""));
    }
}