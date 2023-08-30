import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RemoteInterface remoteObj = (RemoteInterface) registry.lookup("RemoteObject");

            // thêm giáo viên & học sinh
            remoteObj.addStudent(new Student("1", "Thanh Hieu", "Nguyen", "123", "Male", "IT"));
            remoteObj.addStudent(new Student("2", "Trung Hieu", "Le", "456 ", "Female", "Phan Tan"));
            remoteObj.addStudent(new Student("3", "Thanh Tam", "Truong", "789 ", "Female", "CTDLGT"));

            remoteObj.addTeacher(new Teacher("101", "A", "C", "789", "Male", "TS"));
            remoteObj.addTeacher(new Teacher("102", "B", "F", "456", "Female", "Th.S"));

            // xoá 
            remoteObj.deleteStudent(2);
            // hiển thị danh sách học sinh
            List<Student> students = remoteObj.listStudents();
            for (Student student : students) {
                System.out.println("Student: " + student.getFirstName() + " " + student.getFirstName());
            }
            // hiển thị danh sách giáo viên
            List<Teacher> teachers = remoteObj.listTeachers();
            for (Teacher teacher : teachers) {
                System.out.println("Teacher: " + teacher.getFirstName() + " " + teacher.getFirstName());
            }
            // cập nhật 
            remoteObj.updateStudentAddress(1, "456 New Address");
                    // Listing students after updating address
                    List<Student> updatedStudents = remoteObj.listStudents();
                    System.out.println("List of Students after updating address:");
                    for (Student student : updatedStudents) {
                        System.out.println("Student: " + student.getFirstName() + " " + student.getFirstName() + " Address: " + student.getAddress());
                    }            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
