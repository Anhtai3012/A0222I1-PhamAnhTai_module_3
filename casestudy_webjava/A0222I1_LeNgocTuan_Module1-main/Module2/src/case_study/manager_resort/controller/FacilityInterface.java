package java_basic.manager_resort.controller;

import java_basic.manager_resort.models.facility.Facility;

import java.util.Map;

public interface FacilityInterface {

    void addNewInMap(Facility facility);

    Map.Entry<Facility, Integer> searchFacility(String idFacility);

    void displayCanUse();

    void displayMaintenance();
}
