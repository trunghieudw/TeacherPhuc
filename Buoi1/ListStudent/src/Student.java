class Student {
    String name;
    String gender;

    public Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender;
    }
}   