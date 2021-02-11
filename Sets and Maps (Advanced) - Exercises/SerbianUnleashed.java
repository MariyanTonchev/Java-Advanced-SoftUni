import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<name>([a-zA-Z]+\\s?){1,3}) @(?<venue>([A-Za-z]+\\s?){1,3}) (?<price>\\d+) (?<space>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> map = new LinkedHashMap<>();
        while (!input.equalsIgnoreCase("end")) {
            Matcher matcher = pattern.matcher(input);
            String name = "";
            String venue = "";
            int space = 0;
            int price = 0;
            if (matcher.find()) {
                name = matcher.group("name");
                venue = matcher.group("venue");
                price = Integer.parseInt(matcher.group("price"));
                space = Integer.parseInt(matcher.group("space"));
                int totalMoney = space * price;
                if (!map.containsKey(venue)) {
                    map.put(venue, new LinkedHashMap<>());
                }
                if (!map.get(venue).containsKey(name)) {
                    map.get(venue).put(name, totalMoney);
                } else {
                    map.get(venue).put(name, map.get(venue).get(name) + totalMoney);
                }
            }
            input = scanner.nextLine();
        }
        map.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream().sorted((c, b) -> b.getValue().compareTo(c.getValue())).forEach(e -> {
                System.out.println("#  " + e.getKey() + " -> " + e.getValue());
            });
        });
    }
}