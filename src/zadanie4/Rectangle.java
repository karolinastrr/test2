package zadanie4;

public class Rectangle extends Figure {
    private int sideALength;
    private int sideBLength;

    public Rectangle(int sideALength, int sideBLength, int id) {
        this.sideALength = sideALength;
        this.sideBLength = sideBLength;
        this.id = id;
    }

    public Rectangle(int sideALength, int sideBLength) {
        this.sideALength = sideALength;
        this.sideBLength = sideBLength;
        id = 0;
    }

    public int getSideALength() {
        return sideALength;
    }

    public void setSideALength(int sideALength) {
        this.sideALength = sideALength;
    }

    public int getSideBLength() {
        return sideBLength;
    }

    public void setSideBLength(int sideBLength) {
        this.sideBLength = sideBLength;
    }

    @Override
    public double getPerimeter() {
        return 2 * sideALength + 2 * sideBLength;
    }

    @Override
    public double getArea() {
        return sideALength * sideBLength;
    }

    @Override
    public String getSaveableData() {
        return "rectangle " + getSideALength() + " " + getSideBLength() + "\n";
    }

    @Override
    public String toString() {
        return "Figura nr " + id + ": Prostokat o bokach " + sideALength + "x" + sideBLength;
    }
}
