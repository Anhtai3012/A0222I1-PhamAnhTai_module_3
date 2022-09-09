package ss15_debugger_error.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayIndexOutOfBoundsException {
    public static int randomValue(int max, int min) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void main(String[] args) {
        int lens = 100;
        int[] arr = new int[lens];
        for (int i = 0; i < lens; i++) {
            arr[i] = randomValue(lens, 1);
        }
        System.out.println(Arrays.toString(arr));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input index: ");
        int index = Integer.parseInt(scanner.nextLine());
        if (index < 0 || index >= 100){
            throw new java.lang.ArrayIndexOutOfBoundsException(String.format("Index %s NOT in length 0 -> %s",index,lens));
        }
        for (int i = 0; i < lens; i++) {
            if(i == index){
                System.out.printf("Value %d in index %d",arr[i],i);
            }
        }
    }
}
