package WorkshopCustomDataStructures;

public class Main {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(5);
        stack.push(3);
        stack.forEach(System.out::println);
    }
}
