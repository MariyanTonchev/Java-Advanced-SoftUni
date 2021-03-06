package CompanyRooster;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Department> departments = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = null;
            departments.putIfAbsent(department, new Department());
            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (tokens.length == 5) {
                if (tokens[4].matches("^\\d+$")) {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }
            departments.get(department).addEmployee(employee);
        }
        double avgSalary = Double.MIN_VALUE;
        String bestDepartment = "";
        for (var department : departments.entrySet()) {
            if (department.getValue().getAverageSalary() > avgSalary) {
                avgSalary = department.getValue().getAverageSalary();
                bestDepartment = department.getKey();
            }
        }
        Department bestDepartmentObject = departments.get(bestDepartment);
        System.out.printf("Highest Average Salary: %s%n", bestDepartment);
        bestDepartmentObject.getList().stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary())).forEach(System.out::println);
    }
}
