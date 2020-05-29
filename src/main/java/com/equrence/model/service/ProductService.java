package com.equrence.model.service;

import com.equrence.model.entity.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(long id);

    void editProduct(long id, Product product);

    void deleteProduct(long id);
}
