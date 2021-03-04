package EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Person> treeSet = new TreeSet<>();
        HashSet<Person> hashSet = new HashSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1]));
            treeSet.add(person);
            hashSet.add(person);
        }
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
