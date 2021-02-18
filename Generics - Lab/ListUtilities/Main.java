package ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, 1, 2, 10, 2, -1);
        Integer maxInteger = ListUtils.getMax(integerList);
        Integer minInteger = ListUtils.getMin(integerList);
        System.out.println(maxInteger);
        System.out.println(minInteger);
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, "a", "b", "s", "aas");
        String minString = ListUtils.getMin(stringList);
        System.out.println(minString);
    }
}
