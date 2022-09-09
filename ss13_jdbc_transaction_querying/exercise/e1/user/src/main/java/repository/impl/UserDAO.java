package repository.impl;

import model.User;
import repository.IUserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/e1_ss13";
    private String jdbcUsername = "root";
    private String jdbcPassword = "30122002";

    private static final String INSERT_USER_SQL="insert into users(name, email, country) values(?,?,?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String SELECT_ALL_USERS_NAME = "select * from users order by `name`;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final  String SEARCH_NAME ="select * from users where `name`=?;";
// network database
    public UserDAO() {
    }
    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USER_SQL);
        Connection connection= getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                String name =resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user= new User(name,email,country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            System.out.println(preparedStatement);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String name =resultSet.getString("name");
                String country = resultSet.getString("country");
                users.add(new User(id,name,email,country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
        preparedStatement.setInt(1,id);
        rowDelete = preparedStatement.executeUpdate()>0;
        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate;
        Connection connection =getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_USERS_SQL);
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getEmail());
        preparedStatement.setString(3,user.getCountry());
        preparedStatement.setInt(4,user.getId());
        rowUpdate = preparedStatement.executeUpdate()>0;
        return rowUpdate;
    }

    @Override
    public List<User> searchName(String name) {
        List<User> res = new ArrayList<>();

        for (User user:selectAllUser()) {
            if (user.getName().contains(name));
                res.add(user);
                return res;
        }
        return res;
    }

    @Override
    public List<User> searchName2(String name) {
        List<User> search = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id,name1,email,country);
                search.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return search;
    }

    @Override
    public List<User> SortName() {
//       users.sort(new Comparator<User>() {
//           @Override
//           public int compare(User o1, User o2) {
//               return o1.getName().compareTo(o2.getName());
//           }
//       });
//        return users;
//    }
        List<User> users = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_NAME);
            System.out.println(preparedStatement);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String name =resultSet.getString("name");
                String country = resultSet.getString("country");
                users.add( new User(id,name,email,country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
}

    @Override
    public List<User> sortName2(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return users;
    }

    @Override
    public List<User> procedureSelectAll() {
        List<User> result = new ArrayList<>();
        Connection connection = getConnection();
        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("call display_user();");
//            ResultSet resultSet = preparedStatement.executeQuery();
            CallableStatement callableStatement = connection.prepareCall("call display_user();");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id,name,email,country);
                result.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  result;
    }

    @Override
    public boolean procedureUpdateUser(User user) throws SQLException {
        boolean rowUpdate;
        Connection connection =getConnection();
       CallableStatement callableStatement = connection.prepareCall("call edit_user(?,?,?,?);");
       callableStatement.setString(1,user.getName());
       callableStatement.setString(2,user.getEmail());
       callableStatement.setString(3,user.getCountry());
       callableStatement.setInt(4,user.getId());
//        preparedStatement.setString(1,user.getName());
//        preparedStatement.setString(2,user.getEmail());
//        preparedStatement.setString(3,user.getCountry());
//        preparedStatement.setInt(4,user.getId());
//        rowUpdate = preparedStatement.executeUpdate()>0;
        rowUpdate = callableStatement.executeUpdate()>0;
        return rowUpdate;
        }

    @Override
    public boolean procedureDeleteUsers(int id) throws SQLException {
        boolean rowDelete;
        Connection connection = getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
//        preparedStatement.setInt(1,id);
//        rowDelete = preparedStatement.executeUpdate()>0;
        CallableStatement callableStatement = connection.prepareCall("call delete_user(?);");
        callableStatement.setInt(1,id);
        rowDelete = callableStatement.executeUpdate()>0;
        return rowDelete;
    }

}
