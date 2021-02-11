import java.util.*;

public class DragonArmy {
    private static final int DEF_DMG = 45;
    private static final int DEF_HEALTH = 250;
    private static final int DEF_ARMOR = 10;

    private static double[] average(TreeMap<String, int[]> map) {
        int totalDamage = 0;
        int totalHealth = 0;
        int totalArmor = 0;
        double entries = map.size();
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            totalDamage += entry.getValue()[0];
            totalHealth += entry.getValue()[1];
            totalArmor += entry.getValue()[2];
        }
        return new double[]{totalDamage / entries, totalHealth / entries, totalArmor / entries};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String type = data[0];
            String name = data[1];
            int dmg = data[2].equals("null") ? DEF_DMG : Integer.parseInt(data[2]);
            int health = data[3].equals("null") ? DEF_HEALTH : Integer.parseInt(data[3]);
            int armor = data[4].equals("null") ? DEF_ARMOR : Integer.parseInt(data[4]);
            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
            }
            if (!dragons.get(type).containsKey(name)) {
                dragons.get(type).put(name, new int[3]);
            }
            int[] stats = {dmg, health, armor};
            dragons.get(type).put(name, stats);
        }
        for (Map.Entry<String, TreeMap<String, int[]>> typeStats : dragons.entrySet()) {
            double[] average = average(typeStats.getValue());
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", typeStats.getKey(), average[0], average[1], average[2]);
            for (Map.Entry<String, int[]> dragon : typeStats.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon.getKey(), dragon.getValue()[0], dragon.getValue()[1], dragon.getValue()[2]);
            }
        }
    }
}