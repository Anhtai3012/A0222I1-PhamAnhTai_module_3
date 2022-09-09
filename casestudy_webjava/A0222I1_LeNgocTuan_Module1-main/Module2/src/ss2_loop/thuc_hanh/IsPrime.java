package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        boolean flg = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your number you want to check is Prime Number: ");
        short number = scanner.nextShort();
        if (number <= 1) {
            System.out.printf("%d NOT a prime number", number);
        } else if (number == 2) {
            System.out.printf("%d is prime number", number);
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    System.out.printf("%d NOT a prime number", number);
                    flg = false;
                    break;
                }
            }
            if (flg) {
                System.out.printf("%d a prime number", number);
            }
        }
    }
}
