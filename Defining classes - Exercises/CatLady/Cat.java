package CatLady;

public class Cat {
    private final String breed;
    private final String name;
    private final double specific;

    public Cat(String breed, String name, double specific) {
        this.breed = breed;
        this.name = name;
        this.specific = specific;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", breed, name, specific);
    }
}
