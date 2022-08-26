package service.impl;

import model.Product;
import reponsitory.impl.ProductRepos;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    ProductRepos productList = new ProductRepos();

    @Override
    public List<Product> findAll() {
        return productList.findAll();
    }

    @Override
    public boolean save(Product product) {
        return productList.save(product);
    }

    @Override
    public void remove(Product product) {
       productList.remove(product);
    }

    @Override
    public boolean update(Product product) {
        return productList.update(product);
    }

    @Override
    public Product findById(int id) {
        return productList.findById(id);
    }

    @Override
    public void removeById(int id) {
        productList.remove(findById(id));
    }

    @Override
    public Product findByName(String name) {
        return productList.findByName(name);
    }
}
