package ss3_array.bai_tap;

import java.util.Arrays;

public class CountStudent {
    public static String displayNumbs(int[] nums) {
        String ans = "";
        for (int i : nums) {
            ans += i + " ";
        }
        return ans;
    }

    public static int countStudentPass(int[] nums) {
        return Arrays.stream(nums).filter((x) -> x > 5).toArray().length;
    }

    public static void main(String[] args) {
        int lens = 30;
        int[] point = new int[lens];
        for (byte i = 0; i < lens; i++) {
            point[i] = (int) (Math.random() * 10) + 0;
        }
        System.out.println("Point 30 student is: " + displayNumbs(point));
        System.out.printf("Student Pass is %d people", countStudentPass(point));
    }
}
