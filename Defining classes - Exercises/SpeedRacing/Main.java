package SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int fuel = Integer.parseInt(tokens[1]);
            double fuelPerKm = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuel, fuelPerKm, 0);
            cars.put(model, car);
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String model = tokens[1];
            int amountKms = Integer.parseInt(tokens[2]);
            cars.get(model).checkFuel(amountKms);
            input = scanner.nextLine();
        }
        cars.values().forEach(car -> System.out.printf("%s %.2f %d%n", car.getModel(), car.getFuelAmount(), car.getDistanceTraveled()));
    }
}