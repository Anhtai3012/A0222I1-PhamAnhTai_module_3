package ss16_text_file.thuc_hanh.find_max_file;

import java.io.*;
import java.util.*;

public class MaxText {
    public static List<Integer> getDataInteger(String fileName) {
        String value;
        List<Integer> result = new ArrayList<>();
        try {
            File file = new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((value = bufferedReader.readLine()) != null) {
                try {
                    result.add(Integer.parseInt(value));
                } catch (NumberFormatException e) {
                    System.out.println("Skip " + value);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File NOT found ... ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(result.toArray()));
        return result;
    }

    public static int getMax(List<Integer> list) {
        return Collections.max(list);
    }

    public static void writeToFile(String nameFile, int max) {
        try {
            FileWriter fileWriter = new FileWriter(nameFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\nMax in " + max);
            System.out.println("Max in " + max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int max;
        List<Integer> listNumbs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your file name is ");
        String nameFile = scanner.nextLine();
        listNumbs = getDataInteger(nameFile);
        max = getMax(listNumbs);
        writeToFile(nameFile, max);
    }
}
