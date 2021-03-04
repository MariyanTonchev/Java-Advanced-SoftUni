package GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    private final List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void addToList(T value) {
        this.list.add(value);
    }

    public void swap(int a, int b){
        Collections.swap(this.list, a, b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : list) {
            sb.append(t.getClass().getName()).append(": ").append(t).append("\n");
        }
        return sb.toString();
    }
}
