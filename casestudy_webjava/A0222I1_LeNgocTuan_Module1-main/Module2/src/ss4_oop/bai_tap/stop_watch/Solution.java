package ss4_oop.bai_tap.stop_watch;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        long[] numbs = new long[10000];
        for (int i = 0; i < numbs.length; i++) {
            numbs[i] = (long) ((Math.random() * 100) + 1);
        }
        stopWatch.End();
        System.out.printf("Time to creat array 10000 element random : %d ms\n", stopWatch.getElapsedTime());
        stopWatch.Start();
        Arrays.stream(numbs).sorted().toArray();
        stopWatch.End();
        System.out.printf("Time to sort all element is %d ms\n", stopWatch.getElapsedTime());
    }
}
