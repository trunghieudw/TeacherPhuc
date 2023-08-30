import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class App {
    public static void main(String[] args) throws Exception {
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
