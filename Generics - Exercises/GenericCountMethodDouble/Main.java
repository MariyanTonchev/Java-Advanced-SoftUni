package GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> list = new Box<>();
        for (int i = 0; i < n; i++) {
            Double value = Double.parseDouble(scanner.nextLine());
            list.addToList(value);
        }
        Double c = Double.parseDouble(scanner.nextLine());
        System.out.println(list.count(c));
    }
}
