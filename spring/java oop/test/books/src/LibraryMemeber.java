import java.util.ArrayList;
import java.util.List;

public class LibraryMemeber extends User{
    private List<Book> borrowedBooks;
    public LibraryMemeber(String name, String libraryCardNumber) {
        super(name, libraryCardNumber);
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (book.getIsAvailable()) {
            book.borrow();
            borrowedBooks.add(book);
            System.out.println(getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnItem();
            borrowedBooks.remove(book);
            System.out.println(getName() + " returned " + book.getTitle());
        } else {
            System.out.println("You didn't borrow this book.");
        }
    }

}
