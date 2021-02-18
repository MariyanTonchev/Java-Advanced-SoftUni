package GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {
    @SuppressWarnings("unchecked")
    public static <T> T[] create(int l, T item) {
        T[] arr = (T[]) Array.newInstance(item.getClass(), l);
        for (int i = 0; i < l; i++) {
            arr[i] = item;
        }
        return arr;
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> clazz, int l, T item) {
        T[] arr = (T[]) Array.newInstance(clazz, l);
        for (int i = 0; i < l; i++) {
            arr[i] = item;
        }
        return arr;
    }
}
