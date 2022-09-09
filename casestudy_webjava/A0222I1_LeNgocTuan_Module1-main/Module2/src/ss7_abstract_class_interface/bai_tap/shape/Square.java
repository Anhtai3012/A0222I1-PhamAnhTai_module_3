package ss7_abstract_class_interface.bai_tap.shape;

public class Square extends Shape implements Resizeable {
    private double width = 1;
    private String color = "black";

    public Square() {
    }

    public Square(double width, String color) {
        this.width = width;
        this.color = color;
    }

    @Override
    public void resize() {
        double resize = randomPercent();
        System.out.printf("New Area of Square: %.2f with resize %.2f %%\n", getArea() * resize, resize*100);
    }


    @Override
    public double randomPercent() {
        return (Math.random() * 100) / 100d;
    }

    @Override
    public void getInfo() {
        System.out.printf("Square width: %.2f, color %s has area %.2f, perimeter %.2f\n", width, color, getArea(), getPerimeter());
    }

    @Override
    public double getArea() {
        return Math.pow(width, 2);
    }

    @Override
    public double getPerimeter() {
        return 4 * width;
    }
}
