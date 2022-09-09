package ss7_abstract_class_interface.thuc_hanh.shape;

public class Circle implements Comparable, java.lang.Comparable<Circle> {
    private float radius = 1f;
    private String color = "blue";
    final double PI = 3.1415d;

    public Circle() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    public Circle(float radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public float getRadius() {
        return radius;
    }


    public void setRadius(float radius) {
        this.radius = radius;
    }


    @Override
    public int compareTo(Circle circle) {
        if (getRadius() >= circle.getRadius()) {
            return 1;
        } else if (getRadius() < circle.getRadius()) {
            return -1;
        } else if (getColor().compareTo(circle.getColor()) >= 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2) * PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String getInfo() {
        return String.format("Circle with radius %f, color %s have area %f, perimeter %f", radius, color, getArea(), getPerimeter());
    }
}
