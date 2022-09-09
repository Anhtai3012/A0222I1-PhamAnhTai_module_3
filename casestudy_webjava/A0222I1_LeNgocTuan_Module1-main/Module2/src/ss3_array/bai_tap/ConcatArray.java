package ss3_array.bai_tap;

import java.util.Scanner;

public class ConcatArray {
    public static String displayNumbs(int[] nums){
        String ans = "";
        for(int i: nums){
            ans+= i +" ";
        }
        return ans;
    }
    public static int[] concat2Numbs(int[] num1, int[] num2){
        int lens = num1.length+ num2.length;
        int [] result = new int[lens];
        for(int i = 0; i<num1.length;i++){
            result[i] = num1[i];
        }
        for(int i = num1.length; i< lens; i++) {
            result[i] = num2[i - num1.length];
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length1 = 4;
        int length2 = 3;
        int[] numbs1 = new int[length1];
        int[] numbs2 = new int[length2];
        System.out.println("Input element in numbers 1");
        for(byte i = 0; i< length1; i++){
            System.out.printf("%s element %d: ","number 1",i);
            numbs1[i] = scanner.nextInt();
        }
        System.out.printf("Number 1: %s\n",displayNumbs(numbs1));
        System.out.println("Input element in numbers 2");
        for(byte i = 0; i< length2; i++){
            System.out.printf("%s element %d: ","number 2",i);
            numbs2[i] = scanner.nextInt();
        }
        System.out.printf("Number 2: %s\n",displayNumbs(numbs2));
        int[] numb3 = concat2Numbs(numbs1,numbs2);
        System.out.printf("Number 3: %s",displayNumbs(numb3));
    }
}
