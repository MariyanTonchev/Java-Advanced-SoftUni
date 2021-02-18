package CarInfo;

public class Car {
    public String brand;
    public String model;
    public int horsePower;

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public void print(){
        System.out.printf("The car is: %s %s - %d HP.%n", brand, model, horsePower);
    }
}
