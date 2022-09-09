package ss3_array.thuc_hanh;

import java.util.Scanner;

public class ConverterCelsius {
    public static double converterFToC(double number) {
        return (5.0f / 9.0f) * (number - 32);
    }

    public static double converterCToF(double number) {
        return number * (9.0f / 5.0f) + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte choice = -1;
        while (true) {
            System.out.println("Your have 3 choice: ");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("3. Quit.");
            System.out.print("Your choice: ");
            choice = scanner.nextByte();
            if (choice == 1) {
                System.out.print("Input temp: ");
                double temp = scanner.nextDouble();
                System.out.printf("%.2f Fahrenheit to %.2f Celsius", temp, converterFToC(temp));
                break;
            } else if (choice == 2) {
                System.out.print("Input temp: ");
                double temp = scanner.nextDouble();
                System.out.printf("%.2f Celsius to %.2f Fahrenheit", temp, converterCToF(temp));
                break;
            } else {
                break;
            }
        }
    }
}
