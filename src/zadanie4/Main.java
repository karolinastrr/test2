package zadanie4;

import zadanie3.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figury = Arrays.asList(Figure.createSquare(10), Figure.createCircle(20), Figure.createRectangle(10,20));
        for(Figure f : figury) {
            System.out.println(f);
        }

        System.out.println(Figure.findFigureWithBiggestPerimeter(figury));
        System.out.println(Figure.findFigureWithBiggestArea(figury));

        System.out.println(figury.contains(new Square(10)));
        saveFiguresToFile(figury);
        System.out.println(loadFiguresFromFile("figury.txt"));

    }

    public static void saveFiguresToFile(List<Figure> figures) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("figury.txt"))) {
            for (Figure figure : figures) {
                bufferedWriter.write(figure.getSaveableData());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Figure> loadFiguresFromFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            List<Figure> loadedFigures = new ArrayList<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] splittedLine = line.split(" ");
                switch (splittedLine[0]) {
                    case "square" :
                        loadedFigures.add(new Square(Integer.parseInt(splittedLine[1])));
                        break;
                    case "circle" :
                        loadedFigures.add(new Circle(Integer.parseInt(splittedLine[1])));
                        break;
                    case "rectangle" :
                        loadedFigures.add(new Rectangle(Integer.parseInt(splittedLine[1]), Integer.parseInt(splittedLine[2])));
                        break;
                }
            }
            return loadedFigures;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
