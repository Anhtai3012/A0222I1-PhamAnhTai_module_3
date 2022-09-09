package ss4_oop.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        return this.height * this.width;
    }
    public double getPerimeter(){
        return 2 * (this.width + this.height);
    }
    public String getInfo(){
        return "Rectangle with width " + this.width +" and height " + this.height;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input width: ");
        double width = scanner.nextDouble();
        System.out.print("Input height: ");
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width,height);
        System.out.printf("Area Rectangle: %.2f\n",rectangle.getArea());
        System.out.printf("Perimeter Rectangle: %.2f\n",rectangle.getPerimeter());
        System.out.printf("%s",rectangle.getInfo());
    }
}
