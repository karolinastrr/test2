package zadanie4;

public class Circle extends Figure {
    private int radius;

    public Circle(int radius, int id) {
        this.radius = radius;
        this.id = id;
    }

    public Circle(int radius) {
        this.radius = radius;
        id = 0;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.pow(Math.PI * radius, 2.0);
    }

    @Override
    public String getSaveableData() {
        return "circle " + getRadius() + "\n";
    }

    @Override
    public String toString() {
        return "Figura nr " + id + ": Koło o promieniu " + radius;
    }
}
