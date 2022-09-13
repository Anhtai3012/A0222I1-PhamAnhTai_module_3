package service.impl;

import dto.HouseHoldDTO;
import models.HouseHold;
import repository.IHouseRepository;
import repository.impl.HouseRepository;
import service.IHouseService;
import utils.Valid;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class HouseHoldService implements IHouseService<HouseHold> {
    IHouseRepository<HouseHold> repository = new HouseRepository();

    @Override
    public Map<String, String> update(HouseHold houseHold, String id) throws SQLException {
        Map<String, String> map = Valid.checkValid(houseHold);
        if (map.isEmpty()) {
            repository.update(houseHold, id);
        }
        return map;
    }

    @Override
    public HouseHold findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<HouseHoldDTO> findAll(int offset) {
        return repository.findAll(offset);
    }

    @Override
    public int countAmountFindAll() {
        return repository.countAmountFindAll();
    }
}
