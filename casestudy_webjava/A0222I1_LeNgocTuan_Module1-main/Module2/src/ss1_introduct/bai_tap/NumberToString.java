package ss1_introduct.bai_tap;

import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {
        short number;
        String ans = "";
        byte thousand;
        byte hundred;
        byte tened;
        byte numberInTenDigits;
        byte unitDigits;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your number: ");
        number = scanner.nextShort();
        if (number < 0) {
            System.out.println("Number > 0");
        } else if (number >= 10000) {
            System.out.println("Out of ability");
        } else {
            thousand = (byte) Math.floor(number / 1000);
            if (thousand > 0) {
                switch (thousand) {
                    case 1:
                        ans = "One thousand ";
                        break;
                    case 2:
                        ans = "Two thousand ";
                        break;
                    case 3:
                        ans = "Three thousand ";
                        break;
                    case 4:
                        ans = "Four thousand ";
                        break;
                    case 5:
                        ans = "Five thousand ";
                        break;
                    case 6:
                        ans = "Six thousand ";
                        break;
                    case 7:
                        ans = "Seven thousand ";
                        break;
                    case 8:
                        ans = "Eight thousand ";
                        break;
                    case 9:
                        ans = "Nine thousand ";
                        break;
                }
            }
            hundred = (byte) Math.floor((number - (thousand * 1000)) / 100);
            tened = (byte) (number % 100);
            if (hundred > 0) {
                switch (hundred) {
                    case 1:
                        ans += "one hundred ";
                        break;
                    case 2:
                        ans += "two hundred ";
                        break;
                    case 3:
                        ans += "three hundred ";
                        break;
                    case 4:
                        ans += "four hundred ";
                        break;
                    case 5:
                        ans += "five hundred ";
                        break;
                    case 6:
                        ans += "six hundred ";
                        break;
                    case 7:
                        ans += "seven hundred ";
                        break;
                    case 8:
                        ans += "eight hundred ";
                        break;
                    case 9:
                        ans += "nine hundred ";
                        break;
                }
            }
            if (tened <= 20) {
                switch (tened) {
                    case 10:
                        ans += "ten";
                        break;
                    case 11:
                        ans += "eleven";
                        break;
                    case 12:
                        ans += "twelve";
                        break;
                    case 13:
                        ans += "three";
                        break;
                    case 14:
                        ans += "fourteen";
                        break;
                    case 15:
                        ans += "fifteen";
                        break;
                    case 16:
                        ans += "sixteen";
                        break;
                    case 17:
                        ans += "seventeen";
                        break;
                    case 18:
                        ans += "eighteen";
                        break;
                    case 19:
                        ans += "nineteen";
                        break;
                    case 20:
                        ans += "twenty";
                        break;
                }
            } else {
                numberInTenDigits = (byte) Math.floor(tened / 10);
                unitDigits = (byte) (tened % 10);
                ans += numberInTenDigits == 2 ? "twenty" : numberInTenDigits == 3 ? "thirty" : numberInTenDigits == 4 ? "forty" : numberInTenDigits == 5 ? "fifty" : numberInTenDigits == 6 ? "sixty" : numberInTenDigits == 7 ? "seventy" : numberInTenDigits == 8 ? "eighty" : "ninety";
                ans += unitDigits == 1 ? " one" : unitDigits == 2 ? " two" : unitDigits == 3 ? " three" : unitDigits == 4 ? " four" : unitDigits == 5 ? " five" : unitDigits == 6 ? " six" : unitDigits == 7 ? " seven" : unitDigits == 8 ? " eight" : " nine";
            }
            System.out.println("Number to text.txt is: " + ans);
        }
    }
}
