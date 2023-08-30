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