package Google;

public class Car {
    private final String model;
    private final int carSpeed;

    public Car(String model, int carSpeed) {
        this.model = model;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return model + " " + carSpeed;
    }
}
