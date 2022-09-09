package product.mvc.models;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Produce {
    public int id;
    public String nameProduce;
    public int price;
    public String other;
    public String manufacturer;

    public Produce setId(int id) {
        this.id = id;
        return this;
    }

    public Produce setNameProduce(String nameProduce) {
        this.nameProduce = nameProduce;
        return this;
    }

    public Produce setPrice(int price) {
        this.price = price;
        return this;
    }

    public Produce setOther(String other) {
        this.other = other;
        return this;
    }

    public Produce setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    @Override
    public String toString() {
        return "Produce{" +
                "id=" + id +
                ", nameProduce='" + nameProduce + '\'' +
                ", price=" + price +
                ", other='" + other + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
