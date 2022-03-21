package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "Judo-Gi", 100, "Brand New", "https://m.media-amazon.com/images/I/71ViU6+RvPL._AC_UL1500_.jpg"));
        products.add(new Product(2, "Judo-Tatami", 100, "Brand New", "https://m.media-amazon.com/images/I/61g-lmGdAmL._AC_UL1500_.jpg"));

    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    public int findProductById(int id){
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()==id){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Product findById(int id) {
        int index = findProductById(id);
        if (index!=-1) {
            return products.get(index);
        }
        return null;
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void updateById(int id, Product product) {
        int index = findProductById(id);
        products.set(id, product);
    }

    @Override
    public void removeById(int id) {
        int index = findProductById(id);
        products.remove(index);
    }
}
