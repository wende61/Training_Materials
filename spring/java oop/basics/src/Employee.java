import java.time.LocalDate;
import java.util.Date;

public class Employee {
    
    private String name;
    private double salary;
    private LocalDate birthDate;

    public Employee(String name, double salary, LocalDate birthDate) {
        this.name = name;
        this.salary = salary;
        this.birthDate = birthDate;
    }


    public String toString() {
        return "Name: " + name + " salary: " + salary + " birthDate: " + birthDate;
    }

}
