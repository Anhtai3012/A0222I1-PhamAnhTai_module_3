package service.impl;

import model.HouseHold;
import repository.IHouseHoldRepository;
import repository.impl.HouseholdRepository;
import service.IHouseholdService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HouseholdService implements IHouseholdService {
    IHouseHoldRepository repository = new HouseholdRepository();
    @Override
    public List<HouseHold> selectAll() {
        return repository.selectAll();
    }

    @Override
    public Map<String,String> insertHousehold(HouseHold houseHold) {
        Map<String,String> map = new HashMap<>();
        if (houseHold.getQuantity()<=0){
            map.put("quantity","ko dc nho hon 0 hoac bang 0");
        }
        if (houseHold.getId()<=0){
            map.put("id","ko dc nho hon 0 hoac bang 0");
        }
        if ("".equals(houseHold.getName())){
            map.put("name","Name is't empty");
        }
        if ("".equals(houseHold.getAddress())){
            map.put("address","Address is't empty ");
        }
        if ("".equals(houseHold.getStartDayHouseHold())){
            map.put("date","Date is't empty");
        }
        if (map.isEmpty()){
        repository.insertHousehold(houseHold);
        }
        return map;
    }

    @Override
    public HouseHold selectById(int id) {
        return repository.selectById(id);
    }

    @Override
    public boolean updateHousehold(HouseHold houseHold) {
        return this.repository.updateHousehold(houseHold);
    }

    @Override
    public List<HouseHold> selectByName(String name) {
        return this.repository.selectByName(name);
    }
}
