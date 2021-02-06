import java.util.*;
import java.util.stream.Collectors;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> guests = new TreeSet<>();
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("PARTY")) {
            guests.add(input);
            input = scanner.nextLine();
        }
        String guestName = scanner.nextLine();
        while (!guestName.equalsIgnoreCase("END")) {
            guests.remove(guestName);
            guestName = scanner.nextLine();
        }
        System.out.println(guests.size());
        System.out.println(setElementOnNewLine(guests));
    }

    public static String setElementOnNewLine(Set<String> set) {
        return set.stream().collect(Collectors.joining(System.lineSeparator()));
    }
}