public class Book implements LibraryItem {
    private String title;
    private String isbn;
    private Author author;
    private boolean isAvailable;

    public Book(String title, String isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.isAvailable = true;
    }

    public Author getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed: " + title);
        } else {
            System.out.println("Book is not available.");
        }
    }

    @Override
    public void returnItem() {
        isAvailable = true;
        System.out.println("Book returned: " + title);
    }

}
