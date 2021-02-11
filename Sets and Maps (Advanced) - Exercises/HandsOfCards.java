import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();
        while (!input.equalsIgnoreCase("joker")) {
            String[] data = input.split(":\\s+");
            String player = data[0];
            String[] cards = data[1].split(",\\s+");
            if (!players.containsKey(player)) {
                players.put(player, new HashSet<>());
            }
            players.get(player).addAll(Arrays.asList(cards));
            input = scanner.nextLine();
        }
        players.forEach((key, value) -> {
            ArrayList<String> cards = new ArrayList<>(value);
            int sum = 0;
            for (String card : cards) {
                sum += getPower(card) * getMultiple(card);
            }
            System.out.println(key + ": " + sum);
        });
    }

    private static int getMultiple(String b) {
        char multi = b.charAt(b.length() - 1);
        int m = 0;
        switch (multi) {
            case 'S':
                m = 4;
                break;
            case 'H':
                m = 3;
                break;
            case 'D':
                m = 2;
                break;
            case 'C':
                m = 1;
                break;
        }
        return m;
    }

    private static int getPower(String b) {
        int power = 0;
        if (b.length() == 3) {
            power = 10;
            return power;
        }
        int p = b.charAt(0);
        switch (p) {
            case 'J':
                power = 11;
                break;
            case 'Q':
                power = 12;
                break;
            case 'K':
                power = 13;
                break;
            case 'A':
                power = 14;
                break;
            default:
                power = p - 48;
        }
        return power;
    }
}