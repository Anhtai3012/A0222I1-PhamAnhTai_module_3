package ss2_loop.bai_tap;

public class PrimeNumberSmaller100 {
    public static void main(String[] args) {
        boolean flag;
        String ans = "";
        byte number = 2;
        while (number <= 100) {
            if (number == 2) {
                ans += number + ", ";
            } else {
                flag = true;
                for (byte i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans += number + ", ";
                }
            }
            number++;
        }
        System.out.printf("Prime number is smaller 100 is: %s", ans);
    }
}
