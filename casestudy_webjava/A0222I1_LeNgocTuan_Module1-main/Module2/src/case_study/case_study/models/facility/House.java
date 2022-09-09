package case_study.models.facility;

import java.util.Objects;

public class House extends Facility {
    private String standardRoom;
    private int numberOfFloors;

    public House() {
    }

    public House(String standardRoom, int numberOfFloors) {
        this.standardRoom = standardRoom;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String idFacility, String nameService, double areaUse, double rentalCosts, int peopleMax, String rentalType, String standardRoom, int numberOfFloors) {
        super(idFacility, nameService, areaUse, rentalCosts, peopleMax, rentalType);
        this.standardRoom = standardRoom;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getData() {
        return super.getData() + getStandardRoom() + "," + getNumberOfFloors() + ",";
    }

    @Override
    public String toString() {
        return "House{" + super.toString() +
                "standardRoom='" + standardRoom + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
