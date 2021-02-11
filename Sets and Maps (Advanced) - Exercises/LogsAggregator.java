import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, TreeSet<String>> logs = new TreeMap<>();
        TreeMap<String, Integer> usersTotalDurations = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split(" ");
            String ip = data[0];
            String user = data[1];
            int duration = Integer.parseInt(data[2]);
            if (!logs.containsKey(user)) {
                logs.put(user, new TreeSet<>());
            }
            logs.get(user).add(ip);
            if (!usersTotalDurations.containsKey(user)) {
                usersTotalDurations.put(user, duration);
            } else {
                usersTotalDurations.put(user, usersTotalDurations.get(user) + duration);
            }
        }
        usersTotalDurations.forEach((key, value) -> System.out.println(key + ": " + value + " " + logs.get(key)));

    }
}