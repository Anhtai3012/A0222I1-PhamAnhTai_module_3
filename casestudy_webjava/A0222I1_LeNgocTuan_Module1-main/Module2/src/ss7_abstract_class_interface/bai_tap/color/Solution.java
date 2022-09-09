package ss7_abstract_class_interface.bai_tap.color;

public class Solution {
    public static void main(String[] args) {
       Shape[] shapes = new Shape[5];
       shapes[0] = new Square(1,"green");
       shapes[1] = new Square();
       shapes[2] = new SquareOrigin();
       shapes[3] = new SquareOrigin(1,"black");
       shapes[4] = new Square(2,"purple");
        for (Shape shape : shapes) {
            if(shape instanceof Colorable){
                ((Colorable) shape).howToColor();
            }
        }
    }
}
