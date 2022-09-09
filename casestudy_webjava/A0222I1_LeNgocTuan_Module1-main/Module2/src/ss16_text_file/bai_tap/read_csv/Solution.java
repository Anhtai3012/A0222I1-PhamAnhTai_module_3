package ss16_text_file.bai_tap.read_csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String COMMA_DELIMITER = ",";
    //D:\CODEGYM\Full module\Module2\src\ss16_text_file\bai_tap\read_csv\NationList.csv

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("File name is ");
        String fileName = scanner.nextLine();
        BufferedReader bufferedReader = null;
        try {
            String currentValue;
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((currentValue = bufferedReader.readLine()) != null) {
                printCountry(getData(currentValue));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> getData(String csvName) {
        List<String> result = new ArrayList<>();
        if (csvName != null) {
            String[] splitData = csvName.split(COMMA_DELIMITER);
            result.addAll(Arrays.asList(splitData));
        }
        return result;
    }

    private static void printCountry(List<String> nations) {
        System.out.println(
                "Country [id= "
                        + nations.get(0)
                        + ", code= " + nations.get(1)
                        + " , name=" + nations.get(2)
                        + "]");
    }
}
