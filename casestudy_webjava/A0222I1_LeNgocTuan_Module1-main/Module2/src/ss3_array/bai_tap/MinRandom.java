package ss3_array.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MinRandom {
    public static String displayNumbs(int[] nums){
        String ans = "";
        for(int i: nums){
            ans+= i +" ";
        }
        return ans;
    }
    public static int findMinOfNumbs(int[] nums){
        return Arrays.stream(nums).min().getAsInt();
    }
    public static void main(String[] args) {
        int lens;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your length");
        lens = scanner.nextInt();
        int[] numbs = new int[lens];
        for (byte i = 0; i < lens; i++) {
            numbs[i] = (int) (Math.random() * 100) + 1;
        }
        System.out.printf("NewList Number: %s",displayNumbs(numbs));
        System.out.printf("\nMin is: %s",findMinOfNumbs(numbs));
    }
}
