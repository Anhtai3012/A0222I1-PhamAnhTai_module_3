package ss1_introduct.thuc_hanh;

import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
        Scanner Rectangle = new Scanner(System.in);
        System.out.println("How length you want: ");
        float length = (Rectangle.nextFloat());
        System.out.println("How height you want: ");
        float heigth = Rectangle.nextFloat();
        System.out.printf("Area: %f", length * heigth);
    }
}
