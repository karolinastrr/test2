package zadanie3;

public abstract class Person {
    private String name;
    private String surname;
    private final String pesel;
    private String city;

    public Person(String name, String surname, String pesel, String city) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlec(String pesel) {
        if (pesel == null || pesel.length() != 11) {
            throw new IllegalArgumentException("Invalid data");
        }

        int plecIndex = Character.getNumericValue(pesel.charAt(9));

        if (plecIndex % 2 == 0) {
            return "kobieta";
        } else {
            return "mężczyzna";
        }
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public abstract double getIncome();

    public abstract String getSaveableData();

    //    List<Person> newPeople = new ArrayList();
//    (List<Person> people)

//    Person[] people = new Person[10];
//    (Person[] people)
}
