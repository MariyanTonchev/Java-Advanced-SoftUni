package BookComparator;

import java.util.Comparator;

class BookComparator implements Comparator<Book> {
    public int compare(Book o1, Book o2) {
        int result = o1.getTitle().compareTo(o2.getTitle());
        return result != 0 ? result : Integer.compare(o1.getYear(), o2.getYear());
    }
}
