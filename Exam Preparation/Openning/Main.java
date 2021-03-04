package bakery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bakery bakery = new Bakery("Barny", 10);
        Employee employee = new Employee("Stephen", 40, "Bulgaria");
        System.out.println(employee);
        bakery.add(employee);
        System.out.println(bakery.remove("Employee name"));
        Employee secondEmployee = new Employee("Mark", 44, "UK");
        bakery.add(secondEmployee);
        Employee oldestEmployee = bakery.getOldestEmployee();
        Employee employeeStephen = bakery.getEmployee("Stephen");
        System.out.println(oldestEmployee);
        System.out.println(employeeStephen);
        System.out.println(bakery.count());
        System.out.println(bakery.report());
    }
}
