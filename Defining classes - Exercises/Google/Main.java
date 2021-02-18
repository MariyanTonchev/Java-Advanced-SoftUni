package Google;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, Person> persons = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            persons.putIfAbsent(data[0], new Person(data[0], null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null));
            Person person = persons.get(data[0]);
            switch (data[1]) {
                case "company":
                    Company company = new Company(data[2], data[3], Double.parseDouble(data[4]));
                    person.setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(data[2], data[3]);
                    person.getPokemon().add(pokemon);
                    break;
                case "parents":
                    Parents parent = new Parents(data[2], data[3]);
                    person.getParents().add(parent);
                    break;
                case "children":
                    Children children = new Children(data[2], data[3]);
                    person.getChildren().add(children);
                    break;
                case "car":
                    Car car = new Car(data[2], Integer.parseInt(data[3]));
                    person.setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        Person personToPrint = persons.get(input);
        System.out.println(personToPrint.toString());
    }
}
