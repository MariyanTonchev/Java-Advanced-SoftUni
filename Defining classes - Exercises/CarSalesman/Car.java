package CarSalesman;

public class Car {
    public String model;
    public Engine engine;
    public int weight;
    public String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, 0, "n/a");
    }

    @Override
    public String toString() {
        String output;
        if (weight == 0) {
            output = model + ":" + '\n' +
                    engine.toString() +
                    "Weight: n/a" + '\n' +
                    "Color: " + color;
        } else {
            output = model + ":" + '\n' +
                    engine.toString() +
                    "Weight: " + weight + '\n' +
                    "Color: " + color;
        }
        return output;
    }
}
