package ss7_abstract_class_interface.thuc_hanh.shape;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Circle[] circles = new Circle[6];
        circles[0] = new Circle();
        circles[1] = new Circle(4.2f);
        circles[2] = new Circle(2f, "red");
        circles[3] = new Circle(2f, "yellow");
        circles[4] = new Circle(4.2f, "azure");
        circles[5] = new Circle(1f, "green");
        System.out.print("NewList before sort\n");
        for (Circle circle : circles) {
            System.out.println(circle.getInfo());
        }
        Arrays.sort(circles);
        System.out.print("NewList after sort:\n");
        for (Circle circle : circles) {
            System.out.println(circle.getInfo());
        }
    }
}
