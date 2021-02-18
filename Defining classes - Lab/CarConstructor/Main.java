package CarConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            Car car;
            if (carInfo.length == 1) {
                car = new Car(carInfo[0]);
            } else if (carInfo.length == 2) {
                car = new Car(carInfo[0], carInfo[1]);
            } else {
                car = new Car(carInfo[0], carInfo[1], Integer.parseInt(carInfo[2]));
            }
            cars.add(car);
        }
        cars.forEach(a -> System.out.printf("The car is: %s %s - %d HP.%n", a.getBrand(), a.getModel(), a.getHorsePower()));
    }
}