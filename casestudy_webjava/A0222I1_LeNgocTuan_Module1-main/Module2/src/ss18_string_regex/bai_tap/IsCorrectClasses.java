package ss18_string_regex.bai_tap;

import java.util.Scanner;
import java.util.regex.Pattern;

public class IsCorrectClasses {
    public static boolean isCorrectName(String name){
        String FORMAT_CLASSES = "^[ACP][\\d]{4}[G-M]$";
        return Pattern.matches(FORMAT_CLASSES, name);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Class is check ");
        String classes = scanner.nextLine();
        System.out.println(isCorrectName(classes));
    }
}
