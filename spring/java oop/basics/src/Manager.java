import java.time.LocalDate;
import java.util.Date;

public class Manager extends Employee {

    // new element
    private String department;

    public Manager(String name, double salary, LocalDate birthDate, String department) {
        super(name, salary, birthDate);
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + " department: " + department;
    }
}
