package ss6_inheritance.thuchanh;

public class Solution {
    public static void main(String[] args) {
        Geometric geometric = new Geometric("yellow", "Black");
        Circle circle = new Circle(4.2, "red", "green");
        Rectangle rectangle = new Rectangle(5.5, 3.4, "azure", "purple");
        rectangle.toStringGeometric();
        circle.toStringCircle();
        geometric.toStringGeometric();
    }
}
