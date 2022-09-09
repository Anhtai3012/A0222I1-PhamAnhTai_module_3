package ss14.algorithm_sort.thuc_hanh;

import java.util.Arrays;

public class MethodBubbleSort {
    public static int[] insertionSort(int[] numbers) {
        Arrays.sort(numbers);
        int position = 0;
        int value = 0;

        for (int i = 0; i < numbers.length; i++) {
            position = i;
            value = numbers[i];
            while (position > 0 && value < numbers[i - 1]) {
                numbers[i] = numbers[i - 1];
                position--;
            }
            numbers[position] = value;
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 1, 4, 2, 8};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(insertionSort(numbers)));
    }
}
