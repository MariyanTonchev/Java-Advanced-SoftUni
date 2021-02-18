package GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = ArrayCreator.create(10, 13);
        String[] arr2 = ArrayCreator.create(String.class,10, "asd");

        for (String integer : arr2) {
            System.out.println(integer);
        }
    }
}
