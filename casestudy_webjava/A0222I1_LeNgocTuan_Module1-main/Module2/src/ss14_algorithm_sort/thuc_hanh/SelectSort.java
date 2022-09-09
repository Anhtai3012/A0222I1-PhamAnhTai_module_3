package ss14.algorithm_sort.thuc_hanh;

import java.util.Arrays;

public class SelectSort {
    public static int[] sortSelect(int[] numbs){
        int n = numbs.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (numbs[j] < numbs[minIndex])
                    minIndex = j;
            int temp = numbs[minIndex];
            numbs[minIndex] = numbs[i];
            numbs[i] = temp;
        }
        return numbs;
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sortSelect(arr)));
    }
}

