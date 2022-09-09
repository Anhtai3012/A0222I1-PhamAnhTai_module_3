package ss6_inheritance.bai_tap.shape;

public class Solution {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(7f,8f,9f);
        System.out.println(triangle.toString());
        TriangleColorLine triangleColorLine = new TriangleColorLine(4f,4f,4f);
        triangleColorLine.setColor1("red");
        triangleColorLine.setColor2("green");
        triangleColorLine.setColor3("yellow");
        System.out.println(triangleColorLine.toString());
    }
}
