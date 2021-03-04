package LinkedListTravelsal;

import java.util.function.Consumer;

public class DoubleLinkedList<T> {
    private static class ListNode<T> {
        private T item;
        private ListNode<T> next;
        private ListNode<T> previous;

        private ListNode(T element) {
            this.item = element;
        }
    }

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public void add(T element) {
        ListNode<T> newElement = new ListNode<>(element);
        if (this.size == 0) {
            this.tail = this.head = newElement;
        } else {
            newElement.previous = this.tail;
            this.tail.next = newElement;
            this.tail = newElement;
        }
        this.size++;
    }

    public int getSize() {
        return this.size;
    }

    public T get(int index) {
        checkIndex(index);
        if (index <= this.size / 2) {
            ListNode<T> firstNode = this.head;
            for (int i = 0; i < index; i++) {
                firstNode = firstNode.next;
            }
            return firstNode.item;
        } else {
            ListNode<T> lastNode = this.tail;
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

    public void forEach(Consumer<T> consumer) {
        ListNode<T> currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.item);
            currentNode = currentNode.next;
        }
    }

    public boolean remove(T element) {
        if (element == null) {
            for (ListNode<T> x = head; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (ListNode<T> x = head; x != null; x = x.next) {
                if (element.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    private void unlink(ListNode<T> x) {
        ListNode<T> next = x.next;
        ListNode<T> prev = x.previous;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.previous = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.previous = prev;
            x.next = null;
        }
        x.item = null;
        size--;
    }
}