package com.equrence.model.service;

import com.equrence.model.dao.ProductDao;
import com.equrence.model.entity.Product;

import java.util.List;

public class ProductService {
    private final ProductDao dao = new ProductDao();

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

    public void updateProductQuantityById(long id, int number) {
        dao.updateProductQuantity(id, number);
    }

    public void deleteProduct(long id) {
        dao.deleteProduct(id);
    }
}
