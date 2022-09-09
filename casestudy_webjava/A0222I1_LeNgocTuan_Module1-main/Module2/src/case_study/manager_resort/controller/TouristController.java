package java_basic.manager_resort.controller;

import java_basic.manager_resort.models.person.Tourist;

import java.util.ArrayList;
import java.util.List;

import static java_basic.manager_resort.controller.MenuController.getIdEdit;

public class TouristController implements TouristInterface {
    static List<Tourist> tourists;

    static {
        tourists = new ArrayList<>();
    }

    public void addNewTouristInList(Tourist tourist) {
        if (!isExistTouristInList(tourist)) {
            tourists.add(tourist);
        }
    }

    private boolean isExistTouristInList(Tourist tourist) {
        for (Tourist person : tourists) {
            if (person.hasId(tourist.getId())) return true;
        }
        return false;
    }

    public Tourist searchById(String id) {
        for (Tourist tourist : tourists) {
            if (tourist.hasId(id)) return tourist;
        }
        return null;
    }

    public void displayTourists() {
        tourists.forEach(x -> System.out.println(x.toString()));
    }

    public void editTourist() {
        String id = getIdEdit();
        if (searchById(id) == null) return;

        System.out.println(searchById(id).toString());

        List<String> ans = MenuController.collectDataFromUserInput(Tourist.getValueCanEdit());

        searchById(id).setAllProps(ans);
    }
}
