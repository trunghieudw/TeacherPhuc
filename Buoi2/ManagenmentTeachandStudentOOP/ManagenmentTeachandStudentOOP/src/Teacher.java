class Teacher extends Human {
    private String degree;

    public Teacher(String id, String firstName, String lastName, String address, String sex, String degree) {
        super(id, firstName, lastName, address, sex);
        this.degree = degree;
    }

    @Override
    public void displayInfo() {
        System.out.println("Teacher Info:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("Sex: " + sex);
        System.out.println("Degree: " + degree);
        System.out.println();
    }
}