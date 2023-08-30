import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteInterface extends Remote {
    void addStudent(Student student) throws RemoteException;
    void addTeacher(Teacher teacher) throws RemoteException;
    void deleteStudent(int studentId) throws RemoteException;
    List<Student> listStudents() throws RemoteException;
    List<Teacher> listTeachers() throws RemoteException;
    void updateStudentAddress(int studentId, String newAddress) throws RemoteException;
}
