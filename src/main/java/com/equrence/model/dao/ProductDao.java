package com.equrence.model.dao;

import com.equrence.model.entity.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(long id);

    void editProduct(long id, Product product);

    void updateProductQuantity(long id, int number);

    void deleteProduct(long id);
}
