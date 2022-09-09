package ss3_array.thuc_hanh;

import java.util.Scanner;

public class FindName {
    public static void main(String[] args) {
        boolean flag = true;
        String [] persons = {"Jinx", "Oriana", "Joker", "Jax", "Darius"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your name want to find: ");
        String findName = scanner.nextLine();
        for(String i : persons){
            if (findName.toLowerCase().equals(i.toLowerCase())) {
                System.out.printf("Persons have person 's name is %s", i);
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.printf("Not Found %s in persons ", findName);
        }
    }
}
