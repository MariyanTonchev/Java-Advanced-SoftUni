package CarSalesman;

public class Engine {
    public String model;
    public int power;
    public int displacement;
    public String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this(model, power, 0, "n/a");
    }

    @Override
    public String toString() {
        String output;
        if(displacement == 0){
            output = model + ":" + '\n' +
                    "Power: " + power + '\n' +
                    "Displacement: n/a" + '\n' +
                    "Efficiency: " + efficiency + '\n';
        } else {
            output = model + ":" + '\n' +
                    "Power: " + power + '\n' +
                    "Displacement: " + displacement + '\n' +
                    "Efficiency: " + efficiency + '\n';
        }
        return output;
    }
}
