package service.impl;

import model.HouseHold;
import repository.IHouseHoldRepository;
import repository.impl.HouseholdRepository;
import service.IHouseholdService;

import java.util.List;

public class HouseholdService implements IHouseholdService {
    IHouseHoldRepository repository = new HouseholdRepository();
    @Override
    public List<HouseHold> selectAll() {
        return repository.selectAll();
    }

    @Override
    public void insertHousehold(HouseHold houseHold) {

        repository.insertHousehold(houseHold);
    }

    @Override
    public HouseHold selectById(int id) {
        return repository.selectById(id);
    }

    @Override
    public boolean updateHousehold(HouseHold houseHold) {
        return this.repository.updateHousehold(houseHold);
    }
}
