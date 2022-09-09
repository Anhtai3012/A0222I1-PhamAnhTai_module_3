package java_basic.manager_resort.models.facility;

import java.util.List;

public class Room extends Facility {
    String freeService;

    public Room() {
        super();
    }

    public Room(String idFacility, String name, String areaToUse, String price, String typeOfLend, String freeService) {
        super(idFacility, name, areaToUse, price, typeOfLend);
        this.freeService = freeService;
    }

    public Room(List<String> data) {
        super("RO" + data.get(0), data.get(1), data.get(2), data.get(3), data.get(4));
        this.freeService = data.get(5);
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public static String getPropertiesRoom() {
        return "idFacility,Name,AreaToUse,Price,TypeOfLend,FreeService";
    }

    public static String getValueCanEdit() {
        return "Name,AreaToUse,Price,TypeOfLend,FreeService";
    }

    @Override
    public String toString() {
        return String.format("Room{idFacility %s,Name %s,AreaToUse %s,Price %s,TypeOfLend %s,freeService %s}", getIdFacility(), getName(),
                getAreaToUse(), getPrice(), getTypeOfLend(), freeService);
    }

    public Room setFreeService(String freeService) {
        this.freeService = freeService;
        return this;
    }
}
