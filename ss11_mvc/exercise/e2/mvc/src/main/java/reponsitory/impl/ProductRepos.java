package reponsitory.impl;

import model.Product;
import reponsitory.IProductRepos;

import java.util.ArrayList;
import java.util.List;

public class ProductRepos implements IProductRepos {
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iphone", 654, "on", "apple"));
        productList.add(new Product(2, "samsung", 123, "on", "samsung"));
        productList.add(new Product(3, "nokia", 456, "off", "nokia"));
        productList.add(new Product(4, "kiaMorning", 987, "off", "vinFast"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean save(Product product) {
        productList.add(product);
        return true;
    }

    @Override
    public void remove(Product product) {
        productList.remove(product);
    }

    @Override
    public void removeById(int id) {
      productList.remove(findById(id));
    }

    @Override
    public boolean update(Product product) {
        findById(product.getId()).setName(product.getName());
        findById(product.getId()).setPrice(product.getPrice());
        findById(product.getId()).setStatus(product.getStatus());
        findById(product.getId()).setManufacturer(product.getManufacturer());
        return true;
    }

    @Override
    public Product findById(int id) {
        for (Product pro : productList) {
            if (pro.getId() == id) {
                return pro;
            }
        }
        return null;
    }

    @Override
    public Product findByName(String name) {
        for (Product pro : productList) {
            if (pro.getName().equalsIgnoreCase(name)){
                return pro;
            }
        }
        return null;
    }

}
