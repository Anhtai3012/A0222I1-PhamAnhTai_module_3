package ss1_introduct.bai_tap;

import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
	// write your code here // ctrl shift L format
        Scanner message = new Scanner(System.in);
        System.out.println("What 's your name: ");
        String name = message.nextLine();
        System.out.println("Hello " + name);
    }
}
