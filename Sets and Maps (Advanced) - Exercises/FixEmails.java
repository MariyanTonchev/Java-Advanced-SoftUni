import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> emails = new LinkedHashMap<>();
        while (scanner.hasNext()) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("stop")) {
                break;
            }
            String email = scanner.nextLine();
            String[] emailSplit = email.split("\\.");
            String domain = emailSplit[1];
            if (!(domain.equalsIgnoreCase("us") || domain.equalsIgnoreCase("uk") || domain.equalsIgnoreCase("com"))) {
                emails.put(name, email);
            }
        }
        emails.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}