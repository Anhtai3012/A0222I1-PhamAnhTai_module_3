package ss3_array.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class MinInNumbers {
    public static int findMinInNumbers(int[] number) {
        return Arrays.stream(number).min().getAsInt();
    }

    public static void main(String[] args) {
        int lens;
        Scanner scanner = new Scanner(System.in);
        while(true){
        System.out.print("Input your lens: ");
        lens = scanner.nextInt();
        if( lens > 1) break;
        }
        int[] numbers = new int[lens];
        for(int i = 0; i< lens; i++){
            System.out.printf("Input element %d: ",i);
            numbers[i] = scanner.nextInt();
        }
        System.out.print("NewList number: ");
        for(int i : numbers){
            System.out.printf("%d\t",i);
        }
        System.out.printf("With min: %d", findMinInNumbers(numbers));
    }
}
