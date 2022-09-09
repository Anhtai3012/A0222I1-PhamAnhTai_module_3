package ss2_loop.bai_tap;

import java.util.Scanner;

public class DrawMenu {
    public static void main(String[] args) {
        byte choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 4) {
            System.out.println("Your choice want to draw: ");
            System.out.println("1. Rectangle");
            System.out.println("2. Square triangle");
            System.out.println("3. Isosceles triangle");
            System.out.println("4. Out");
            System.out.print("Your choice: ");
            choice = scanner.nextByte();
            if (choice <= 0) System.out.println("Your choice MUST bigger 0");
            if (choice == 1) {
                StringBuilder rectangle = new StringBuilder();
                System.out.println("Input your height rectangle ");
                byte height = scanner.nextByte();
                System.out.println("Input your width rectangle");
                byte width = scanner.nextByte();
                for (byte i = 0; i < height; i++) {
                    if (i == 0 || i == height - 1) {
                        for (byte j = 0; j < width; j++) {
                            rectangle.append(" * ");
                        }
                    } else {
                        for (byte j = 1; j <= width; j++) {
                            rectangle.append(j == 1 || j == width ? " * " : "   ");
                        }
                    }
                    rectangle.append("\n");
                }
                System.out.println(rectangle);
            } else if (choice == 2) {
                StringBuilder triangle = new StringBuilder();
                System.out.println("Input height in square triangle");
                byte height = scanner.nextByte();
                for (byte i = 0; i < height; i++) {
                    for (byte j = 0; j <= i; j++) {
                        triangle.append(" * ");
                    }
                    triangle.append("\n");
                }
                System.out.println(triangle);
            } else if (choice == 3) {
                StringBuilder triangle = new StringBuilder();
                System.out.println("Input your height in ");
                byte height = scanner.nextByte();
                for (byte i = 1; i <= height; i++) {
                    if (i == height) {
                        for (byte j = 1; j <= 2 * i - 1; j++) {
                            triangle.append(" * ");
                        }
                    } else {
                        for (byte j = 1; j <= 2 * height + 1; j++) {
                            if (j == height - i + 1 || j == height + i - 1) {
                                triangle.append(" * ");
                            } else {
                                triangle.append("   ");
                            }
                        }
                    }
                    triangle.append("\n");
                }
                System.out.println(triangle);
            } else {
                System.out.print("Bye");
                break;
            }
        }
    }
}

