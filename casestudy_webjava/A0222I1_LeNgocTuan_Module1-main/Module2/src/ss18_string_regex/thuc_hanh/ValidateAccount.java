package ss18_string_regex.thuc_hanh;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateAccount {
    public static boolean isCorrectType(String name) {
        String FORMAT_ACCOUNT = "^[_a-z0-9]{6,}$";
        return Pattern.matches(FORMAT_ACCOUNT, name);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Account want check ");
        String account = scanner.nextLine();
        String ans = isCorrectType(account) ? String.format("%s is correct type", account) : String.format("%s is NOT correct type", account);
        System.out.println(ans);
    }
}


