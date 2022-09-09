package ss2_loop.bai_tap;

public class IsPrimeNumber {
    public static void main(String[] args) {
        String ans = "";
        int number = 2;
        boolean flag;
        byte count = 0;
        while (count != 19) {
            if (number == 2) {
                ans += (number + ", ");
                count++;
            } else {
                flag = true;
                for (byte i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans += (number + ", ");
                    count++;
                }
            }
            number++;
        }
        System.out.printf("20 first prime number is %s", ans);
    }
}
