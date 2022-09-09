package models.professional;

import lombok.*;

import java.sql.Timestamp;


public class Contract {
    int id;
    Timestamp start_day;
    Timestamp end_day;
    double deposit;
    int employee_id;
    int customer_id;
    int service_id;
    double total_money;

    public Contract(Timestamp start_day, Timestamp end_day, double deposit, int employee_id, int customer_id, int service_id) {
        this.start_day = start_day;
        this.end_day = end_day;
        this.deposit = deposit;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.service_id = service_id;
    }

    public Contract(int id, Timestamp start_day, Timestamp end_day, double deposit, int employee_id, int customer_id, int service_id, double total_money) {
        this.id = id;
        this.start_day = start_day;
        this.end_day = end_day;
        this.deposit = deposit;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.service_id = service_id;
        this.total_money = total_money;
    }

    public Contract() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getStart_day() {
        return start_day;
    }

    public void setStart_day(Timestamp start_day) {
        this.start_day = start_day;
    }

    public Timestamp getEnd_day() {
        return end_day;
    }

    public void setEnd_day(Timestamp end_day) {
        this.end_day = end_day;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }
}
