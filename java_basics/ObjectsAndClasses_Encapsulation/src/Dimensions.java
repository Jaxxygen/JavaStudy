public class Dimensions {


    private final double length;
    private final double heigh;
    private final double width;
    private double volume;

    public Dimensions(double length, double heigh, double width) {
        this.length = length;
        this.heigh = heigh;
        this.width = width;
        volume = length * heigh * width;
    }

    public double getLength() {
        return length;
    }

    public double getHeigh() {
        return heigh;
    }

    public double getWidth() {
        return width;
    }

    public Dimensions setLength(double length) {
        return new Dimensions(length, heigh, width);
    }

    public Dimensions setHeigh(double heigh) {
        return new Dimensions(length, heigh, width);
    }

    public Dimensions setWidth(double width) {
        return new Dimensions(length, heigh, width);
    }

    public String toString() {
        return "Длинна: " + length + "\n" +
                "Высота: " + heigh + "\n" +
                "Ширина: " + width + "\n" +
                "Объем: " + volume + "\n";
    }
}
