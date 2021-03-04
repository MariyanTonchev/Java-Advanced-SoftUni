package StategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int res = Integer.compare(o1.getName().length(), o2.getName().length());
        if(res == 0){
            res = Character.compare(o1.getName().toLowerCase().charAt(0), o2.getName().toLowerCase().charAt(0));
        }
        return res;
    }
}
