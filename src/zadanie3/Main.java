package zadanie3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Group group1 = new Group("Kwiatuszki");
        Group group2 = new Group("Biedronki");

        List<Group> groups = Arrays.asList(group1, group2);

        Person person1 = new Employee("Adam", "Kowalski", "1254379231", "Warsaw", 5000, "Manager");
        Person person2 = new Employee("Alicja", "Laskowska", "76859302861", "Opole", 4000, "Grapgic designer");
        Person person3 = new Employee("Barbara", "Adamska", "67845278923", "Łódź", 7500, "Team Leader");
        Person person4 = new Employee("Iga", "Kwiatkowska", "46532178945", "Warsaw", 5000, "Manager");
        Person person5 = new Student("Kamil", "Sieradzki", "93827364532", "Gdańsk", group1, 1500);
        Person person6 = new Student("Filip", "Loch", "94721649057", "Warsaw", group1, 1200);
        Person person7 = new Student("Maria", "Kwiecińska", "36271904782", "Warsaw", group1, 1200);
        Person person8 = new Student("Adrianna", "Misiewicz", "87847362584", "Warsaw", group2, 1600);
        Person person9 = new Student("Lena", "Orłowska", "89786453863", "Kraków", group2, 1000);
        Person person10 = new Student("Konrad", "Orłowski", "59786453873", "Kraków", group2, 1070);


        Person[] people = {person1, person2, person3, person4, person5, person6, person7, person8, person9, person10};
        List<Person> peopleToSaveInFile = Arrays.asList(people);


        System.out.println(findPersonWithHighestSalary(people));
        savePeopleToFile(peopleToSaveInFile);

        System.out.println();
        System.out.println(loadPeopleFromFile("plik1.txt", groups));
    }

    public static Person findPersonWithHighestSalary(Person[] people) {
        Person personWithHighestSalary = people[0];
        for (Person person : people) {
            if (personWithHighestSalary.getIncome() < person.getIncome()) {
                personWithHighestSalary = person;
            }
        }
        return personWithHighestSalary;
    }

    public static int howManyWomen(Person[] people) {
        int sum = 0;

        for (Person person : people) {
            if (person.getPlec(person.getPesel()).equals("kobieta")) {
                sum++;
            }
        }
        return sum;
    }

    public static void savePeopleToFile(List<Person> people) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("plik1.txt"))) {
            for (Person person : people) {
                bufferedWriter.write(person.getSaveableData());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Person> loadPeopleFromFile(String path, List<Group> groups) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            List<Person> loadedPeople = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splittedLine = line.split(" ");
                switch (splittedLine[0]) {
                    case "student":
                        Group group = Group.findGroupByName(groups, splittedLine[5]);
                        loadedPeople.add(new Student(splittedLine[1], splittedLine[2], splittedLine[3], splittedLine[4], group, Double.parseDouble(splittedLine[6])));
                        break;
                    case "employee":
                        loadedPeople.add(new Employee(splittedLine[1], splittedLine[2], splittedLine[3], splittedLine[4], Double.parseDouble(splittedLine[5]), splittedLine[6]));
                        break;
                }
            }
            return loadedPeople;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
