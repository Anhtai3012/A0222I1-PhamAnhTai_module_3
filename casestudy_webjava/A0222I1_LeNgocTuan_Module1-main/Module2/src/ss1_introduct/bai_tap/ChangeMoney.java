package ss1_introduct.bai_tap;

import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        short rate = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Rate Dollar to VND is %d. Input your Dollar: ", rate);
        short money = scanner.nextShort();
        System.out.printf("Your money is %d Dollar. Total VND to exchange is: %d VND", money, money * rate);
    }
}
