package java_basic.manager_resort.controller;

import java_basic.manager_resort.models.facility.Facility;

import java.util.Map;
import java.util.TreeMap;

public class FacilityController extends MenuController implements FacilityInterface {
    static Map<Facility, Integer> facilityController;

    static {
        facilityController = new TreeMap<>();
    }

    public void addNewInMap(Facility facility) {
        if (isExist(facility)) return;
        facilityController.put(facility, 0);
    }

    private boolean isExist(Facility facility) {
        for (Map.Entry<Facility, Integer> entry : facilityController.entrySet()) {
            if (entry.getKey().getIdFacility().equalsIgnoreCase(facility.getIdFacility())) return true;
        }
        return false;
    }

    public Map.Entry<Facility, Integer> searchFacility(String idFacility) {
        for (Map.Entry<Facility, Integer> entry : facilityController.entrySet()) {
            if (entry.getKey().getIdFacility().equalsIgnoreCase(idFacility)) return entry;
        }
        return null;
    }

    public void plusValue(Map.Entry<Facility, Integer> entry) {
        entry.setValue(entry.getValue() + 1);
    }

    public void displayCanUse() {
        for (Map.Entry<Facility, Integer> entry : facilityController.entrySet()) {
            if (entry.getValue() > 5) continue;
            System.out.printf("%s have %d time\n", entry.getKey().toString(), entry.getValue());
        }
    }

    public void displayMaintenance() {
        for (Map.Entry<Facility, Integer> entry : facilityController.entrySet()) {
            if (entry.getValue() > 5) {
                System.out.printf("%s maintenance have %d time\n", entry.getKey().toString(), entry.getValue());
            }
        }
    }

}
