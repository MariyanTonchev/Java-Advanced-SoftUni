package Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] stones = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        Lake lake = new Lake(stones);
        List<String> list = new ArrayList<>();
        for (Integer integer : lake) {
            list.add(String.valueOf(integer));
        }
        System.out.println(String.join(", ", list));
    }
}
