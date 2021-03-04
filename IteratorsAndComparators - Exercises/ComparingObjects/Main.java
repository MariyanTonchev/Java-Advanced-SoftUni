package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String[] data = line.split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];
            Person person = new Person(name, age, town);
            people.add(person);
        }
        int index = Integer.parseInt(scanner.nextLine());
        Person searchPerson = people.get(index - 1);
        int count = 0;
        for (Person person : people) {
            if (person.compareTo(searchPerson) == 0) {
                count++;
            }
        }
        if (count == 1){
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", count, people.size() - count, people.size());
        }
    }
}
