public class Person {
    private String name;
    private int age; //Fildes of Person

    public Person(String name, int age) { // Constractor
        this.name = name;
        this.age = age;
    }

    public Person() { // Constractor
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
