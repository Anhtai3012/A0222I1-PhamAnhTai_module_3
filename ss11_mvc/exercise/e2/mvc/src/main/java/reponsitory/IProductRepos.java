package reponsitory;


import model.Product;

import java.util.List;

public interface IProductRepos {
    List<Product> findAll();

    boolean save(Product product);

    void remove(Product product);

    boolean update(Product product);

    Product findById(int id);

    void removeById(int id);

    Product findByName(String name);

}
