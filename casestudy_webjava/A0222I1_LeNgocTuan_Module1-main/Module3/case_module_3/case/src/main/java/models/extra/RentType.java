package models.extra;

import lombok.*;

@AllArgsConstructor@Setter@Getter@NoArgsConstructor@Builder
public class RentType {
    private int id;
    private String name;
    private double rent_type_cost;

    public RentType(int id, String name, double rent_type_cost) {
        this.id = id;
        this.name = name;
        this.rent_type_cost = rent_type_cost;
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

    public double getRent_type_cost() {
        return rent_type_cost;
    }

    public void setRent_type_cost(double rent_type_cost) {
        this.rent_type_cost = rent_type_cost;
    }
}
