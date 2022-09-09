package ss11_slack_queue.bai_tap;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> result = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        StringBuilder ans = new StringBuilder();
        Stack<String> str = new Stack<>();

        numbers.push(7);
        numbers.push(9);
        numbers.push(4);
        numbers.push(1);
        numbers.push(2);

        int lens = numbers.size();
        System.out.println(new ArrayList<>(numbers));

        for (int i = 0; i < lens; i++) {
            result.push(numbers.pop());
        }
        numbers = result;
        System.out.println(new ArrayList<>(numbers));
        str.push("gau ");
        str.push("gau ");
        str.push("noise ");
        str.push("make ");
        str.push("dog ");
        System.out.println(new ArrayList<>(str));
        int lenStr = str.size();
        for (int i = 0; i < lenStr; i++) {
            ans.append(str.pop());
        }
        System.out.println(ans);
    }
}
