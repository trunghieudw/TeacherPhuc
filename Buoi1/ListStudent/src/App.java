import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. List All Students");
            System.out.println("4. List Male Students");
            System.out.println("5. List Female Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student gender (Male/Female): ");
                    String gender = scanner.nextLine();
                    studentList.add(new Student(name, gender));
                    System.out.println("Student added successfully!");
                    break;
                    
                case 2:
                    System.out.print("Enter student name to remove: ");
                    String removeName = scanner.nextLine();
                    Iterator<Student> iterator = studentList.iterator();
                    while (iterator.hasNext()) {
                        Student student = iterator.next();
                        if (student.name.equalsIgnoreCase(removeName)) {
                            iterator.remove();
                            System.out.println("Student removed successfully!");
                            break;
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("List of all students:");
                    for (Student student : studentList) {
                        System.out.println(student);
                    }
                    break;
                    
                case 4:
                    System.out.println("List of male students:");
                    for (Student student : studentList) {
                        if (student.gender.equalsIgnoreCase("Male")) {
                            System.out.println(student);
                        }
                    }
                    break;
                    
                case 5:
                    System.out.println("List of female students:");
                    for (Student student : studentList) {
                        if (student.gender.equalsIgnoreCase("Female")) {
                            System.out.println(student);
                        }
                    }
                    break;
                    
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}



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



public class Main {
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
