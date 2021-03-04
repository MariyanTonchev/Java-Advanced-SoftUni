package LinkedListTravelsal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            if (data[0].equals("Add")) {
                doubleLinkedList.add(Integer.parseInt(data[1]));
            } else {
                doubleLinkedList.remove(Integer.parseInt(data[1]));
            }
        }
        System.out.println(doubleLinkedList.getSize());
        doubleLinkedList.forEach(a -> System.out.print(a + " "));
    }
}