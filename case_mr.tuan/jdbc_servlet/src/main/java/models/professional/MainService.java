package models.professional;

import lombok.*;

public class MainService {
    int id;
    String name;
    int area;
    double cost;
    int max_people;
    String standard_room;
    String description_other_convenience;
    double pool_area;
    int number_of_floors;
    String facility_text;
    int rent_type;
    int service_type;

    public MainService(String name, int area, double cost, int max_people, String standard_room, String description_other_convenience, double pool_area, int number_of_floors, String facility_text, int rent_type, int service_type) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.max_people = max_people;
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
        this.facility_text = facility_text;
        this.rent_type = rent_type;
        this.service_type = service_type;
    }

    public MainService() {
    }

    public MainService(int id, String name, int area, double cost, int max_people, String standard_room, String description_other_convenience, double pool_area, int number_of_floors, String facility_text, int rent_type, int service_type) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.max_people = max_people;
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
        this.facility_text = facility_text;
        this.rent_type = rent_type;
        this.service_type = service_type;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }

    public String getFacility_text() {
        return facility_text;
    }

    public void setFacility_text(String facility_text) {
        this.facility_text = facility_text;
    }

    public int getRent_type() {
        return rent_type;
    }

    public void setRent_type(int rent_type) {
        this.rent_type = rent_type;
    }

    public int getService_type() {
        return service_type;
    }

    public void setService_type(int service_type) {
        this.service_type = service_type;
    }
}
