package models;

import java.sql.Date;

public class People {
    Integer id;
    String cmnd;
    String name;
    Date birthday;

    public People() {
    }

    public People(Integer id, String cmnd, String name, Date birthday) {
        this.id = id;
        this.cmnd = cmnd;
        this.name = name;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", cmnd='" + cmnd + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
