import java.time.LocalDate;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {

        Person person1 = new Person();
        person1.setName("Wende");   
        person1.setAge(40);

        Person person = new Person("John", 30);

        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        Manager manager = new Manager("John",1000.0,LocalDate.now(), "Development");

        System.out.println("manager is: " + manager.toString());

        Dog dog = new Dog();
        Cat cat = new Cat();


        dog.eat();
        cat.eat();
        //own function
        dog.sound();
        cat.sound();

        Calculator calc = new Calculator();

        System.out.println(calc.subtract(4, 2));
        System.out.println(calc.subtract(5.0f, 1.0f));
        System.out.println(calc.subtract(5.63d, 3.12d));
        System.out.println(calc.subtract(100l, 50l));
    }
}
