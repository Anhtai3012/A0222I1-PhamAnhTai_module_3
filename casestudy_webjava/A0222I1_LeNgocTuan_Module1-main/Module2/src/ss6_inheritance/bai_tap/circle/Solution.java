package ss6_inheritance.bai_tap.circle;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input radius: ");
        float radius = Float.parseFloat(scanner.nextLine());
        System.out.print("Input color: ");
        String color = scanner.nextLine();
        Circle circle = new Circle(radius, color);
        System.out.println(circle.toString());
        System.out.print("Input height: ");
        float height = scanner.nextFloat();
        Cylinder cylinder = new Cylinder(radius, color, height);
        System.out.printf("Volume: %f\n",cylinder.calculatorVolumeCylinder());
        System.out.print(cylinder.toString());
    }
}
