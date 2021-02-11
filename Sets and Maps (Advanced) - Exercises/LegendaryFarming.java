import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("fragments", 0);
        keyMaterials.put("shards", 0);
        keyMaterials.put("motes", 0);
        TreeMap<String, Integer> junk = new TreeMap<>();
        while (true) {
            String[] data = scanner.nextLine().split("\\s+");
            boolean end = false;
            for (int i = 0; i < data.length; i += 2) {
                String material = data[i + 1].toLowerCase();
                int amount = Integer.parseInt(data[i]);
                if (material.equalsIgnoreCase("shards") || material.equalsIgnoreCase("motes") || material.equalsIgnoreCase("fragments")) {
                    keyMaterials.put(material, keyMaterials.get(material) + amount);
                } else {
                    if (!junk.containsKey(material)) {
                        junk.put(material, amount);
                    } else {
                        junk.put(material, junk.get(material) + amount);
                    }
                }
                if (isObtained(material, keyMaterials)) {
                    keyMaterials.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).forEach(c -> {
                        System.out.println(c.getKey() + ": " + c.getValue());
                    });
                    junk.forEach((key, value) -> System.out.println(key + ": " + value));
                    end = true;
                    break;
                }
            }
            if (end) {
                break;
            }
        }
    }

    private static boolean isObtained(String material, TreeMap<String, Integer> keyMaterials) {
        if (keyMaterials.containsKey(material) && keyMaterials.get("fragments") >= 250) {
            System.out.println("Valanyr obtained!");
            keyMaterials.put(material, keyMaterials.get(material) - 250);
            return true;
        } else if (keyMaterials.containsKey(material) && keyMaterials.get("shards") >= 250) {
            System.out.println("Shadowmourne obtained!");
            keyMaterials.put(material, keyMaterials.get(material) - 250);
            return true;
        } else if (keyMaterials.containsKey(material) && keyMaterials.get("motes") >= 250) {
            System.out.println("Dragonwrath obtained!");
            keyMaterials.put(material, keyMaterials.get(material) - 250);
            return true;
        }
        return false;
    }
}