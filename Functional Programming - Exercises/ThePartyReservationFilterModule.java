import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = "";
        Map<String, Predicate<String>> predicateMap = new HashMap<>();
        while (!"Print".equals(input = scanner.nextLine())) {
            String[] data = input.split(";");
            String predicateName = data[1] + data[2];
            switch (data[0]) {
                case "Add filter":
                    Predicate<String> predicate = predicate(data);
                    predicateMap.put(predicateName, predicate);
                    break;
                case "Remove filter":
                    predicateMap.remove(predicateName);
                    break;
            }
        }
        list.stream().filter(g -> {
            boolean isValid = true;
            for (Predicate<String> value : predicateMap.values()) {
                if (value.test(g)) {
                    isValid = false;
                    break;
                }
            }
            return isValid;
        }).forEach(a -> System.out.print(a + " "));
    }

    static Predicate<String> predicate(String[] data) {
        Predicate<String> predicate = null;
        switch (data[1]) {
            case "Starts with":
                predicate = p -> p.startsWith(data[2]);
                break;
            case "Ends with":
                predicate = p -> p.endsWith(data[2]);
                break;
            case "Length":
                predicate = p -> p.length() == Integer.parseInt(data[2]);
                break;
            case "Contains":
                predicate = p -> p.contains(data[2]);
                break;
        }
        return predicate;
    }
}