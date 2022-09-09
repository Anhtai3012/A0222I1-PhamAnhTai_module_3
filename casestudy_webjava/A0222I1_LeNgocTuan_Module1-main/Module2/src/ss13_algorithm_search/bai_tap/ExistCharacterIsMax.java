package ss13_algorithm_search.bai_tap;

import java.util.Scanner;

public class ExistCharacterIsMax {
    public static String findMaxExistCharacterByList(String str) {
        int MAX = Integer.MIN_VALUE;
        char target = ' ';
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            int count = 1;
            for (int j = i + 1; j < str.length() - i ; j++) {
                if (str.charAt(j) == current) {
                    count++;
                }
                if (count > MAX) {
                    MAX = count;
                    target = current;
                }
            }
        }
        return String.format("%s have %s in %d time", str, target, MAX);
    }

    //aaaabbaabccde
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("String your check: ");
        String str = scanner.nextLine();
        System.out.println(findMaxExistCharacterByList(str));
    }
}
