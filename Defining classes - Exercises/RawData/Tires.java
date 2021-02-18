package RawData;

public class Tires {
    private double getTire1Pressure, getTire2Pressure, getTire3Pressure, getTire4Pressure;
    private int tire1Age, tire2Age, tire3Age, tire4Age;

    public Tires(double tire1Pressure, double getTire2Pressure, double getTire3Pressure, double getTire4Pressure, int tire1Age, int tire2Age, int tire3Age, int tire4Age) {
        this.getTire1Pressure = tire1Pressure;
        this.getTire2Pressure = getTire2Pressure;
        this.getTire3Pressure = getTire3Pressure;
        this.getTire4Pressure = getTire4Pressure;
        this.tire1Age = tire1Age;
        this.tire2Age = tire2Age;
        this.tire3Age = tire3Age;
        this.tire4Age = tire4Age;
    }

    public boolean checkFragile(){
        return getTire1Pressure < 1 || getTire2Pressure < 1 || getTire3Pressure < 1 || getTire4Pressure < 1;
    }
}
