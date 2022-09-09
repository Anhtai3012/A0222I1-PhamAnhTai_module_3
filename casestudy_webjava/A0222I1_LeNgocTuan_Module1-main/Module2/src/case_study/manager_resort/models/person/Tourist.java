package java_basic.manager_resort.models.person;

import java.util.List;

public class Tourist extends Person implements Comparable<Tourist> {
    String typeTourist;

    public Tourist() {
        super();
    }

    public Tourist(List<String> data) {
        super(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4));
        this.typeTourist = data.get(5);
    }

    public Tourist(String id, String name, String birthday, String phone, String mail, String typeStr) {
        super(id, name, birthday, phone, mail);
        this.typeTourist = typeStr;
    }

    public Tourist(String typeStr) {
        this.typeTourist = typeStr;
    }

    public static String getPropertiesTourist() {
        return "ID,NAME,BIRTHDAY,PHONE,MAIL,TYPE_TOURIST";
    }

    public static String getValueCanEdit(){
        return "NAME,BIRTHDAY,PHONE,MAIL,TYPE_TOURIST";
    }

    public String toString() {
        return "Tourist{" +
                "typeTourist=" + typeTourist +
                ", name='" + getName() + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                ", id=" + getId() +
                ", phone='" + getPhone() + '\'' +
                ", mail='" + getMail() + '\'' +
                '}';
    }

    public void  setAllProps(List<String> data) {
        if(data.size() < 5) System.out.print("[ERROR] Cannot modify props");
        name = data.get(0);
        birthday = data.get(1);
        phone = data.get(2);
        mail = data.get(3);
        typeTourist = data.get(4);
    }

    @Override
    public int compareTo(Tourist o) {
        return getName().compareToIgnoreCase(o.getName());
    }
}
