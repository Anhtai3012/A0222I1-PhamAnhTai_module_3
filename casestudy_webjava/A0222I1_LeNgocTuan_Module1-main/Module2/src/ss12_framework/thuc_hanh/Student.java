package ss12_framework.thuc_hanh;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Student {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();
        students.put("Braum", 17);
        students.put("Leona", 12);
        students.put("Jinx", 11);
        students.put("Morgana", 19);
        students.put("Jhin", 21);
        Map<String, Integer> tree = new TreeMap<>(students);
        tree.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
}
