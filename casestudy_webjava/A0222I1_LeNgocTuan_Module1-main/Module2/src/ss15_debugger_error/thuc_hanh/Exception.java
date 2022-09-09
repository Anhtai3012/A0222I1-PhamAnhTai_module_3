package ss15_debugger_error.thuc_hanh;

import java.util.Scanner;

public class Exception {
    public static void calculatorAB(int a, int b, char calculator) {
        if (a == 0 && b == 0) {
            System.err.print("a , b can't not equal 0\n");
            return;
        }
        if (b == 0) {
            System.err.print("b can't not equal 0\n");
            return;
        }
        switch (calculator) {
            case '+':
                System.out.printf("addition %d ",a + b);
                break;
            case '-':
                System.out.printf("subtraction %d ",a - b);
                break;

            case '*':
                System.out.printf("multiplication %d ",a * b);
                break;
            case '/':
                System.out.printf("division %d ",a / b);
                break;
            default:
                System.err.printf("calculator MUST +, -, *, /. NOT %s", calculator);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.print("Input b: ");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.print("calculator with a,b: ");
        char calculator = scanner.nextLine().charAt(0);
        calculatorAB(a, b, calculator);
    }
}
