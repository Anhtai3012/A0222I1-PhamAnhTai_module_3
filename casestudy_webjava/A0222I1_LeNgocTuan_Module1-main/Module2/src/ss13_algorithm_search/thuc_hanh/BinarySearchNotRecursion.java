package ss13_algorithm_search.thuc_hanh;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Arrays;

public class BinarySearchNotRecursion {
    public static int searchBinarySearch(int[] list, int value) {
        Arrays.sort(list);
        int tail = 0;
        int head = list.length - 1;
        while (head >= tail) {
            int current = (tail + head) / 2;
            if (value < list[current])
                head = current - 1;
            else if (value == list[current])
                return current;
            else
                tail = current + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {41, 28, 34, 14, 5, 86, 17, 8, 39, 12, 15, 22};
        Arrays.sort(list);
        System.out.printf("List %s\n", Arrays.toString(list));
        long start = LocalDateTime.now()
                .toInstant(OffsetDateTime.now().getOffset())
                .toEpochMilli();
        System.out.println(searchBinarySearch(list, 14));
        System.out.println(searchBinarySearch(list, 22));
        System.out.println(searchBinarySearch(list, 41));
        long end = LocalDateTime.now()
                .toInstant(OffsetDateTime.now().getOffset())
                .toEpochMilli();
        System.out.println(end - start + " minutes seconds");
    }
}
