package model;

public class HouseHold {
    private int id;
    private String name;
    private int quantity;
    private String startDayHouseHold;
    private String address;

    public HouseHold(int id, String name, int quantity, String startDayHouseHold, String address) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.startDayHouseHold = startDayHouseHold;
        this.address = address;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStartDayHouseHold() {
        return startDayHouseHold;
    }

    public void setStartDayHouseHold(String startDayHouseHold) {
        this.startDayHouseHold = startDayHouseHold;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
