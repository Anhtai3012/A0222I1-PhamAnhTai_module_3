package ss12_framework.thuc_hanh.sort_object;

import java.util.Comparator;

public class AgeCompareTo implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
