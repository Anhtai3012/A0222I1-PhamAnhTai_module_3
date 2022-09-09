package com.example.list_customer;

public class Customer {
    public String fullName;
    public String dateBirth;
    public String address;
    public String imageIcon;

    public Customer(String fullName, String dateBirth, String address, String imageIcon) {
        this.fullName = fullName;
        this.dateBirth = dateBirth;
        this.address = address;
        this.imageIcon = imageIcon;
    }

    @Override
    public String toString() {
        return String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td><img src=\"img/%s\" alt=\"No Load\"></td></tr>",fullName,dateBirth,address,imageIcon);
    }
}
