package ss3_array.thuc_hanh;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        byte lens;
        String ans = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input your length: ");
            lens = scanner.nextByte();
            if (lens <= 20) break;
        }
        byte[] numbers = new byte[lens];
        for (byte i = 0; i < lens; i++) {
            System.out.printf("Input element with index %d: ", i);
            numbers[i] = scanner.nextByte();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int j = 0; j < numbers.length; j++) {
            System.out.print(numbers[j] + "\t");
        }
        for (int j = 0; j < lens / 2; j++) {
            byte temp = numbers[j];
            numbers[j] = numbers[lens - 1 - j];
            numbers[lens - 1 - j] = temp;
        }
        System.out.printf("\n%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < lens; j++) {
            System.out.print(numbers[j] + "\t");
        }
    }
}
