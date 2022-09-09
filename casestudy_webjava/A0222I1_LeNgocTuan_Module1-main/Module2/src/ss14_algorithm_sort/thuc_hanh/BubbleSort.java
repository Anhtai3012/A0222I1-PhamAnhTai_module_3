package ss14.algorithm_sort.thuc_hanh;

import java.util.Arrays;

public class BubbleSort {
    public static int[] sortBubble(int[] numbs) {
        Arrays.sort(numbs);
        int length = numbs.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (numbs[j] > numbs[j + 1]) {
                    int temp = numbs[j];
                    numbs[j] = numbs[j + 1];
                    numbs[j + 1] = temp;
                }
            }
        }
        return numbs;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(sortBubble(numbers)));
    }
}
