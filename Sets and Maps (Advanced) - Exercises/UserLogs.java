import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();
        while (!input.equalsIgnoreCase("end")) {
            String[] data = input.split("\\s+");
            String[] usernameData = data[2].split("=");
            String[] ipData = data[0].split("=");
            String ip = ipData[1];
            String username = usernameData[1];
            if (!users.containsKey(username)) {
                users.put(username, new LinkedHashMap<>());
            }
            if (users.get(username).containsKey(ip)) {
                users.get(username).put(ip, users.get(username).get(ip) + 1);
            } else {
                users.get(username).put(ip, 1);
            }
            input = scanner.nextLine();
        }
        for (String user : users.keySet()) {
            System.out.println(user + ": ");
            StringBuilder print = new StringBuilder();
            LinkedHashMap<String, Integer> ipsAndCount = users.get(user);
            for (Map.Entry<String, Integer> entry : ipsAndCount.entrySet()) {
                print.append(entry.getKey()).append(" => ").append(entry.getValue()).append(", ");
            }
            print.replace(print.length() - 2, print.length() - 1, ". ");
            System.out.println(print);
        }
    }
}