package dto;

import models.HouseHold;
import models.People;
import repository.IPeopleRepository;
import repository.impl.PeopleRepository;

import java.sql.Date;

public class HouseHoldDTO {
    IPeopleRepository<People> repository = new PeopleRepository();

    String id;
    String name;
    int number;
    Date dateCreate;
    String address;
    String listNamePeople;

    public HouseHoldDTO() {
    }

    public HouseHoldDTO(HouseHold houseHold) {
        this.id = houseHold.getId();
        this.name = houseHold.getName();
        this.number = houseHold.getNumber();
        this.dateCreate = houseHold.getDateCreate();
        this.address = houseHold.getAddress();
        this.listNamePeople = repository.getAllName(houseHold.getId());
    }

    public HouseHoldDTO(String id, String name, int number, Date dateCreate, String address, String listNamePeople) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.dateCreate = dateCreate;
        this.address = address;
        this.listNamePeople = listNamePeople;
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

    public String getListNamePeople() {
        return listNamePeople;
    }

    public void setListNamePeople(String listNamePeople) {
        this.listNamePeople = listNamePeople;
    }
}
