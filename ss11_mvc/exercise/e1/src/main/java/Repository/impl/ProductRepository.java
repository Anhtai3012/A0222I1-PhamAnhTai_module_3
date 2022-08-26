package Repository.impl;

import Model.Product;
import Repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"iphone14 Max",3500,"active","apple"));
        productList.add(new Product(2,"Sam Sung S22 Ultra",5500,"active","Sam Sung"));
        productList.add(new Product(3,"iphone12 Pro Max",2500,"active","apple"));
    }
    @Override
    public List<Product> findAll() {
       return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id)
                return product;
        }
//        for (int i = 0; i <productList.size(); i++) {
//            if (productList.get(i).getId()==id)
//                return productList.get(i);
//        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == id){
                productList.set(i, product);
                break;
            }
        }

//        for (Product product1:productList) {
//            if (product.getId()==id){
//                productList.add(product1);
//                return;
//            }
//        }
    }

    @Override
    public void remove(int id) {
//        productList.removeIf(e -> e.getId() == id);

        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == id){
                productList.remove(i);
                break;
            }
        }
    }
}
