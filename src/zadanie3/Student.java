package zadanie3;

public class Student extends Person {
    private Group group;
    private double scholarship;

    public Student(String name, String surname, String pesel, String city, Group group, double scholarship) {
        super(name, surname, pesel, city);
        this.group = group;
        this.scholarship = scholarship;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public double getScholarship() {
        return scholarship;
    }

    public void setScholarship(double scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public String toString() {
        return "Student{" +
                getName() + " " + getSurname() + " " +
                "group=" + group +
                ", scholarship=" + scholarship +
                '}';
    }

    @Override
    public double getIncome() {
        return scholarship;
    }

    @Override
    public String getSaveableData() {
        return getName() + " " + getSurname() + " " + getPesel() + " " + getCity() + " " + getGroup().getName() + " " + getScholarship() + "\n";
    }
}
