import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] prices = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToDouble(Double::parseDouble).toArray();
        UnaryOperator<Double> addVAT = price -> price * 1.20;
        System.out.println("Prices with VAT:");
        for (Double price : prices) {
            System.out.printf("%.2f%n", addVAT.apply(price));
        }
    }
}