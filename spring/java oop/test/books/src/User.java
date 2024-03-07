public class User {
    private String name;
    private String libraryCardNumber;

    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
    }

    public String getName() {
        return name;
    }
    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

}
