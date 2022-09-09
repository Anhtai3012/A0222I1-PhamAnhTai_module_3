package ss13_algorithm_search.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class TreeWithRecursive {
    public static int findValue(int[] numbers, int left, int right, int value) {
        Arrays.sort(numbers);
        int mid = (left + right) / 2;
        if (numbers[mid] == value) return mid;
        if (value > numbers[mid]) return findValue(numbers, mid - 1, right, value);
        if (value < numbers[mid]) return findValue(numbers, left, mid + 1, value);
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {55, 22, 11, 54, 21, 65, 86, 12, 53, 26, 33, 1, 59, 70};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Value want search: ");
        int value = Integer.parseInt(scanner.nextLine());
        Arrays.sort(numbers);
        System.out.printf("List : %s\n", Arrays.toString(numbers));
        System.out.printf("index %d of value %d", findValue(numbers, 0, numbers.length - 1, value), value);
    }
}
