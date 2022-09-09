package ss6_inheritance.bai_tap.circle;

public class Circle {
    protected final float PI = 3.1415f;
    protected float radius;
    protected String color;
public Circle(float radius, String color){
    this.radius = radius;
    this.color = color;
}
    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return Math.pow(radius, 2) * PI;
    }

    public double getPerimeter() {
        return 2 * PI * radius;
    }

    public String toString(){
        return String.format("The circle with radius %f, color %s get area %f and perimeter %f\n",radius,getColor(),getArea(),getPerimeter());

    }
}
