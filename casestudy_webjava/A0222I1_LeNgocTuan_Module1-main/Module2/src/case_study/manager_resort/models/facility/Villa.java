package java_basic.manager_resort.models.facility;

import java.util.List;

public class Villa extends Facility {
    String level;
    String areaPool;
    String stage;

    public Villa(String idFacility, String name, String areaToUse
            , String price, String typeOfLend, String level, String areaPool, String stage) {
        super(idFacility, name, areaToUse, price, typeOfLend);
        this.areaPool = areaPool;
        this.level = level;
        this.stage = stage;
    }

    public Villa(List<String> data) {
        super("VL" +data.get(0), data.get(1), data.get(2), data.get(3), data.get(4));
        this.level = data.get(5);
        this.areaPool = data.get(6);
        this.stage = data.get(7);
    }

    public static String getPropertiesVilla() {
        return "idFacility,Name,AreaToUse,Price,TypeOfLend,Level,AreaPool,Stage";
    }

    public static String getValueCanEdit() {
        return "Name,AreaToUse,Price,TypeOfLend,Level,AreaPool,Stage";
    }

    @Override
    public String toString() {
        return String.format("Villa{idFacility %s,Name %s,AreaToUse %s,Price %s,TypeOfLend %s,Level %s,AreaPool %s,Stage %s}",
                getIdFacility(), getName(), getAreaToUse(), getPrice(), getTypeOfLend(), level, areaPool, stage);
    }

    public Villa setLevel(String level) {
        this.level = level;
        return this;
    }

    public Villa setAreaPool(String areaPool) {
        this.areaPool = areaPool;
        return this;
    }

    public Villa setStage(String stage) {
        this.stage = stage;
        return this;
    }
}
