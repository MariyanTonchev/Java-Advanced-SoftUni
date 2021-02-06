import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, ArrayList<Double>> students = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            double grade = Double.parseDouble(data[1]);
            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }
            students.get(name).add(grade);
        }
        students.keySet().forEach(s -> {
            System.out.print(s + " ");
            students.get(s).forEach(l -> {
                System.out.printf("%.2f -> ", l);
            });
            double sum = students.get(s).stream().mapToDouble(a -> a).sum();
            System.out.printf("(avg: %.2f)", sum / students.get(s).size());
            System.out.println();
        });
    }
}