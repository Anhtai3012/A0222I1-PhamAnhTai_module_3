package model;

public class Product {
    int id;
    String name;
    int price;
    String status;
    String manufacturer;

    public Product() {
    }

    public Product(int id, String name, int price, String status, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.manufacturer = manufacturer;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
