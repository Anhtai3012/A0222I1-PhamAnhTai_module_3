package ss1_introduct.thuc_hanh;

import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        int month;
        Scanner Month = new Scanner(System.in);
        System.out.println("Input month you want: ");
        month = Month.nextInt();
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 10:
            case 12:
                System.out.printf("Month %d have 31 days", month);
                break;
            case 4:
            case 6:
            case 8:
            case 11:
                System.out.printf("Month %d have 30 days", month);
                break;
            case 2:
                System.out.println("Month 2 have 28 or 29 days");
                break;
            default:
                System.out.println("Month input wrong type!");
        }
    }
}
