package ss1_introduct.thuc_hanh;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your height in metre: ");
        double height = scanner.nextDouble();
        System.out.println("Input your weight in kilogram: ");
        double weight = scanner.nextDouble();
        double bmi = weight / (Math.pow(height,2));
        if( bmi < 18.5) {
            System.out.printf("BMI is %.3f, Underweight", bmi);
        } else if ( bmi < 25){
            System.out.printf("BMI is %.3f, Normal", bmi);
        } else if ( bmi < 30){
            System.out.printf("BMI is %.3f, Overweight", bmi);
        } else {
            System.out.printf("BMI is %.3f, Obese", bmi);
        }
    }
}
