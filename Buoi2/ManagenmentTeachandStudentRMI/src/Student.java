class Student extends Human {
    private String majors;

    public Student(String i, String firstName, String lastName, String address, String sex, String majors) {
        super(i, firstName, lastName, address, sex);
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

    public int getId() {
        return 0;
    }

    public void setAddress(String newAddress) {
    }

    public String getFirstName() {
        return null;
    }

    public String getAddress() {
        return null;
    }
}