package service.impl;

import model.Product;
import service.BaseRepository;
import service.IProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProduct {
//     this.id = id;
//        this.name = name;
//        this.price = price;
//        this.color = color;
//        this.quantity = quantity;
    private final static String SELECT_PRODUCT_BY_ID ="select * from product where id=?;";
    private final static String SELECT_ALL="SELECT * FROM homework.product;";
    private final static String DElETE_ID= "DELETE FROM product where id=?;";
   // private final static String INSERT_PRODUCT="INSERT INTO `homework`.`product` ( `name`, `price`, `color`, `quantity`) VALUES (?,?,?,?);";
   private final static String INSERT_PRODUCT="INSERT INTO `homework`.`product` (`name`, `price`, `color`, `quantity`, `category_id`) VALUES (?, ?,?,?,?);";
   private final static String UPDATE_PRODUCT_BY_ID="update product set `name`=?,price=?,color=?,quantity=?,category_id=? where id=?";
    @Override
    public List<Product> SelectAll() {
        List<Product> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String color = resultSet.getString("color");
                int quantity = resultSet.getInt("quantity");
                int category = resultSet.getInt("category_id");
                list.add( new Product(id,name,price,color,quantity,category));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DElETE_ID);
            preparedStatement.setInt(1,id);
            result = preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public void insertProduct(Product product) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setString(3,product.getColor());
            preparedStatement.setInt(4,product.getQuantity());
            preparedStatement.setInt(5,product.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Product> SearchName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p: SelectAll()) {
            if (p.getName().contains(name)){
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idProduct = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String color = resultSet.getString("color");
                int quantity = resultSet.getInt("quantity");
                int category = resultSet.getInt("category_id");
                product = new Product(idProduct,name,price,color,quantity,category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean saveEditProduct(Product product) {
        boolean rowSave=false;
        Connection connection = BaseRepository.getConnection();
        try {
          //  private final static String UPDATE_PRODUCT_BY_ID="update product set `name`=?,price=?,color=?,quantity=?,category_id=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_BY_ID);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setString(3,product.getColor());
            preparedStatement.setInt(4,product.getQuantity());
            preparedStatement.setInt(5,product.getCategory());
            preparedStatement.setInt(6,product.getId());
            rowSave =preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowSave;
    }

}
