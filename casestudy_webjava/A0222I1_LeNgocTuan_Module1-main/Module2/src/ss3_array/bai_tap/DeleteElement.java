package ss3_array.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
    public static int searchTarget(int[] numbs, int target) {
        for (int i = 0; i < numbs.length; i++) {
            if (numbs[i] == target) return i;
        }
        return -1;
    }

    public static int[] deleteElementArrayByValue(final int[] arr, int value) {
        int len = arr.length;
        if (len == 0) return arr;
        int idx = searchTarget(arr, value);
        if (idx == -1) return arr;
        int[] result = new int[len - 1];
        for (int i = 0; i < len; i++) {
            if (i < idx) result[i] = arr[i];
            if (i > idx) result[i - 1] = arr[i];
        }
        return result;
    }

    public static String displayNumber(int[] numbers) {
        String result = "NewList Number: ";
        for (int i : numbers) {
            result += i + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        int lens;
        int[] numbers;
        int target;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input your length: ");
            lens = scanner.nextInt();
            if (lens > 1) break;
        }

        numbers = new int[lens];
        for (byte i = 0; i < lens; i++) {
            System.out.printf("Input element %d: ", i);
            numbers[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(numbers));
        System.out.print("input number want delete: ");
        target = scanner.nextInt();
        int[] result = deleteElementArrayByValue(numbers, target);

        System.out.println(Arrays.toString(result));
    }
}

