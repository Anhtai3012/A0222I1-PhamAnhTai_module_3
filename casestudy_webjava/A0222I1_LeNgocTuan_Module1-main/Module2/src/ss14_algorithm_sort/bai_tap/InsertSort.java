package ss14_algorithm_sort.bai_tap;

import java.util.Arrays;

public class InsertSort {
    public static int[] insertionSort(int[] numbers) {
        int length = numbers.length;
        for (int i = 1; i < length; ++i) {
            int value = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > value) {
                numbers[j + 1] = numbers[j];
                j = j - 1;
            }
            numbers[j + 1] = value;
        }
        return  numbers;
    }

    public static void main(String[] args) {
        int[] numbers = {42, 51, 11, 25, 64, 25, 32, 15, 93, 85, 77, 21, 60};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(insertionSort(numbers)));
    }
}
