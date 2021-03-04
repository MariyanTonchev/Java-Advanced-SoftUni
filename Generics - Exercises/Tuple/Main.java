package Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String[] data1 = scanner.nextLine().split("\\s+");
            switch (i) {
                case 0:
                    String name = data1[0] + " " + data1[1];
                    String address = data1[2];
                    Tuple<String, String> tuple1 = new Tuple<>(name, address);
                    System.out.println(tuple1);
                    break;
                case 1:
                    name = data1[0];
                    int litersOfBeer = Integer.parseInt(data1[1]);
                    Tuple<String, Integer> tuple2 = new Tuple<>(name, litersOfBeer);
                    System.out.println(tuple2);
                    break;
                case 2:
                    int item1 = Integer.parseInt(data1[0]);
                    double item2 = Double.parseDouble(data1[1]);
                    Tuple<Integer, Double> tuple3 = new Tuple<>(item1, item2);
                    System.out.println(tuple3);
                    break;
            }
        }
    }
}