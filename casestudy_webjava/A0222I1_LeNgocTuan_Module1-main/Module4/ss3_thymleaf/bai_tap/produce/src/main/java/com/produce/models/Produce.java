package com.produce.models;

import lombok.*;

@Setter @Getter @Builder @NoArgsConstructor
public class Produce {
    int id;
    String name;
    int price;
    String other;
    String manufacturer;

    public Produce(int id, String name, int price, String other, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.other = other;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getOther() {
        return other;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
