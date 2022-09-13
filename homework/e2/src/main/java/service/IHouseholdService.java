package service;

import model.HouseHold;

import java.util.List;
import java.util.Map;

public interface IHouseholdService {
    List<HouseHold> selectAll();
    Map<String,String> insertHousehold(HouseHold houseHold);
    HouseHold selectById(int id);
    boolean updateHousehold(HouseHold houseHold);
    List<HouseHold> selectByName(String name);
}
