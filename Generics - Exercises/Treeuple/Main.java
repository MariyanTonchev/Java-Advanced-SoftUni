package Treeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        String name = data[0] + " " + data[1];
        String address = data[2];
        String town = data[3];
        Treeuple<String, String, String> treeuple1 = new Treeuple<>(name, address, town);
        System.out.println(treeuple1);

        data = scanner.nextLine().split("\\s+");
        name = data[0];
        int litersOfBeer = Integer.parseInt(data[1]);
        boolean isDrunk = "drunk".equals(data[2]);
        Treeuple<String, Integer, Boolean> treeuple2 = new Treeuple<>(name, litersOfBeer, isDrunk);
        System.out.println(treeuple2);

        data = scanner.nextLine().split("\\s+");
        String item1 = data[0];
        double item2 = Double.parseDouble(data[1]);
        String item3 = data[2];
        Treeuple<String, Double, String> treeuple3 = new Treeuple<>(item1, item2, item3);
        System.out.println(treeuple3);
    }
}
