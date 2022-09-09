package ss11_slack_queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;


public class CheckParentheses {

    public static boolean isAllParentheses(String s) { // {[()]}
        Stack<Character> stack = new Stack<>();
        for (Character character : s.toCharArray()) {
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
                continue;
            }
            switch (character) {
                case ')':
                    if (stack.empty()) return false;
                    if (stack.pop() != '(') return false;

                    break;
                case '}':
                    if (stack.empty()) return false;
                    if (stack.pop() != '{') return false;

                    break;
                case ']':
                    if (stack.empty()) return false;
                    if (stack.pop() != '[') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character character : s.toCharArray()) {
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
                continue;
            }
            if ((character == ')') && (stack.empty() || stack.pop() != '(')) return false;
            if ((character == '}') && (stack.empty() || stack.pop() != '{')) return false;
            if ((character == ']') && (stack.empty() || stack.pop() != '[')) return false;
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input expression: ");
        String expression = scanner.nextLine();
        if (isValid(expression)) {
            System.out.println(expression + " Correct parentheses");
        } else {
            System.out.println(expression + " NOT Correct parentheses");
        }
        if (isAllParentheses(expression)) {
            System.out.println(expression + " Correct parentheses");
        } else {
            System.out.println(expression + " NOT Correct parentheses");
        }
    }
}
