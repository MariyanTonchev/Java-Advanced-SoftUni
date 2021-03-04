package Colletion;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListIterator implements Iterable<String> {
    private final List<String> list;
    private int count = 0;

    public ListIterator(List<String> list) {
        this.list = list;
    }

    public boolean hasNext() {
        return count < list.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
            count++;
            return true;
        }
        return false;
    }

    public void print() throws Exception {
        validatePrint();
        System.out.println(this.list.get(count));
    }

    private void validatePrint() throws Exception {
        if (this.list.isEmpty()) {
            throw new Exception("Invalid Operation!");
        }
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator<String> spliterator() {
        return null;
    }

    public void printAll() throws Exception {
        validatePrint();
        for (String s : this.list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}