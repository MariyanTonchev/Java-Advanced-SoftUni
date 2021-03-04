package Treeuple;

public class Treeuple<K, V, C> {
    private final K item1;
    private final V item2;
    private final C item3;

    public Treeuple(K item1, V item2, C item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", item1, item2, item3);
    }
}
