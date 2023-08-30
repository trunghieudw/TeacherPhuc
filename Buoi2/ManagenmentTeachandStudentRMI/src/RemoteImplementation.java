import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoteImplementation extends UnicastRemoteObject implements RemoteInterface {
    private List<Student> students;
    private List<Teacher> teachers;

    public RemoteImplementation() throws RemoteException {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) throws RemoteException {
        students.add(student);
    }

    @Override
    public void addTeacher(Teacher teacher) throws RemoteException {
        teachers.add(teacher);
    }

    @Override
    public void deleteStudent(int studentId) throws RemoteException {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == studentId) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public List<Student> listStudents() throws RemoteException {
        return students;
    }

    @Override
    public List<Teacher> listTeachers() throws RemoteException {
        return teachers;
    }

    @Override
    public void updateStudentAddress(int studentId, String newAddress) throws RemoteException {
        for (Student student : students) {
            if (student.getId() == studentId) {
                student.setAddress(newAddress);
                break;
            }
        }
    }
}
