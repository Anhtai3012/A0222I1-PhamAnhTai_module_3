package ss13_algorithm_search.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class LongestContinuousAscending {
    public static String findLongestContinuousAscending(String str) {
        int MAX = Integer.MIN_VALUE;
        String result = "";
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (temp.size() == 0) {
                temp.push(str.charAt(i));
                continue;
            }

            if (str.charAt(i) < temp.peek()) {  // -> if ascending
                temp.clear();
            }

//            if (isExistCharacterInStack(temp, str.charAt(i))) { // if not ascending
//                temp.clear();
//            }

            temp.push(str.charAt(i));
            if (temp.size() > MAX) {
                MAX = temp.size();
                result = converterStackToString(temp);
            }
        }
        return String.format("Result: [%s]", result);
    }

    public static String converterStackToString(Stack<Character> stack) {
        StringBuilder str = new StringBuilder();
        for (Character character : stack) {
            str.append(character);
        }
        return str.toString();
    }

    public static boolean isExistCharacterInStack(Stack<Character> stack, Character character) {
        for (Character value : stack) {
            if (value.toString().equalsIgnoreCase(character.toString())) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input String: ");
        String str = scanner.nextLine();
        System.out.println(findLongestContinuousAscending(str));
    }
}
