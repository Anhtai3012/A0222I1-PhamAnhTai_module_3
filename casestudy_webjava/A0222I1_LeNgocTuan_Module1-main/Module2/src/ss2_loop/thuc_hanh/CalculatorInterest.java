package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class CalculatorInterest {
    public static void main(String[] args) {
        float interest = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Money you want to lend: ");
        int money = scanner.nextInt();
        System.out.println("Month you want to lend: ");
        int month = scanner.nextInt();
        System.out.println("Interest Rate % you lend: ");
        float interestRate = scanner.nextFloat();
        for (int i = 0; i < month; i++) {
            interest += (float) money * ((interestRate/100) / 12) * month;
        }
        System.out.printf("Interest: %f ", interest);
    }
}
