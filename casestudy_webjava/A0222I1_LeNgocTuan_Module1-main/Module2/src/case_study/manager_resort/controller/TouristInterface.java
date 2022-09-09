package java_basic.manager_resort.controller;

import java_basic.manager_resort.models.person.Tourist;

public interface TouristInterface {
    void addNewTouristInList(Tourist tourist);

    Tourist searchById(String id);

    void displayTourists();
}
