package SpeedRacing;

public class Car {
    String model;
    double fuelAmount;
    double fuelCostPerKm;
    int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPerKm, int distanceTraveled) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = distanceTraveled;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void checkFuel(int kms) {
        double neededFuel = fuelCostPerKm * kms;
        if (neededFuel <= this.fuelAmount) {
            fuelAmount -= neededFuel;
            distanceTraveled += kms;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
}
