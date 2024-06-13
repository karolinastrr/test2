package zadanie1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Mom> loadedMoms = loadMomsFromFile("mamy.txt");
        List<Child> loadedChildren = loadChildrenFromFile("noworodki.txt", loadedMoms);
        System.out.println(findTheHighestBoy(loadedChildren));
        System.out.println(findTheHighestGirl(loadedChildren));
        System.out.println(dayWithMostBirths(loadedChildren));
        System.out.println(findMomBelow25WithChildOver4000(loadedMoms));
        System.out.println(findGirlsThatInheritedNameFromMom(loadedChildren));
        System.out.println(findMomsWithTwins(loadedMoms));
        
    }
    public static List<Mom> loadMomsFromFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            List<Mom> momsFromFile = new ArrayList<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] splitedLine = line.split(" ");
               momsFromFile.add(new Mom(Integer.parseInt(splitedLine[0]), splitedLine[1], Integer.parseInt(splitedLine[2])));
            }

            return momsFromFile;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Child> loadChildrenFromFile(String path, List<Mom> moms) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            List<Child> childrenFromFile = new ArrayList<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] splitedLine = line.split(" ");
                Mom foundMom = Mom.findMomById(moms, Integer.parseInt(splitedLine[6]));
                Child child = new Child(Integer.parseInt(splitedLine[0]), splitedLine[1], splitedLine[2],
                        LocalDate.parse(splitedLine[3]), Integer.parseInt(splitedLine[4]), Integer.parseInt(splitedLine[5]), foundMom);
                foundMom.addChild(child);
                childrenFromFile.add(child);

            }
            return childrenFromFile;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String findTheHighestBoy(List<Child> children) {
        Child highestBoy = Child.findFirstBoy(children);
        for (Child child : children) {
            if (child.isBoy() && child.getHeight() > highestBoy.getHeight()) {
                highestBoy = child;
            }
        }
        return highestBoy.getName() + " " + highestBoy.getHeight();
    }

    public static String findTheHighestGirl(List<Child> children) {
        Child highestGirl = Child.findFirstGirl(children);
        for (Child child : children) {
            if (child.isGirl() && child.getHeight() > highestGirl.getHeight()) {
                highestGirl = child;
            }
        }
        return highestGirl.getName() + " " + highestGirl.getHeight();
    }

    public static DayOfWeek dayWithMostBirths(List<Child> children) {
        EnumMap<DayOfWeek, Integer> birthDayCounts = new EnumMap<>(DayOfWeek.class);
        for (DayOfWeek day : DayOfWeek.values()) {
            birthDayCounts.put(day, 0);
        }
        for (Child child : children) {
            LocalDate dob = child.getDateOfBirth();
            DayOfWeek dayOfWeek = dob.getDayOfWeek();
            birthDayCounts.put(dayOfWeek, birthDayCounts.get(dayOfWeek) + 1);
        }

        DayOfWeek mostBirthsDay = null;
        int maxBirths = 0;
        for (DayOfWeek day : DayOfWeek.values()) {
            int count = birthDayCounts.get(day);
            if (count > maxBirths) {
                maxBirths = count;
                mostBirthsDay = day;
            }
        }
        return mostBirthsDay;
    }

    public static String findMomBelow25WithChildOver4000(List<Mom> moms) {
        if (moms == null) {
            throw new IllegalArgumentException("No data in provided list");
        }
        List<String> foundMoms = new ArrayList<>();
        for (Mom mom : moms) {
            if (mom.getAge() > 25 && mom.isHerChildOver4000()) {
                foundMoms.add(mom.getName());
            }
        }
        return foundMoms.toString();
    }

    public static Map<String, LocalDate> findGirlsThatInheritedNameFromMom(List<Child> children) {
        Map<String, LocalDate> childrenWithInheritedNames = new HashMap<>();
        for (Child child : children) {
            if (child.isGirl() && child.hasInheritedName()) {
                childrenWithInheritedNames.put(child.getName(), child.getDateOfBirth());
            }
        }
        return childrenWithInheritedNames;
    }

    public static List<Mom> findMomsWithTwins(List<Mom> moms) {
        List<Mom> momsWithTwins = new ArrayList<>();
        for (Mom mom : moms) {
            if (mom.hasTwins()) {
                momsWithTwins.add(mom);
            }
        }
        return momsWithTwins;
    }
}
