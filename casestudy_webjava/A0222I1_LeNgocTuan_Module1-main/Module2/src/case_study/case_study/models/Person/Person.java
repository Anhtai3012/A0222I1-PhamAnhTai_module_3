package case_study.models.Person;


public abstract class Person {
    private int id;
    private String name;
    private String birthday;
    private String sex;
    private String idCard;
    private String phone;
    private String email;

    public Person() {
    }

    public Person(int id, String name, String birthday, String sex, String idCard, String phone, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String isSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData() {
        return getId() + "," + getName() + "," + getBirthday() + "," + getSex() +
                "," + getIdCard() + "," + getPhone() + "," + getEmail();
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex=" + sex +
                ", idCard=" + idCard +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' ;
    }
}
