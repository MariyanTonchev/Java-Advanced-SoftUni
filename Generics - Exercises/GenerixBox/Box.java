package GenerixBox;

public class Box<T> {
    private final T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.getClass().getName() + ": " + value.toString();
    }
}
