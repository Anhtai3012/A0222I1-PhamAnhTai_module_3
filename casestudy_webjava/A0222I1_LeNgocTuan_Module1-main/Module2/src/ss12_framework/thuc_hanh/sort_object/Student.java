package ss12_framework.thuc_hanh.sort_object;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private String address;

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return String.format("name %s, age %d, address %s", getName(), getAge(), getAddress());
    }

    public int compareTo(Student o) {
       return this.getName().compareToIgnoreCase(o.getName());
       }

//    public int compareToAge(Student o) {
//
//    }
}
