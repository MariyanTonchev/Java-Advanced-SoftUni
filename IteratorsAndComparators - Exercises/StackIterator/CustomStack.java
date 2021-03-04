package StackIterator;

import java.util.Iterator;

public class CustomStack implements Iterable<Integer> {
    private Node top;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private Node currentNode = top;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Integer next() {
                int element = currentNode.element;
                currentNode = currentNode.prev;
                return element;
            }
        };
    }

    private static class Node {
        private final int element;
        private Node prev;

        public Node(int element) {
            this.element = element;
        }
    }

    public void push(int element) {
        Node newNode = new Node(element);
        if (this.top != null) {
            newNode.prev = this.top;
        }
        this.top = newNode;
    }

    public int pop() {
        if (this.top == null) {
            throw new IllegalStateException("No elements");
        }
        int popTopElement = this.top.element;
        this.top = this.top.prev;
        return popTopElement;
    }
}
