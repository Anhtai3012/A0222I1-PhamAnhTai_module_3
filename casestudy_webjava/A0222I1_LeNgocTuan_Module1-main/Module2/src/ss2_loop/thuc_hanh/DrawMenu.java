package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class DrawMenu {
    public static void main(String[] args) {
        byte choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 4) {
            System.out.println("Your choice want to draw: ");
            System.out.println("1. Triangle");
            System.out.println("2. Square");
            System.out.println("3. Rectangle");
            System.out.println("4. Out");
            choice = scanner.nextByte();
            if (choice < 0) System.out.println("choice MUST bigger 0");
            switch (choice) {
                case 1:
                    System.out.println("You choice draw triangle");
                    break;
                case 2:
                    System.out.println("You choice draw square");
                    break;
                case 3:
                    System.out.println("You choice draw rectangle");
                    break;
                case 4:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Wrong type choice.");
                    System.exit(4);
            }
            ;

        }
    }
}
