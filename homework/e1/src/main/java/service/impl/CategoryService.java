package service.impl;

import model.Category;
import service.BaseRepository;
import service.ICategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 public class CategoryService implements ICategory {
    public static final String SELECT_ALL_CATEGORY ="SELECT * FROM homework.category;";


    @Override
    public List<model.Category> findAll() {
       List<Category> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("type_name");
                Category category = new Category(id,name);
                list.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
