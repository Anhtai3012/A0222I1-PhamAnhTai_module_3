package ss3_array.bai_tap;

import java.util.Scanner;

public class SumsInColumn {
    public static String displayNumbs(int[][] nums) {
        String ans = "";
        for (int j = 0; j < nums.length; j++) {
            for (int i : nums[j]) {
                ans += i + " ";
            }
            ans += "\n";
        }
        return ans;
    }

    public static void main(String[] args) {
        int lens;
        int column;
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input length: ");
        lens = scanner.nextInt();
        while (true){
            System.out.print("\nColumn your want calculator: ");
            column = scanner.nextInt();
            if(column < lens) break;
        }
        int[][] numbers = new int[lens][lens];
        for (byte i = 0; i < lens; i++) {
            for (byte j = 0; j < lens; j++) {
                numbers[i][j] = (int) (Math.random() * 100) + 0;
                if (j == column) {
                    result += numbers[i][j];
                }
            }
        }
        System.out.printf("NewList number: \n%swith Sum in Columm %d is %d",displayNumbs(numbers),column,result);
    }
}
