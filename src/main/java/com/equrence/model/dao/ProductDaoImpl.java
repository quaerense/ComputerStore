package com.equrence.model.dao;

import com.equrence.db_connection.JdbcManagerImpl;
import com.equrence.model.entity.Product;
import com.equrence.model.entity.enumeration.ProductType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private final JdbcManagerImpl jdbcManager = new JdbcManagerImpl();

    public void addProduct(Product product) {
        String sql = "INSERT INTO products (delivery_id, product_type, product_name, product_description, product_quantity, purchase_price, selling_price)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, product.getDeliveryId());
            statement.setString(2, product.getProductType().toString());
            statement.setString(3, product.getProductName());
            statement.setString(4, product.getProductDescription());
            statement.setInt(5, product.getProductQuantity());
            statement.setBigDecimal(6, product.getPurchasePrice());
            statement.setBigDecimal(7, product.getSellingPrice());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT product_id, delivery_id, product_type, product_name, product_description, product_quantity, purchase_price, selling_price" +
                " FROM products";

        List<Product> products = new ArrayList<>();
        Product product;

        try (Connection connection = jdbcManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                product = new Product();

                product.setProductId(resultSet.getLong(1));
                product.setDeliveryId(resultSet.getInt(2));
                product.setProductType(ProductType.valueOf(resultSet.getString(3)));
                product.setProductName(resultSet.getString(4));
                product.setProductDescription(resultSet.getString(5));
                product.setProductQuantity(resultSet.getInt(6));
                product.setPurchasePrice(resultSet.getBigDecimal(7));
                product.setSellingPrice(resultSet.getBigDecimal(8));

                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public Product getProductById(long id) {
        String sql = "SELECT product_id, delivery_id, product_type, product_name, product_description, product_quantity, purchase_price, selling_price" +
                " FROM products WHERE product_id = ?";
        Product product = null;

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    product = new Product();

                    product.setProductId(id);
                    product.setDeliveryId(resultSet.getLong(2));
                    product.setProductType(ProductType.valueOf(resultSet.getString(3)));
                    product.setProductName(resultSet.getString(4));
                    product.setProductDescription(resultSet.getString(5));
                    product.setProductQuantity(resultSet.getInt(6));
                    product.setPurchasePrice(resultSet.getBigDecimal(7));
                    product.setSellingPrice(resultSet.getBigDecimal(8));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public void editProduct(long id, Product product) {
        String sql = "UPDATE products SET delivery_id = ?, product_type = ?, product_name = ?, product_description = ?, product_quantity = ?, purchase_price = ?, selling_price = ?" +
                "WHERE product_id = ?";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, product.getDeliveryId());
            statement.setString(2, product.getProductType().toString());
            statement.setString(3, product.getProductName());
            statement.setString(4, product.getProductDescription());
            statement.setInt(5, product.getProductQuantity());
            statement.setBigDecimal(6, product.getPurchasePrice());
            statement.setBigDecimal(7, product.getSellingPrice());
            statement.setLong(8, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProductQuantity(long id, int number) {
        String sql = "UPDATE products SET product_quantity = (product_quantity + ?) WHERE product_id = ?";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, number);
            statement.setLong(2, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(long id) {
        String sql = "DELETE FROM products WHERE product_id = ?";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
