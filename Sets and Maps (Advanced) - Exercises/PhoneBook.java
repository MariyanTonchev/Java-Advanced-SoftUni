import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("search")) {
            String[] data = input.split("-");
            String name = data[0];
            String number = data[1];
            phonebook.put(name, number);
            input = scanner.nextLine();
        }
        String input2 = scanner.nextLine();
        while (!input2.equalsIgnoreCase("stop")) {
            if (phonebook.containsKey(input2)) {
                System.out.println(input2 + " -> " + phonebook.get(input2));
            } else {
                System.out.println("Contact " + input2 + " does not exist.");
            }
            input2 = scanner.nextLine();
        }
    }
}