package ss17_serialization.thuc_hanh.write_object;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void writeInFile(String fileName, List<Student> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new LinkedList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        List<Student> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("File output ");
        String fileName = scanner.nextLine();
        list.add(new Student());
        list.add(new Student(9, "Khang", "Da Nang"));
        list.add(new Student(6, "Min", "Ha Noi"));
        list.add(new Student(4, "Linh", "Sai Gon"));
        writeInFile(fileName, list);
        List<Student> studentDataFromFile = readDataFromFile(fileName);
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }
    }
}
