import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    static List<String> guests = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("party!")) {
            String[] data = input.split("\\s+");
            String cmd = data[0];
            if (cmd.equalsIgnoreCase("remove")) {
                removeName(getPredicate(data));
            } else if (cmd.equalsIgnoreCase("double")) {
                addOneMore(getPredicate(data));
            }
            input = scanner.nextLine();
        }
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guests);
            System.out.println(guests.toString().replaceAll("[\\[\\]]", "") + " are going to the party!");
        }
    }

    public static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate;
        if (tokens[1].equalsIgnoreCase("startswith")) {
            predicate = name -> name.startsWith(tokens[2]);
        } else if (tokens[1].equalsIgnoreCase("endswith")) {
            predicate = name -> name.endsWith(tokens[2]);
        } else {
            predicate = name -> name.length() == Integer.parseInt(tokens[2]);
        }
        return predicate;
    }

    public static void addOneMore(Predicate<String> predicate) {
        List<String> guestsToAdd = new ArrayList<>();
        guests.stream().filter(predicate).forEach(guestsToAdd::add);
        guests.addAll(guestsToAdd);
    }

    public static void removeName(Predicate<String> predicate) {
        guests.removeIf(predicate);
    }
}