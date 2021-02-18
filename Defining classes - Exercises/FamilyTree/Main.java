package FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = reader.readLine();
        String namePattern = "[A-Z0-9][a-z0-9]+\\s[A-Z0-9][a-z0-9]+";
        Person mainPerson = createPersonByPattern(firstLine, namePattern);
        List<HashMap<String, String>> maps = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s-\\s");
            switch (tokens.length) {
                case 2:
                    HashMap<String, String> map = new HashMap<>();
                    map.put(tokens[0], tokens[1]);
                    maps.add(map);
                    break;
                case 1:
                    tokens = tokens[0].split("\\s+");
                    String name = tokens[0] + " " + tokens[1];
                    String birthDate = tokens[2];
                    Person person = new Person(name, birthDate);
                    people.add(person);
                    if ((name.equals(mainPerson.getName()) || birthDate.equals(mainPerson.getBirthDate())) && mainPerson.hasNullFields()) {
                        updateMainPerson(mainPerson, name, birthDate);
                    }
                    break;
            }
        }
        FamilyTree familyTree = new FamilyTree();
        familyTree.setMainPerson(mainPerson);
        for (HashMap<String, String> map : maps) {
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                if (stringStringEntry.getKey().equals(mainPerson.getName()) || stringStringEntry.getKey().equals(mainPerson.getBirthDate())) {
                    people.stream()
                            .filter(p -> p.getName().equals(stringStringEntry.getValue()) || p.getBirthDate().equals(stringStringEntry.getValue()))
                            .findFirst()
                            .ifPresent(familyTree::addChild);
                } else if (stringStringEntry.getValue().equals(mainPerson.getName()) || stringStringEntry.getValue().equals(mainPerson.getBirthDate())) {
                    people.stream()
                            .filter(p -> p.getName().equals(stringStringEntry.getKey()) || p.getBirthDate().equals(stringStringEntry.getKey()))
                            .findFirst()
                            .ifPresent(familyTree::addParent);
                }
            }
        }

        System.out.println(familyTree);
    }

    private static void updateMainPerson(Person person, String name, String birthDate) {
        if (person.getName() == null) {
            person.setName(name);
        } else if (person.getBirthDate() == null) {
            person.setBirthDate(birthDate);
        }
    }

    private static Person createPersonByPattern(String value, String namePattern) {
        Person person = new Person();
        if (value.matches(namePattern)) {
            person.setName(value);
        } else {
            person.setBirthDate(value);
        }
        return person;
    }
}