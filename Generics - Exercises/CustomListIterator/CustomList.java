package CustomListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable {
    private final List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {

        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int index1, int index2) {
        T currentElement = this.list.get(index1);
        this.list.set(index1, this.list.get(index2));
        this.list.set(index2, currentElement);
    }

    public long countGreaterThan(T element) {
        return this.list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        T max = null;
        if (!this.list.isEmpty()) {
            max = this.list.get(0);
            for (T t : this.list) {
                if (t.compareTo(max) > 0) {
                    max = t;
                }
            }
        }
        return max;
    }

    public int size(){
        return this.list.size();
    }

    public T get(int i) {
        return this.list.get(i);
    }

    public T getMin() {
        T min = null;
        if (!this.list.isEmpty()) {
            min = this.list.get(0);
            for (T t : this.list) {
                if (t.compareTo(min) < 0) {
                    min = t;
                }
            }
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : this.list) {
            sb.append(t.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public T next() {
                this.index++;
                T element = list.get(index);
                index++;
                return element;
            }
        };
    }
}
