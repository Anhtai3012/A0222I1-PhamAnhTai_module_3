package repository.impl;

import model.Member;
import repository.BaseRepository;
import repository.IMemberRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository implements IMemberRepository {
    private final static String SELECT_ALL="select * from `member`";
    @Override
    public List<Member> selectAll() {
        List<Member> result = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("cmnd");
                String fullName = resultSet.getString("full_name");
                String birthday= resultSet.getString("birthday");
                int houseHoldId = resultSet.getInt("house_hold_id");
                Member member = new Member(id,fullName,birthday,houseHoldId);
                result.add(member);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
