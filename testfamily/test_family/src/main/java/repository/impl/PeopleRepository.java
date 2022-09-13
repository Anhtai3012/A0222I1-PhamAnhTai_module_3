package repository.impl;

import models.People;
import repository.IPeopleRepository;
import utils.ConnectData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class PeopleRepository implements IPeopleRepository<People> {
    String findAllName = "select people.id id, `name`,cmnd,birthday from people inner join people_live_house on people.id = people_live_house.people_id and house_id = ?";

    @Override
    public List<People> findAllByIdHouse(String id_search) {
        List<People> list = new ArrayList<>();
        try (Connection connection = ConnectData.getConnect(); PreparedStatement statement = connection.prepareStatement(findAllName)) {
            statement.setString(1, id_search);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String cmnd = resultSet.getString("cmnd");
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("birthday");
                list.add(new People(id, cmnd, name, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getAllName(String id_search) {
        StringBuilder result = new StringBuilder();
        List<People> list = findAllByIdHouse(id_search);

        if (list.isEmpty()) {
            return "";
        }
        result.append("<br>");
        list.forEach(x -> result.append(x.getName()).append("<hr>"));
        return result.toString();
    }
}
