package zadanie3;

public class Employee extends Person {
    private double salary;
    private String position;

    public Employee(String name, String surname, String pesel, String city, double salary, String position) {
        super(name, surname, pesel, city);
        this.salary = salary;
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                getName() + " " + getSurname() + " " +
                "salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public double getIncome() {
        return salary;
    }

    @Override
    public String getSaveableData() {
        return getName() + " " + getSurname() + " " + getPesel() + " " + getCity() + " " + getSalary() + " " + getPosition() + "\n";
    }
}
