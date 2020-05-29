package com.equrence.model.service;

import com.equrence.model.dao.ProductDao;
import com.equrence.model.dao.ProductDaoImpl;
import com.equrence.model.entity.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDao dao = new ProductDaoImpl();

    public void addProduct(Product product) {
        dao.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }

    public Product getProductById(long id) {
        return dao.getProductById(id);
    }

    public void editProduct(long id, Product product) {
        dao.editProduct(id, product);
    }

    public void deleteProduct(long id) {
        dao.deleteProduct(id);
    }
}
