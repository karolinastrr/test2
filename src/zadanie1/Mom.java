package zadanie1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mom {
    private int id;
    private String name;
    private int age;
    private List<Child> children = new ArrayList<>();

    public Mom(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void addChild(Child child) {
        children.add(child);
    }

    public static Mom findMomById(List<Mom> moms, int id) {
        for (Mom mom : moms) {
            if (mom.getId() == id) {
                return mom;
            }
        }
        throw new IllegalArgumentException("Can't find mom with id: " + id);
    }

    public boolean isHerChildOver4000() {
        for (Child child : children) {
            if (child.getWeight() > 4000) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTwins() {
        Map<LocalDate, Integer> birthDates = new HashMap<>();
        for (Child child : children) {
            LocalDate dateOfBirth = child.getDateOfBirth();
            birthDates.put(dateOfBirth, birthDates.getOrDefault(dateOfBirth, 0) + 1);
        }
        for (int count : birthDates.values()) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Mom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", children=" + children +
                '}';
    }
}
