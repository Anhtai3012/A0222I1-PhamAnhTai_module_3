package ss5_access_modifier.bai_tap.student;

public class Solution {

    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("Min", 12, "Leaf 5");
        student1.getInfo();
        student2.getInfo();
    }
}
