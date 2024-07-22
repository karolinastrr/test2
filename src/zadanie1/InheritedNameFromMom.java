package zadanie1;

import java.time.LocalDate;

public class InheritedNameFromMom {

    private String name;
    private LocalDate dateOfBirth;

    public InheritedNameFromMom(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "InheritedNameFromMom{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
