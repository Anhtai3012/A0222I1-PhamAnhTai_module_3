package java_basic.manager_resort.utils;

import java_basic.manager_resort.models.person.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TypeCorrect {
    static Scanner scanner = new Scanner(System.in);

    public static int choiceNumberOption() {
        int option;
        while (true) {
            try {
                System.out.print("Your choice ");
                option = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Again. Choice must Number!");
            }
        }
        return option;
    }

    public static boolean isNotCorrectMail(String email) {
        String FORMAT_MAIL = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return !Pattern.matches(FORMAT_MAIL, email);
    }

    public static boolean isNotCorrectDay(String birthday) {
        String FORMAT_BIRTHDAY = "^([0-2][0-9]|(3)[0-1])([/\\-.])(((0)[1-9])|((1)[0-2]))([/\\-.])(((19)[3-9][0-9])|((20)\\d{2}))$";
        return !Pattern.matches(FORMAT_BIRTHDAY, birthday);
    }

    public static boolean isNotCorrectPhone(String phone) {
        String FORMAT_PHONE = "^[+]([8][4])([\\d]{9})$|^([8][4])([\\d]{9})$|^(0)([\\d]{10})$";
        return !Pattern.matches(FORMAT_PHONE, phone);
    }

    public static boolean isNotCorrectAll(Person person) {
        if (isNotCorrectDay(person.getBirthday())) return true;
        if (isNotCorrectMail(person.getMail())) return true;
        return isNotCorrectPhone(person.getPhone());
    }

    public static LocalDate converterStringToLocalDate(String str) {
        return LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static double getDiscountFromVoucher(String str) {
        if (str.equalsIgnoreCase("voucher10")) return 0.1d;
        if (str.equalsIgnoreCase("voucher30")) return 0.3d;
        if (str.equalsIgnoreCase("voucher50")) return 0.5d;
        return 1;
    }
}
