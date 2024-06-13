package zadanie4;

import java.util.List;

public abstract class Figure {
    protected static int nextId = 1;
    protected int id;


    public static Figure createSquare(int side) {
        return new Square(side, nextId++);
    }

    public static Figure createCircle(int radius) {
        return new Circle(radius, nextId++);
    }

    public static Figure createRectangle(int sideA, int sideB) {
        return new Rectangle(sideA, sideB, nextId++);
    }

    public abstract double getPerimeter();
    public abstract double getArea();
    public abstract String getSaveableData();


    public static Figure findFigureWithBiggestPerimeter(List<Figure> figures) {
        Figure figureTiwhBiggestPerimeter = figures.get(0);

        for (Figure figure : figures) {
            if (figure.getPerimeter() > figureTiwhBiggestPerimeter.getPerimeter()) {
                figureTiwhBiggestPerimeter = figure;
            }
        }
        return figureTiwhBiggestPerimeter;
    }

    public static Figure findFigureWithBiggestArea(List<Figure> figures) {
        Figure figureTiwhBiggestArea = figures.get(0);

        for (Figure figure : figures) {
            if (figure.getArea() > figureTiwhBiggestArea.getArea()) {
                figureTiwhBiggestArea = figure;
            }
        }
        return figureTiwhBiggestArea;
    }


}
