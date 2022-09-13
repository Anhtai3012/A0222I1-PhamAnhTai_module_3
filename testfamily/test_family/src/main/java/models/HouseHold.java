package models;

import java.sql.Date;

public class HouseHold {
    String id;
    String name;
    int number;
    Date dateCreate;
    String address;

    public HouseHold(String id, String name, int number, Date dateCreate, String address) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.dateCreate = dateCreate;
        this.address = address;
    }

    public HouseHold() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
