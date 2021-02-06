import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, double[]> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            students.put(name, scores);
        }
        students.forEach((key, value) -> {
            double sum = Arrays.stream(value).average().orElse(0);
            System.out.printf("%s is graduated with %s%n", key, sum);
        });
    }
}