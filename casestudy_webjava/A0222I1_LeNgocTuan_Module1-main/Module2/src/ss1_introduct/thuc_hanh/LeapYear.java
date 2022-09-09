package ss1_introduct.thuc_hanh;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input year you want to check: ");
        short year = scanner.nextShort();
        boolean leapYear = false;
        if( year % 4 == 0){
            if(year % 100 == 0){
                if ( year % 400 ==0){
                    leapYear = true;
                }
            }else {
                leapYear = true;
            }
        }
        if (leapYear){
            System.out.printf("%s is leap year",year);
        } else {
            System.out.printf("%s is NOT leap year", year);
        }
    }
}
