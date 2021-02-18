package GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("c", "b");
        Scale<Integer> integerScale = new Scale<>(5, 10);
        System.out.println(stringScale.getHeavier());
        System.out.println(integerScale.getHeavier());
    }
}