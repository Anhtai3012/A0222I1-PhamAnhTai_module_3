package model;

public class Customer {
    private  String name;
    private  String birthday;
    private  String address;
    private String imgPath;
    public Customer() {
    }

    public Customer(String name, String birthday, String address, String imgPath) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
