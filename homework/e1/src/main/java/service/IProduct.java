package service;

import model.Product;

import java.util.List;

public interface IProduct {
    List<Product> SelectAll();
    boolean delete(int id);
    void insertProduct(Product product);
    List<Product> SearchName(String name);
    Product selectProduct(int id);
    boolean saveEditProduct(Product product);
}
