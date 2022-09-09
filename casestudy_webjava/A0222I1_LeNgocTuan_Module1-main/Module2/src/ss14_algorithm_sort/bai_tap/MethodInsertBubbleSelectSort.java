package ss14_algorithm_sort.bai_tap;

import java.util.Arrays;

public class MethodInsertBubbleSelectSort {
    public static int[] sortSelect(int[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public static int[] sortBubble(int[] arr) {
        int tempe;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tempe = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempe;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }

    public static int[] sortInsert(int[] arr) {
        int value;
        int currentPosition;
        for (int i = 1; i < arr.length; i++) {
            value = arr[i];
            currentPosition = i;
            while (currentPosition > 0 && arr[currentPosition - 1] > value) {
                arr[currentPosition] = arr[currentPosition - 1];
                currentPosition--;
            }
            if (currentPosition != i) {
                arr[currentPosition] = value;
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] numbs = {-2, 1, 5, 7, 3, 9, -1, -6, 0, 1};
        System.out.println(Arrays.toString(numbs));
        System.out.println("Select Sort: " + Arrays.toString(sortSelect(numbs)));
        System.out.println("Bubble Sort: " + Arrays.toString(sortBubble(numbs)));
        System.out.println("Insert Sort: " + Arrays.toString(sortInsert(numbs)));
    }
}
