package ss17_serialization.bai_tap.product;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1;
    private int id;
    private String name;
    private String manufacturer;
    private int price;
    private String other;

    public Product() {
        this.id = 1;
        this.name = "Pen";
        this.manufacturer = "SkyDragon";
        this.price = 10;
        this.other = "color";
    }

    public Product(int id, String name, String manufacturer, int price, String other) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.other = other;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", other='" + other + '\'' +
                '}';
    }

    public String getContentCsv() {
        return String.format("%d,%s,%s,%d,%s", id, name, manufacturer, price, other);
    }
}
