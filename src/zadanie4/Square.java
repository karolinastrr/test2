package zadanie4;

import java.util.Objects;

public class Square extends Figure {
    private int sideLength;

    public Square(int sideLength, int id) {
        this.sideLength = sideLength;
        this.id = id;
    }

    public Square(int sideLength) {
        this.sideLength = sideLength;
        id = 0;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public String getSaveableData() {
        return "square " + getSideLength() + "\n";
    }

    @Override
    public String toString() {
        return "Figura nr " + id + ": Kwadrat o boku " + sideLength;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Square square = (Square) obj;
        return sideLength == square.sideLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideLength);
    }


}
