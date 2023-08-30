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