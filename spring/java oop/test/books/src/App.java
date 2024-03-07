public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Author maria = new Author(" Maria Hoey");
        Author emily = new Author("Emilia McKenzie");
        Author ashes = new Author(" Álvaro Ortiz");
        Book ashesBook = new Book("Ashes","978-1-60309-517-4",ashes);
        Book animalBook = new Book("Animal Story","978-1-60309-502-0",maria);
        Book book2 = new Book("But You Have Friends","978-1-60309-527-3",emily);

        LibraryItem book = new Book("my book", "1234567890", new Author("Author Name"));
        book.borrow();
        LibraryMemeber libraryItem = new LibraryMemeber("wende", "1234");
        libraryItem.borrowBook(ashesBook);

        System.out.println("User name: " + libraryItem.getName());
        System.out.println("Library Card: " + libraryItem.getLibraryCardNumber());

        LibraryMemeber libraryItem2 = new LibraryMemeber("Yonas", "123");
        libraryItem2.borrowBook(ashesBook);
        
    }
}
