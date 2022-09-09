package ss18_string_regex.bai_tap;

import java.util.Scanner;
import java.util.regex.Pattern;

public class IsCorrectPhone {
    public static boolean isCorrectPhone(String phone) {
        String FORMAT_PHONE = "^(\\([\\d]{2})\\)[+|-]\\(0([\\d]{9})\\)$";
        return Pattern.matches(FORMAT_PHONE, phone);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Phone check ");
        String phone = scanner.nextLine();
        System.out.println(isCorrectPhone(phone));
    }
}
