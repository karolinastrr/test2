package zadanie3;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Student> students = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if (student == null || students.contains(student)) {
            throw new IllegalArgumentException("Invalid data");
        }
        students.add(student);
    }

    public static Group findGroupByName(List<Group> groups, String name) {
        for (Group group : groups) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        throw new IllegalArgumentException("Can't find group with name: " + name);
    }

}
