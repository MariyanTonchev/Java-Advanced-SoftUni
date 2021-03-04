package StategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<Person> byName = new TreeSet<>(new ComparatorByName());
        TreeSet<Person> byAge = new TreeSet<>(new ComparatorByAge());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name, age);
            byName.add(person);
            byAge.add(person);
        }
        for (Person person : byName) {
            System.out.println(person.getName() + " " + person.getAge());
        }
        for (Person person : byAge) {
            System.out.println(person.getName() + " " + person.getAge());
        }
    }
}