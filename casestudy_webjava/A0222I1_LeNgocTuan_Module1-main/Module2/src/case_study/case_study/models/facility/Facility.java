package case_study.models.facility;

import java.util.Objects;

public abstract class Facility {
    private String idFacility;
    private String nameService;
    private double areaUse;
    private double rentalCosts;
    private int peopleMax;
    private String rentalType;

    public Facility() {
    }

    public Facility(String idFacility, String nameService, double areaUse, double rentalCosts, int peopleMax, String rentalType) {
        this.idFacility = idFacility;
        this.nameService = nameService;
        this.areaUse = areaUse;
        this.rentalCosts = rentalCosts;
        this.peopleMax = peopleMax;
        this.rentalType = rentalType;
    }

    public String getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(String idFacility) {
        this.idFacility = idFacility;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getPeopleMax() {
        return peopleMax;
    }

    public void setPeopleMax(int peopleMax) {
        this.peopleMax = peopleMax;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getData() {
        return getIdFacility() + "," + getNameService() + "," + getAreaUse() + "," + getRentalCosts() + "," +
                getPeopleMax() + "," + getRentalType() + ",";
    }

    @Override
    public String toString() {
        return idFacility +
                ", nameService='" + nameService + '\'' +
                ", areaUse=" + areaUse +
                ", rentalCosts=" + rentalCosts +
                ", peopleMax=" + peopleMax +
                ", rentalType='" + rentalType + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(idFacility, facility.idFacility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacility);
    }
}
