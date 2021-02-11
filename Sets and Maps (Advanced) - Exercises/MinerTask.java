import java.util.LinkedHashMap;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
        while (scanner.hasNext()) {
            String resource = scanner.nextLine();
            if (resource.equalsIgnoreCase("stop")) {
                break;
            }
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!resources.containsKey(resource)) {
                resources.put(resource, quantity);
            } else {
                resources.put(resource, resources.get(resource) + quantity);
            }
        }
        resources.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}