package ListIterator;

import java.util.List;

public class ListIterator {
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

    public void print() {
        validatePrint();
        System.out.println(this.list.get(count));
    }

    private void validatePrint() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
    }
}