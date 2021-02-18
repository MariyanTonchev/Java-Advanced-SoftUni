package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            Engine engine;
            if (data.length == 3) {
                if (data[2].matches("^\\d+$")) {
                    engine = new Engine(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), "n/a");
                } else {
                    engine = new Engine(data[0], Integer.parseInt(data[1]), 0, data[2]);
                }
            } else if (data.length == 4) {
                engine = new Engine(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]);
            } else {
                engine = new Engine(data[0], Integer.parseInt(data[1]));
            }
            engines.put(data[0], engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            Car car;
            if (data.length == 3) {
                if (data[2].matches("^\\d+$")) {
                    car = new Car(data[0], engines.get(data[1]), Integer.parseInt(data[2]), "n/a");
                } else {
                    car = new Car(data[0], engines.get(data[1]), 0, data[2]);
                }
            } else if (data.length == 4) {
                car = new Car(data[0], engines.get(data[1]), Integer.parseInt(data[2]), data[3]);
            } else {
                car = new Car(data[0], engines.get(data[1]));
            }
            cars.add(car);
        }
        cars.forEach(car -> System.out.println(car.toString()));
    }
}
