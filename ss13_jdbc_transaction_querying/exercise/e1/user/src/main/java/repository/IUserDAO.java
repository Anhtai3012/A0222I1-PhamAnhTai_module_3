package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user) throws SQLException;
    User selectUser(int id);
    List<User> selectAllUser();
    boolean deleteUser(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    List<User> searchName(String name);
    List<User> searchName2(String name);
    List<User> SortName();
    List<User> sortName2(List<User> users);
    List<User> procedureSelectAll();
    boolean procedureUpdateUser(User user) throws SQLException;
    boolean procedureDeleteUsers(int id) throws SQLException;
}
