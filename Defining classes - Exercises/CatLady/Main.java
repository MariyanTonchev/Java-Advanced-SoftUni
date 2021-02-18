package CatLady;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Cat> cats = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            cats.put(data[1], new Cat(data[0], data[1], Double.parseDouble(data[2])));
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        System.out.println(cats.get(input).toString());
    }
}