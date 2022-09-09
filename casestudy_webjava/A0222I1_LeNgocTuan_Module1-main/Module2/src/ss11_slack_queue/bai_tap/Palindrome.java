package ss11_slack_queue.bai_tap;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static boolean isPalindromeStack(String str) {
        Stack<Character> newStr = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            newStr.push(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            ans.append(newStr.pop());
        }
        return str.equalsIgnoreCase(ans.toString());
    }

    public static boolean isPalindromeQueue(String str) {
        Queue<Character> newStr = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        for (int i = (str.length() - 1); i >= 0; i--) {
            newStr.add(str.charAt(i));
            ans.append(newStr.poll());
        }
        return str.equalsIgnoreCase(ans.toString());
    }

    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < str.length() ; i++) {
            stack.push(str.toLowerCase().charAt(i));
            queue.add(str.toLowerCase().charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            if(stack.pop() != queue.poll()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your text: ");
        String str = scanner.nextLine();
        if (isPalindromeStack(str)) {
            System.out.println("Stack: Palindrome");
        } else {
            System.out.println("NOT Palindrome");
        }
        if (isPalindromeQueue(str)) {
            System.out.println("Queue: Palindrome");
        } else {
            System.out.println("NOT Palindrome");
        }
        if(isPalindrome(str)){
            System.out.println("Stack Queue: Palindrome");
        } else {
            System.out.println("NOT Palindrome");
        }
    }
}
