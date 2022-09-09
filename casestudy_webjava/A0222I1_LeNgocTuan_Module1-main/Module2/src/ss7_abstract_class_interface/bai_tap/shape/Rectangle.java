package ss7_abstract_class_interface.bai_tap.shape;

public class Rectangle extends Shape implements Resizeable {
    private double height = 2;
    private double width = 1;
    private String color = "azure";

    public Rectangle() {
    }

    public Rectangle(double height, double width, String color) {
        this.height = height;
        this.width = width;
        this.color = color;
    }

    @Override
    public void resize() {
        double resize = randomPercent();
        System.out.printf("New Area of Rectangle: %.2f with resize %.2f %%\n", getArea() * resize, resize * 100);
    }


    @Override
    public double randomPercent() {
        return (Math.random() * 100) / 100d;
    }

    @Override
    public void getInfo() {
        System.out.printf("Rectangle width: %.2f, height: %.2f, color %s has area %.2f, perimeter %.2f\n", width, height, color, getArea(), getPerimeter());
    }

    @Override
    public double getArea() {
        return (this.width * this.height);
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }
}
