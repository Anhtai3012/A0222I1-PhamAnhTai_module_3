package ss7_abstract_class_interface.bai_tap.shape;

public class Solution {
    public static void main(String[] args) {
        Shape[] library = new Shape[6];
        library[0] = new Circle();
        library[1] = new Circle(4.2, "purple");
        library[2] = new Square();
        library[3] = new Square(2.4, "green");
        library[4] = new Rectangle();
        library[5] = new Rectangle(5.2, 4.2, "orange");
        Square square = new Square(5.2,"black");
        for (Shape shape: library) {
            shape.getInfo();
            shape.resize();
        }
        System.out.println("Resize with interface: ");
        square.getInfo();
        square.resize();
    }
}
