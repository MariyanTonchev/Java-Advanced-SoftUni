import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> users = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] userInfo = scanner.nextLine().split(",\\s+");
            String name = userInfo[0];
            int age = Integer.parseInt(userInfo[1]);
            users.put(name, age);
        }
        String condition = scanner.nextLine();
        int ageCondition = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();
        Predicate<Integer> tester = createTester(condition, ageCondition);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);
        printFilteredStudent(users, tester, printer);
    }

    static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        Consumer<Map.Entry<String, Integer>> printer = null;
        switch (format) {
            case "name age":
                printer = p -> System.out.printf("%s - %d%n", p.getKey(), p.getValue());
                break;
            case "age":
                printer = p -> System.out.println(p.getValue());
                break;
            case "name":
                printer = p -> System.out.println(p.getKey());
                break;
        }
        return printer;
    }

    static Predicate<Integer> createTester(String condition, Integer age) {
        Predicate<Integer> tester = null;
        switch (condition) {
            case "younger":
                tester = t -> t <= age;
                break;
            case "older":
                tester = t -> t >= age;
                break;
        }
        return tester;
    }

    static void printFilteredStudent(LinkedHashMap<String, Integer> people, Predicate<Integer> tester, Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey()))) {
                printer.accept(person);
            }
        }
    }
}