package ss11_slack_queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static int converterDecimalToBinary(int number){
        Stack<Integer> numbers = new Stack<>();
        StringBuilder ans = new StringBuilder();
        while (number > 0) {
            int binary = number % 2;
            numbers.push(binary);
            number = (int) Math.floor(number/2);
        }
        while (numbers.size() > 0){
            ans.append(numbers.pop());
        }
        return Integer.parseInt(ans.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number: ");
        int number = scanner.nextInt();
        System.out.printf("Number %d cover binary %d", number, converterDecimalToBinary(number));

    }
}
