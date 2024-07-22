package zadanie1;

public class HighestGirlInfo {

    private String name;
    private int height;

    public HighestGirlInfo(String name, int height) {
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
        return "HighestGirlInfo{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
