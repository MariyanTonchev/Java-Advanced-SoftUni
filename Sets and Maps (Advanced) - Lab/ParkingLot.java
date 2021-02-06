import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> numbers = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] data = input.split(",\\s+");
            String cmd = data[0];
            String number = data[1];
            if (cmd.equals("IN")) {
                numbers.add(number);
            } else if (cmd.equals("OUT")) {
                numbers.remove(number);
            }
            input = scanner.nextLine();
        }
        if (numbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            numbers.forEach(System.out::println);
        }
    }
}