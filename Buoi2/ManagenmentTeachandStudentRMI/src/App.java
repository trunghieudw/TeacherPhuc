import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
       List<Human> people = new ArrayList<>();
       Scanner scanner = new Scanner(System.in);
       int choice;

       do {
        System.out.println("1. Them sinh vien va giao vien");
        System.out.println("2. Xoa 1 sinh vien");
        System.out.println("3. Liet ke danh sach sinh vien va giao vien");
        System.out.println("4. Liet ke danh sach sinh vien ");
        System.out.println("5. Cap nhat dia chi sinh vien1");
        System.out.println("6. Thoat");
        System.out.print("Lua chon cua ban: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // Thêm sinh viên và giáo viên vào danh sách
                people.add(new Student("S001", "Nguyen", "Hieu", "123 HCM", "Male", "CNTT"));
                people.add(new Student("S002", "Le", "Hieu", "456 Le Duc Tho", "Male", "CNTT"));
                people.add(new Student("S003", "Truong", "Tam", "1053 Le Duc Tho", "Male", "CNTT"));

                people.add(new Teacher("T001", "Truong", "Phuc", "IUH", "Male", "Thac Si"));
                people.add(new Teacher("T002", "Nguyen", "Quang", "IUH", "Male", "Thac Si"));
                break;
            case 2:
                // Xoá một sinh viên
                Iterator<Human> iterator = people.iterator();
                while (iterator.hasNext()) {
                    Human person = iterator.next();
                    if (person instanceof Student && person.id.equals("S002")) {
                        iterator.remove();
                    }
                }
                break;
            case 3:
                // Liệt kê danh sách sinh viên và giáo viên
                for (Human person : people) {
                    person.displayInfo();
                }
                break;
            case 4:
                // Liệt kê danh sách sinh viên
                System.out.println("List of Students:");
                for (Human person : people) {
                    if (person instanceof Student) {
                        person.displayInfo();
                    }
                }
                break;
            case 5:
                // Cập nhật địa chỉ của sinh viên
                for (Human person : people) {
                    if (person instanceof Student && person.id.equals("S001")) {
                        ((Student) person).address = "Ha Noi";
                        person.displayInfo();
                    }
                }
                break;
            case 6:
                System.out.println("Thoat chuong trinh...");
                break;
            default:
                System.out.println("Khong co chuc nang nay. Vui long chon lai");
        }
        System.out.println();
    } while (choice != 6);
    scanner.close();
    }
}
