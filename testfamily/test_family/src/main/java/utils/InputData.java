package utils;

import models.HouseHold;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InputData {
    public static void setValueInQuery(PreparedStatement preparedStatement, HouseHold houseHold) throws SQLException {
        preparedStatement.setString(1, houseHold.getName());
        preparedStatement.setDate(2, houseHold.getDateCreate());
        preparedStatement.setString(3, houseHold.getAddress());
    }

    public static HouseHold createHouseHoldByResultSet(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String name = resultSet.getString("name");
        int number = resultSet.getInt("number");
        Date date = resultSet.getDate("date_create");
        String address = resultSet.getString("address");
        return new HouseHold(id, name, number, date, address);
    }
    public static HouseHold createHouseHoldByRequest(HttpServletRequest request) throws SQLException {
        String id = request.getParameter("id");
        String name =  (request.getParameter("name"));
        int number = Integer.parseInt(request.getParameter("number"));
        Date date  = Date.valueOf(request.getParameter("dateCreate"));
        String address =  (request.getParameter("address"));
        return new HouseHold(id, name, number, date, address);
    }
}
