package Tuple;

public class Tuple<ITEM1, ITEM2> {
    private final ITEM1 item1;
    private final ITEM2 item2;

    public Tuple(ITEM1 item1, ITEM2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return item1 + " -> " + item2;
    }
}
