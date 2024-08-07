package zadanie1;

public class HighestBoyInfo {

    private String name;
    private int height;

    public HighestBoyInfo(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "HighestBoyInfo{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
