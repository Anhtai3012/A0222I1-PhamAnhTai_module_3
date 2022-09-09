package java_basic.manager_resort.models.person;

public class Admin extends Person {
    String position;

    public Admin() {
        super();
    }

    public Admin(String id, String name, String birthday, String phone, String mail, String position) {
        super(id, birthday, name, phone, mail);
        this.position = position;
    }

    public Admin(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "position=" + position +
                ", name='" + getName() + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                ", id=" + getId() +
                ", phone='" + getPhone() + '\'' +
                ", mail='" + getMail() + '\'' +
                '}';
    }
}
