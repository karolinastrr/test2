package zadanie1;

import java.time.LocalDate;
import java.util.List;

public class Child {
    private int id;
    private String gender;
    private String name;
    private LocalDate dateOfBirth;
    private int weight;
    private int height;
    private Mom mom;

    public Child(int id, String gender, String name, LocalDate dateOfBirth, int weight, int height, Mom mom) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
        this.mom = mom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Mom getMom() {
        return mom;
    }

    public boolean isBoy() {
        return gender.equals("s");
    }

    public boolean isGirl() {
        return gender.equals("c");
    }

    public static Child findFirstBoy(List<Child> children) {
        for (Child child : children) {
            if (child.isBoy()) {
                return child;
            }
        }
        throw new IllegalArgumentException("Boy has been not found");
    }

    public static Child findFirstGirl(List<Child> children) {
        for (Child child : children) {
            if (child.isGirl()) {
                return child;
            }
        }
        throw new IllegalArgumentException("Girl has been not found");
    }

    public boolean hasInheritedName() {
        return name.equals(mom.getName());
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
