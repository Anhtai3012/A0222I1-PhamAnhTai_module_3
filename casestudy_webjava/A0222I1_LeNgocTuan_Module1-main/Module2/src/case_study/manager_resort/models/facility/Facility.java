package java_basic.manager_resort.models.facility;

public abstract class Facility implements Comparable<Facility> {
    private String idFacility;
    private String name;
    private String areaToUse;
    private String price;
    private String typeOfLend;

    public Facility(String idFacility, String name, String areaToUse, String price, String typeOfLend) {
        this.idFacility = idFacility;
        this.name = name;
        this.areaToUse = areaToUse;
        this.price = price;
        this.typeOfLend = typeOfLend;
    }

    public Facility() {

    }

    public int compareTo(Facility o) {
        if (this.getName().compareToIgnoreCase(o.getName()) > 0) return 1;
        if (this.getName().compareToIgnoreCase(o.getName()) < 0) return -1;
        return getIdFacility().compareToIgnoreCase(o.getIdFacility());
    }

    @Override
    public abstract String toString();

    public String getIdFacility() {
        return idFacility;
    }

    public Facility setIdFacility(String idFacility) {
        this.idFacility = idFacility;
        return this;
    }

    public String getName() {
        return name;
    }

    public Facility setName(String name) {
        this.name = name;
        return this;
    }

    public String getAreaToUse() {
        return areaToUse;
    }

    public Facility setAreaToUse(String areaToUse) {
        this.areaToUse = areaToUse;
        return this;

    }

    public String getPrice() {
        return price;
    }

    public Facility setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getTypeOfLend() {
        return typeOfLend;
    }

    public Facility setTypeOfLend(String typeOfLend) {
        this.typeOfLend = typeOfLend;
        return this;
    }
}
