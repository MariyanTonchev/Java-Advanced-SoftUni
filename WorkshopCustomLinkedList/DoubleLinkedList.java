package WorkshopCustomLinkedList;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoubleLinkedList {
    private static class ListNode {
        private final int item;
        private ListNode next;
        private ListNode previous;

        private ListNode(int element) {
            this.item = element;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public void addFirst(int element) {
        ListNode newHead = new ListNode(element);
        if (this.size == 0) {
            this.head = this.tail = newHead;
        } else {
            newHead.next = this.head;
            this.head.previous = newHead;
            this.head = newHead;
        }
        this.size++;
    }

    public void addLast(int element) {
        ListNode newTail = new ListNode(element);
        if (this.size == 0) {
            this.tail = this.head = newTail;
        } else {
            newTail.previous = this.tail;
            this.tail.next = newTail;
            this.tail = newTail;
        }
        this.size++;
    }

    public int get(int index) {
        checkIndex(index);
        if (index <= this.size / 2) {
            ListNode firstNode = this.head;
            for (int i = 0; i < index; i++) {
                firstNode = firstNode.next;
            }
            return firstNode.item;
        } else {
            ListNode lastNode = this.tail;
            for (int i = this.size; i > index; i--) {
                lastNode = lastNode.previous;
            }
            return lastNode.item;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index: %d out of bounds, Size: %d)", index, this.size));
        }
    }

    public int removeFirst(){
        checkSize();
        int firstItem = this.head.item;
        this.head = this.head.next;
        if(this.head == null){
            this.tail = null;
        } else {
            this.head.previous = null;
        }
        this.size--;
        return firstItem;
    }

    private void checkSize() {
        if(this.size == 0){
            throw new NoSuchElementException("The list is empty!");
        }
    }

    public int removeLast(){
        checkSize();
        int lastItem = this.tail.item;
        this.tail = this.tail.previous;
        if(this.tail == null){
            this.head = null;
        } else {
            this.tail.next = null;
        }
        this.size--;
        return lastItem;
    }

    public void forEach(Consumer<Integer> consumer){
        ListNode currentNode = this.head;
        while (currentNode!= null){
            consumer.accept(currentNode.item);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray(){
        int[] array = new int[this.size];
        int count = 0;
        ListNode currentNode = this.head;
        while (currentNode!=null){
            array[count++] = currentNode.item;
            currentNode = currentNode.next;
        }
        return array;
    }
}
