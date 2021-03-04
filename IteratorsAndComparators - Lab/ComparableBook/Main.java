package ComparableBook;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("Animal Farm", 2002);
        Book bookThree = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Library<Book> library = new Library<>(bookOne, bookTwo, bookThree);
        if(bookOne.compareTo(bookTwo) > 0) {
            System.out.printf("%s is before %s", bookOne.getTitle() + bookOne.getYear(), bookTwo.getTitle());
        } else if (bookOne.compareTo(bookTwo) < 0){
            System.out.printf("%s is before %s", bookTwo.getTitle() + bookOne.getYear(), bookOne.getTitle());
        } else {
            System.out.println("Book are equal");
        }
    }
}
