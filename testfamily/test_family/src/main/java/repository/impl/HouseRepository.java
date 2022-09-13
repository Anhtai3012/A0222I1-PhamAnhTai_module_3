package repository.impl;

import dto.HouseHoldDTO;
import models.HouseHold;
import repository.IHouseRepository;
import utils.ConnectData;
import utils.InputData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseRepository implements IHouseRepository<HouseHold> {
    final Integer MAX_LIMIT_DISPLAY = 5;
    String update = "update household set name = ?, date_create = ? ,address = ? where id = ?";
    String findAll = "select household.id id, `name`,countPeopleInHouse(id) `number`,date_create, address from household limit 5 offset ?";
    String findById = "select household.id id, `name`,countPeopleInHouse(id) `number`,date_create, address from household where id = ?";
    String count_list = "select count(*) from household";

    @Override
    public void update(HouseHold houseHold, String id) throws SQLException {
        try (Connection connection = ConnectData.getConnect(); PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            InputData.setValueInQuery(preparedStatement, houseHold);
            preparedStatement.setString(4, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public HouseHold findById(String id) {
        HouseHold houseHold = new HouseHold();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(findById)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                houseHold = InputData.createHouseHoldByResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return houseHold;
    }

    @Override
    public List<HouseHoldDTO> findAll(int offset) {
        List<HouseHoldDTO> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(findAll)) {
            statement.setInt(1, offset * MAX_LIMIT_DISPLAY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new HouseHoldDTO(InputData.createHouseHoldByResultSet(resultSet)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public int countAmountFindAll() {
        int amount = 0;
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(count_list)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                amount = resultSet.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (int) Math.ceil((float) amount / MAX_LIMIT_DISPLAY);
    }
}
