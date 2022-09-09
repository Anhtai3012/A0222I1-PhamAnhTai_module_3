package ss16_text_file.bai_tap.copy_file;

import java.io.*;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<String> getData(String fileName) {
        String valueCurr = "";
        List<String> data = new ArrayList<>();
        try {
            File file = new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((valueCurr = bufferedReader.readLine()) != null) {
                data.add(valueCurr);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(data);
        return data;
    }

    public static void copyData(List<String> data, String nameTarget) {
        File file = new File(nameTarget);
        boolean flag = true;
        try {
//            if (file.createNewFile()) {
//                System.out.println("File is created!");
//            } else {
//                flag = false;
//                System.out.println("File already exists.");
//            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
            for (String str : data) {
                bufferedWriter.write(str + "\n");

            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            flag = false;
            System.out.println("File not found!!!");
        } catch (FileSystemException e) {
            flag = false;
            System.out.println("Wrong type file name");
        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
        } finally {
            if (flag) {
                System.out.println("Complete!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input file name: ");
        String fileName = scanner.nextLine();
        getData(fileName);
        System.out.print("output file name: ");
        String fileTarget = scanner.nextLine();
        copyData(getData(fileName), fileTarget);
    }
}
