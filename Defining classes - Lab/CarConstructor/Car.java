package CarConstructor;

public class Car {
    public String brand;
    public String model;
    public int horsePower;

    public Car() {

    }

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.horsePower = -1;
    }

    public Car(String brand, int horsePower) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = horsePower;
    }

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

}
