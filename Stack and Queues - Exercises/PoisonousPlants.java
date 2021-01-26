import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] plantsArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> plants = new ArrayDeque<>();
        plants.push(0);
        int[] days = new int[n];
        for (int i = 1; i < n; i++) {
            int maxDays = 0;
            while (plants.size() > 0 && plantsArray[plants.peek()] >= plantsArray[i]) {
                maxDays = Math.max(maxDays, days[plants.pop()]);
            }
            if (plants.size() > 0) {
                days[i] = maxDays + 1;
            }
            plants.push(i);
        }
        List<Integer> listDays = new ArrayList<>();
        for (int day : days) {
            listDays.add(day);
        }
        System.out.println(Collections.max(listDays));
    }
}
