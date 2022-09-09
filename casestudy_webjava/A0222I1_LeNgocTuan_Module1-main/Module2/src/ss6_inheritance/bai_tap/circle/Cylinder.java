package ss6_inheritance.bai_tap.circle;

public class Cylinder extends Circle {
    private float height;

    public Cylinder(float radius, String color, float height) {
        super(radius, color);
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float calculatorVolumeCylinder() {
        return radius * height * super.PI;
    }

    public String toString() {
        return String.format("The cylinder with radius %f, height %f, color %s get area %f, perimeter %f and volume %f\n", radius, height, getColor(), getArea(), getPerimeter(), calculatorVolumeCylinder());
    }
}
