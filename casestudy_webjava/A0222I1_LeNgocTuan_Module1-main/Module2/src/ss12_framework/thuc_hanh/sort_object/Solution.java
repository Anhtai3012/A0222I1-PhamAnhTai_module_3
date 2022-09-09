package ss12_framework.thuc_hanh.sort_object;

import java.util.Collections;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();
        students.add(new Student("Oriana",21,"Da Nang"));
        students.add(new Student("Azir",17,"Sai Gon"));
        students.add(new Student("Braum",12,"Ha Noi"));
        students.add(new Student("Jax",15,"Hue"));
        students.add(new Student("Zed",19,"Vinh"));
        System.out.println("Before: ");
        for (Student student: students) {
            System.out.println(student.toString());
        }
        System.out.println("After sort name: ");
        Collections.sort(students);
        for (Student student: students) {
            System.out.println(student.toString());
        }
        System.out.println("After sort age: ");
        AgeCompareTo ageCompareTo = new AgeCompareTo();
        students.sort(ageCompareTo);
        for (Student student: students)
            System.out.println(student.toString());
        }
    }

