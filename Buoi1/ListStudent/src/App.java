import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class Human {
    protected String id;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String sex;

    public Human(String id, String firstName, String lastName, String address, String sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sex = sex;
    }

    public abstract void displayInfo();
}

class Student extends Human {
    private String majors;

    public Student(String id, String firstName, String lastName, String address, String sex, String majors) {
        super(id, firstName, lastName, address, sex);
        this.majors = majors;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Info:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("Sex: " + sex);
        System.out.println("Majors: " + majors);
        System.out.println();
    }
}



public class App {
    public static void main(String[] args) {
        List<Human> people = new ArrayList<>();

        // Thêm sinh viên và giáo viên vào danh sách
        people.add(new Student("S001", "Alice", "Johnson", "123 Main St", "Female", "Computer Science"));
        people.add(new Student("S002", "Bob", "Smith", "456 Elm St", "Male", "Engineering"));
        people.add(new Student("S003", "Eva", "Williams", "789 Oak St", "Female", "Biology"));

        people.add(new Teacher("T001", "Professor", "Brown", "234 Pine St", "Male", "Ph.D."));
        people.add(new Teacher("T002", "Dr.", "Davis", "567 Maple St", "Female", "M.Ed"));

        // Xoá một sinh viên
        Iterator<Human> iterator = people.iterator();
        while (iterator.hasNext()) {
            Human person = iterator.next();
            if (person instanceof Student && person.id.equals("S002")) {
                iterator.remove();
            }
        }

        // Liệt kê danh sách sinh viên và giáo viên
        for (Human person : people) {
            person.displayInfo();
        }

        // Liệt kê danh sách sinh viên
        System.out.println("List of Students:");
        for (Human person : people) {
            if (person instanceof Student) {
                person.displayInfo();
            }
        }

        // Cập nhật địa chỉ của sinh viên
        for (Human person : people) {
            if (person instanceof Student && person.id.equals("S001")) {
                ((Student) person).address = "555 New St";
            }
        }
    }
}
