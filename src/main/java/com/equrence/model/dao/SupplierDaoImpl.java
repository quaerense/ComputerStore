package com.equrence.model.dao;

import com.equrence.db_connection.JdbcManager;
import com.equrence.model.entity.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    JdbcManager jdbcManager = new JdbcManager();

    public void addSupplier(Supplier supplier) {
        String sql = "INSERT INTO suppliers (supplier_name, supplier_representative, supplier_address, phone_number) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, supplier.getSupplierName());
            statement.setString(2, supplier.getSupplierRepresentative());
            statement.setString(3, supplier.getSupplierAddress());
            statement.setString(4, supplier.getPhoneNumber());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Supplier> getAllSuppliers() {
        String sql = "SELECT supplier_id, supplier_name, supplier_representative, supplier_address, phone_number " +
                "FROM suppliers";
        List<Supplier> suppliers = new ArrayList<>();
        Supplier supplier;

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                supplier = new Supplier();

                supplier.setSupplierId(resultSet.getInt(1));
                supplier.setSupplierName(resultSet.getString(2));
                supplier.setSupplierRepresentative(resultSet.getString(3));
                supplier.setSupplierAddress(resultSet.getString(4));
                supplier.setPhoneNumber(resultSet.getString(5));

                suppliers.add(supplier);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return suppliers;
    }

    public Supplier getSupplierById(int id) {
        String sql = "SELECT supplier_id, supplier_name, supplier_representative, supplier_address, phone_number " +
                "FROM suppliers WHERE supplier_id = ?";
        Supplier supplier = null;

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    supplier = new Supplier();

                    supplier.setSupplierId(resultSet.getInt(1));
                    supplier.setSupplierName(resultSet.getString(2));
                    supplier.setSupplierRepresentative(resultSet.getString(3));
                    supplier.setSupplierAddress(resultSet.getString(4));
                    supplier.setPhoneNumber(resultSet.getString(5));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supplier;
    }

    public void updateSupplierInfo(long id, Supplier supplier) {
        String sql = "UPDATE suppliers SET supplier_name = ?, supplier_representative = ?, supplier_address = ?, phone_number = ? " +
                "WHERE supplier_id = ?";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, supplier.getSupplierName());
            statement.setString(2, supplier.getSupplierRepresentative());
            statement.setString(3, supplier.getSupplierAddress());
            statement.setString(4, supplier.getPhoneNumber());
            statement.setLong(5, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSupplier(int id) {
        String sql = "DELETE FROM suppliers WHERE supplier_id = ?";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
