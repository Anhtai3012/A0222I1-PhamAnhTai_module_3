package service;

import dto.HouseHoldDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IHouseService<E> {

    Map<String, String> update(E e,String id) throws SQLException;

    E findById(String id);

    List<HouseHoldDTO> findAll(int offset);

    int countAmountFindAll();
}
