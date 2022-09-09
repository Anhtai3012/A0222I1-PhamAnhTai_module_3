package case_study.util;

import case_study.models.Person.Customer;
import case_study.models.Person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite2 {
    private static void writeObjectToCSV(List<String> strings, String pathFile, boolean append) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(pathFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < strings.size(); i++) {
                bufferedWriter.write(strings.get(i));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeCustomerToCSV(List<Customer> customers, String pathFile, boolean append) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            strings.add(customers.get(i).getData());
        }
        writeObjectToCSV(strings, pathFile, append);
    }

    public static void writeEmployeeToCSV(List<Employee> employees, String pathFile, boolean append) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            strings.add(employees.get(i).getData());
        }
        writeObjectToCSV(strings, pathFile, append);
    }

    private static List<String> readObjectToCSV(String pathFile) {
        List<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }

    public static List<Customer> readCustomerToCSV(String pathFile) {
        List<Customer> customers = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] array;
        for (int i = 0; i < strings.size(); i++) {
            array = strings.get(i).split(",");
            customers.add(new Customer(Integer.parseInt(array[0]), array[1], array[2], array[3],
                    array[4], array[5], array[6], array[7], array[8]));
        }
        return customers;
    }

    public static List<Employee> readEmployeeToCSV(String pathFile) {
        List<Employee> employees = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] array;
        for (int i = 0; i < strings.size(); i++) {
            array = strings.get(i).split(",");
            employees.add(new Employee(Integer.parseInt(array[0]), array[1], array[2], array[3],
                    array[4], array[5], array[6], array[7], array[8], Double.parseDouble(array[9])));
        }
        return employees;
    }
}

