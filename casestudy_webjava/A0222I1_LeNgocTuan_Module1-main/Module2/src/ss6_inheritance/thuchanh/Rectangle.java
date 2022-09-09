package ss6_inheritance.thuchanh;

public class Rectangle extends Geometric {
    private double width;
    private double height;

    public Rectangle() {

    }

    public Rectangle(double width, double height, String color, String filler) {
        this.width = width;
        this.height = height;
        setColor(color);
        setFiller(filler);
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}

