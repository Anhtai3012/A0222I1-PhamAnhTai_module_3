package repository;

import dto.HouseHoldDTO;

import java.sql.SQLException;
import java.util.List;

public interface IHouseRepository<HouseHold> {


    void update(HouseHold houseHold,String id) throws SQLException;

    HouseHold findById(String id);

    List<HouseHoldDTO> findAll(int offset);

    int countAmountFindAll();
}
