import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> cities = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];
            if (!cities.containsKey(continent)) {
                cities.put(continent, new LinkedHashMap<>());
            }
            if (!cities.get(continent).containsKey(country)) {
                cities.get(continent).put(country, new ArrayList<>());
            }
            cities.get(continent).get(country).add(city);
        }
        cities.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((key1, value1) -> {
                System.out.println("  " + key1 + " -> " + value1.toString().replaceAll("[]\\[]", ""));
            });
        });
    }
}