package com.equrence.model.dao;

import com.equrence.db_connection.JdbcManager;
import com.equrence.model.entity.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDaoImpl implements DeliveryDao {
    private final JdbcManager jdbcManager = new JdbcManager();

    public void addDelivery(Delivery delivery) {
        String sql = "INSERT INTO deliveries (supplier_id, delivery_date) VALUES (?, ?)";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, delivery.getSupplierId());
            statement.setDate(2, delivery.getDeliveryDate());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Delivery> getAllDeliveries() {
        String sql = "SELECT delivery_id, supplier_id, delivery_date FROM deliveries";
        List<Delivery> deliveries = new ArrayList<>();
        Delivery delivery;

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                delivery = new Delivery();

                delivery.setDeliveryId(resultSet.getLong(1));
                delivery.setSupplierId(resultSet.getInt(2));
                delivery.setDeliveryDate(resultSet.getDate(3));

                deliveries.add(delivery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deliveries;
    }

    public Delivery getDeliveryById(long id) {
        String sql = "SELECT delivery_id, supplier_id, delivery_date FROM deliveries WHERE delivery_id = ?";
        Delivery delivery = null;

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    delivery = new Delivery();

                    delivery.setDeliveryId(resultSet.getLong(1));
                    delivery.setSupplierId(resultSet.getInt(2));
                    delivery.setDeliveryDate(resultSet.getDate(3));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return delivery;
    }

    public void editDeliveryInfo(long id, Delivery delivery) {
        String sql = "UPDATE deliveries SET supplier_id = ?, delivery_date = ? WHERE delivery_id = ?";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, delivery.getSupplierId());
            statement.setDate(2, delivery.getDeliveryDate());
            statement.setLong(3, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDelivery(long id) {
        String sql = "DELETE FROM deliveries WHERE delivery_id = ?";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
