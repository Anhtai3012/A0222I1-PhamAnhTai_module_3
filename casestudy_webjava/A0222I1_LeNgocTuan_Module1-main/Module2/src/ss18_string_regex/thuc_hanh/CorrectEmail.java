package ss18_string_regex.thuc_hanh;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CorrectEmail {
    public static boolean checkMailIsCorrectType(String mail) {
//        String mailFormat = "^[a-zA-Z]+[a-zA-Z0-9]*@[a-zA-Z]+(\\.[a-zA-Z]+)$";
        String mailFormat = "/[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,4}";
        return Pattern.matches(mailFormat, mail);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mail want check ");
        String mail = scanner.nextLine();
        System.out.println(checkMailIsCorrectType(mail));
    }
}
