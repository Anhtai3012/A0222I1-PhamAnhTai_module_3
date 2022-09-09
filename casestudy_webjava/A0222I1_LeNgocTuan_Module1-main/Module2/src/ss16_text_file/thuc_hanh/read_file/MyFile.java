package ss16_text_file.thuc_hanh.read_file;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyFile {

    public static String readFile(String nameFile) {
        String currentValue = "";
        List<Integer> numbsInFile = new ArrayList<>();
        try {
            File file = new File(nameFile);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((currentValue = bufferedReader.readLine()) != null) {
                try {
                    numbsInFile.add(Integer.parseInt(currentValue));
                } catch (NumberFormatException e) {
                    System.out.println("Skip " + currentValue);
                }

            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            return "File not found... Check Name Again";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.format("List %s have sums %d",
                Arrays.toString(numbsInFile.toArray()),
                numbsInFile.stream().reduce(0, (total, item) -> total += item));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input file name you want push ");
        String nameFile = scanner.nextLine();
        System.out.println(readFile(nameFile));
    }
}
