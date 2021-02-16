import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, input);
        Consumer<String> printer = createPrinter();
        print(list, printer);
    }

    static Consumer<String> createPrinter() {
        Consumer<String> printer = null;
        printer = p -> System.out.println("Sir " + p);
        return printer;
    }

    static void print(List<String> list, Consumer<String> printer) {
        for (String s : list) {
            printer.accept(s);
        }
    }
}
