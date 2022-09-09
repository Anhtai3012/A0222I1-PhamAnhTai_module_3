package java_basic.manager_resort.models.person;

public abstract class Person {
    String name;
    String birthday;
    String id;
    String phone;
    String mail;

    public Person() {
    }

    public Person(String id, String name, String birthday, String phone, String mail) {
        this.name = name;
        this.birthday = birthday;
        this.id = id;
        this.phone = phone;
        this.mail = mail;
    }

    public abstract String toString();

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public Person setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getId() {
        return id;
    }

    public Person setId(String id) {
        this.id = id;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public Person setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public boolean hasId(String id) {
        return id.equals(this.id);
    }
}
