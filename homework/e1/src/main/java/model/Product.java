package model;

public class Product {
    private  int id;
    private String name;
    private double price;
    private String color;
    private int quantity;
    private int category;
    private  String categoryName;

    public Product() {
    }

    public Product(int id, String name, double price, String color, int quantity, int category, String categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.quantity = quantity;
        this.category = category;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Product(String name, double price, String color, int quantity) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.quantity = quantity;
    }

    public Product(int id, String name, double price, String color, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.quantity = quantity;
    }

    public Product(int id, String name, double price, String color, int quantity, int category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.quantity = quantity;
        this.category = category;
    }

    public Product(String name, double price, String color, int quantity, int category) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.quantity = quantity;
        this.category = category;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
