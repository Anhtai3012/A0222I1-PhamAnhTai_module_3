package repository.impl;

import model.HouseHold;
import repository.BaseRepository;
import repository.IHouseHoldRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseholdRepository implements IHouseHoldRepository {
    private final static String SELECT_ALL="SELECT * FROM house_hold;";
    private final static String INSERT_HOUSEHOLD="INSERT INTO house_hold (`id`, `name`, `quantity`, `start_day_house_hold`, `address`) VALUES (?,?,?,?,?);";
    private final static String SELECT_BY_ID="select * from house_hold where id =?;";
    private final static String UPDATE_BY_ID="update house_hold set `name`=?,quantity=?,start_day_house_hold=?,address=? where id=?;";
    private final static String SELECT_BY_NAME="select * from house_hold where `name` regexp ?;";
    private final static String SElECT_ALL_JOIN="select h.id,h.`name`,count(h.id) quantity,h.start_day_house_hold,h.address from `member` m  right JOIN house_hold h on m.house_hold_id=h.id group by h.id;";
    @Override
    public List<HouseHold> selectAll() {
        List<HouseHold> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SElECT_ALL_JOIN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                String date = resultSet.getString("start_day_house_hold");
                String address = resultSet.getString("address");
                HouseHold houseHold = new HouseHold(id,name,quantity,date,address);
                list.add(houseHold);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void insertHousehold(HouseHold houseHold) {
        Connection connection= BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOUSEHOLD);
            preparedStatement.setInt(1,houseHold.getId());
            preparedStatement.setString(2,houseHold.getName());
            preparedStatement.setInt(3,houseHold.getQuantity());
            preparedStatement.setDate(4, Date.valueOf(houseHold.getStartDayHouseHold()));
            preparedStatement.setString(5,houseHold.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public HouseHold selectById(int id) {
        HouseHold houseHold= null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int houseID= resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                String date = resultSet.getString("start_day_house_hold");
                String address =resultSet.getString("address");
                houseHold = new HouseHold(houseID,name,quantity,date,address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return houseHold;
    }

    @Override
    public boolean updateHousehold(HouseHold houseHold) {
        boolean rowUpdate=false;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1,houseHold.getName());
            preparedStatement.setInt(2,houseHold.getQuantity());
            preparedStatement.setDate(3, Date.valueOf(houseHold.getStartDayHouseHold()));
            preparedStatement.setString(4,houseHold.getAddress());
            preparedStatement.setInt(5,houseHold.getId());
           rowUpdate= preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public List<HouseHold> selectByName(String name) {
        List<HouseHold> result= new ArrayList<>();
            Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("id");
                String nameHouse = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                String date = resultSet.getString("start_day_house_hold");
                String address = resultSet.getString("address");
                result.add(new HouseHold(id,nameHouse,quantity,date,address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
