package ss15_debugger_error.thuc_hanh;

import java.util.Scanner;

public class EquationResolver {
    public static void main(String[] args) {double x;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("ax + b = 0\nInput a: ");
            double a = Integer.parseInt(scanner.nextLine());
            if (a == 0) {
                System.out.println("a != 0");
                continue;
            }
            System.out.print("Input b: ");
            double b = Integer.parseInt(scanner.nextLine());
            x = - b / a;
            break;
        }
        System.out.println("x: " + x);
    }
}
