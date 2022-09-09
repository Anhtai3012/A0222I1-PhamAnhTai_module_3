package ss13_algorithm_search.bai_tap;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Scanner;
import java.util.Stack;

public class LongestStringAscending {
    public static String findLongestStringAscending(String str) {
        int MAX = Integer.MIN_VALUE;
        char value;

        String result = "";
        Stack<Character> tempe = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            value = str.charAt(i);
            if (tempe.size() == 0) {
                tempe.push(value);
                continue;
            }

            if (value < tempe.peek()) {
//                tempe.clear();
                continue;
            }

            tempe.push(value);
            if (tempe.size() > MAX) {
                MAX = tempe.size();
                result = converterStackToString(tempe);
            }
        }
        return String.format("Result: [%s]",result);
    }

    public static String converterStackToString(Stack<Character> stack) {
        StringBuilder str = new StringBuilder();
        for (Character character : stack) {
            str.append(character);
        }
        return str.toString();
    }

// find longest string lower -> higher in ASCII;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your String: ");
        String yourStr = scanner.nextLine();
//        String str = "aabbccaadcbaaabbccss"; // -> result = dcbaaa
        System.out.println(findLongestStringAscending(yourStr));
    }
}
