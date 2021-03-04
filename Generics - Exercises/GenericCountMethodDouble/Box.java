package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private final List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void addToList(T value) {
        this.list.add(value);
    }

    public int count(T a){
        int count = 0;
        for (T t : this.list) {
            if(t.compareTo(a) > 0){
                count++;
            }
        }
        return count;
    }
}
