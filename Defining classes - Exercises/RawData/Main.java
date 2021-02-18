package RawData;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            Engine engine = new Engine(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            Cargo cargo = new Cargo(Integer.parseInt(data[3]), data[4]);
            Tires tires = new Tires(Double.parseDouble(data[5]), Double.parseDouble(data[7]), Double.parseDouble(data[9]), Double.parseDouble(data[11]),
                    Integer.parseInt(data[6]), Integer.parseInt(data[8]), Integer.parseInt(data[10]), Integer.parseInt(data[12]));
            Car car = new Car(data[0], engine, cargo, tires);
            cars.put(data[0], car);
        }
        String cmd = scanner.nextLine();
        if (cmd.equals("fragile")) {
            cars.forEach((s, car) -> {
                if (car.getTires().checkFragile()) {
                    System.out.println(s);
                }
            });
        } else {
            cars.forEach((s, car) -> {
                if (car.getEngine().getEnginePower() > 250) {
                    System.out.println(s);
                }
            });
        }
    }
}