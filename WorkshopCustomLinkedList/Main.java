package WorkshopCustomLinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addLast(3);
        doubleLinkedList.addFirst(5);
        doubleLinkedList.addLast(55);
        System.out.println("Removed: " + doubleLinkedList.removeLast());
        System.out.println("Removed: " + doubleLinkedList.removeFirst());
        System.out.println(doubleLinkedList.get(1));
        doubleLinkedList.forEach(System.out::println);
        int[] arr = doubleLinkedList.toArray();
        System.out.println(Arrays.toString(arr));
    }
}
