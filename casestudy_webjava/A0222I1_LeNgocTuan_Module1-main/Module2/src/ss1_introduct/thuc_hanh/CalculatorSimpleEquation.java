package ss1_introduct.thuc_hanh;

import java.util.Scanner;

public class CalculatorSimpleEquation {
    public static void main(String[] args) {
        float x;
        float a;
        float b;
        Scanner Equation = new Scanner(System.in);
        System.out.println("ax + b = 0; Parameter A: ");
        a = Equation.nextFloat();
        System.out.println("Parameter B:");
        b = Equation.nextFloat();
        if( a != 0) {
            x = -b/a;
           System.out.printf("x: %f",x);
        } else if( b == 0){
            System.out.println("The MyFile is all x!");
        } else {
            System.out.println("No MyFile!");
        }
    }
}
