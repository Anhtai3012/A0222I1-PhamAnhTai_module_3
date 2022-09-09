package service;

import model.HouseHold;

import java.util.List;

public interface IHouseholdService {
    List<HouseHold> selectAll();
    void insertHousehold(HouseHold houseHold);
    HouseHold selectById(int id);
    boolean updateHousehold(HouseHold houseHold);
}
