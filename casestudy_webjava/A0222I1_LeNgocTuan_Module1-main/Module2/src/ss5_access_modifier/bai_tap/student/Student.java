package ss5_access_modifier.bai_tap.student;

public class Student {
    private String name = "Will";
    private int age = 10;
    private String classes = "A0222I1";

    public Student() {
    }

    ;

    public Student(String name, int age, String classes) {
        this.name = name;
        this.age = age;
        this.classes = classes;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setClasses(String classes) {
        this.classes = classes;
    }

    public void getInfo() {
        System.out.printf("Student: name %s, age: %d, class: %s\n", name, age, classes);
    }
}
