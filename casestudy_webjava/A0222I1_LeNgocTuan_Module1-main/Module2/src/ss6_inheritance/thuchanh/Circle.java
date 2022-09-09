package ss6_inheritance.thuchanh;

public class Circle extends Geometric {
    private double radius;
    final public double PI = 3.1415;

    public Circle() {

    }

    public Circle(double radius, String color, String filler) {
        this.radius = radius;
        setColor(color);
        setFiller(filler);
    }

    public double getDiameter() {
        return 2 + radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.pow(radius, 2) * PI;
    }

    public double getPerimeter() {
        return 2 * PI * radius;
    }

    public void toStringCircle() {
        System.out.printf("Circle has radius %f get Area %f Perimeter %f\n", radius, getArea(), getPerimeter());

    }

}
