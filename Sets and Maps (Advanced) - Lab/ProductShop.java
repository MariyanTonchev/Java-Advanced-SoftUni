import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] data = input.split(",\\s+");
            String shop = data[0];
            String product = data[1];
            Double price = Double.valueOf(data[2]);
            if (!shops.containsKey(shop)) {
                shops.put(shop, new LinkedHashMap<>());
            }
            shops.get(shop).put(product, price);
            input = scanner.nextLine();
        }
        shops.keySet().forEach(s -> {
            System.out.println(s + "->");
            shops.get(s).forEach((product, price) -> {
                System.out.printf("Product: %s, Price: %.1f%n", product, price);
            });
        });
    }
}