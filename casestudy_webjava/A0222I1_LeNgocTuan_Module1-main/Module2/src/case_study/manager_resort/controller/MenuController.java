package java_basic.manager_resort.controller;

import java_basic.manager_resort.models.person.Tourist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMenu(String string) {
        List<String> list = new ArrayList<>(Arrays.asList(string.split(",")));
        final int[] i = {1};
        list.forEach(x -> System.out.printf("%d. %s\n", i[0]++, x));
    }

    public static List<String> collectDataFromUserInput(String propsStr) {
        List<String> props = new ArrayList<>(Arrays.asList(propsStr.split(",")));
        List<String> ans = new ArrayList<>();
        props.forEach(x -> {
            System.out.printf("Input %s ", x);
            x = scanner.nextLine();
            ans.add(x);
        });

        return ans;
    }

    public static String getIdEdit() {
        System.out.println("ID ");
        return scanner.nextLine();
    }


}