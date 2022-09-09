package ss7_abstract_class_interface.bai_tap.color;

public class Square extends Shape implements Colorable {
    private double width = 2;
    private String color = "azure";

    public Square() {
    }

    public Square(double width, String color) {
        this.width = width;
        this.color = color;
    }

    @Override
    public void howToColor() {
        System.out.printf("Square width %.2f color %s\n", width, color);
    }
}
