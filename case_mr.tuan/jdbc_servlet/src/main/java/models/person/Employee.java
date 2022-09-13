package models.person;

import lombok.*;

import java.sql.Date;

public class Employee {
    int id;
    String name;
    Date birthday;
    String id_card;
    double salary;
    String phone;
    String email;
    String address;
    int positions;
    int education_degree;
    int division;

    public Employee(String name, Date birthday, String id_card, double salary, String phone, String email, String address, int positions, int education_degree, int division) {
        this.name = name;
        this.birthday = birthday;
        this.id_card = id_card;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.positions = positions;
        this.education_degree = education_degree;
        this.division = division;
    }

    public Employee() {
    }

    public Employee(int id, String name, Date birthday, String id_card, double salary, String phone, String email, String address, int positions, int education_degree, int division) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.id_card = id_card;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.positions = positions;
        this.education_degree = education_degree;
        this.division = division;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPositions() {
        return positions;
    }

    public void setPositions(int positions) {
        this.positions = positions;
    }

    public int getEducation_degree() {
        return education_degree;
    }

    public void setEducation_degree(int education_degree) {
        this.education_degree = education_degree;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }
}
