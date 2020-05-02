package com.equrence.model.dao;

import com.equrence.connection.JdbcManager;
import com.equrence.model.entity.Employee;
import com.equrence.model.entity.enumeration.EmployeePosition;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private final JdbcManager jdbcManager = new JdbcManager();

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees " +
                "(employee_password, employee_name, employee_birth, employee_position, employee_address, phone_number, employee_salary)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employee.getEmployeePassword());
            statement.setString(2, employee.getEmployeeName());
            statement.setDate(3, employee.getEmployeeBirth());
            statement.setString(4, employee.getEmployeePosition().toString());
            statement.setString(5, employee.getEmployeeAddress());
            statement.setString(6, employee.getPhoneNumber());
            statement.setBigDecimal(7, employee.getEmployeeSalary());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        String sql = "SELECT employee_id, employee_name, employee_birth, employee_position, employee_address, phone_number, employee_salary " +
                "FROM employees";
        List<Employee> employees = new ArrayList<>();
        Employee employee;

        try (Connection connection = jdbcManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                employee = new Employee();

                employee.setEmployeeId(resultSet.getInt(1));
                employee.setEmployeeName(resultSet.getString(2));
                employee.setEmployeeBirth(resultSet.getDate(3));
                employee.setEmployeePosition(EmployeePosition.valueOf(resultSet.getString(4)));
                employee.setEmployeeAddress(resultSet.getString(5));
                employee.setPhoneNumber(resultSet.getString(6));
                employee.setEmployeeSalary(resultSet.getBigDecimal(7));

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT employee_name, employee_birth, employee_position, employee_address, phone_number, employee_salary " +
                "FROM employees WHERE employee_id = ?";
        Employee employee = null;

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    employee = new Employee();

                    employee.setEmployeeId(id);
                    employee.setEmployeeName(resultSet.getString(1));
                    employee.setEmployeeBirth(resultSet.getDate(2));
                    employee.setEmployeePosition(EmployeePosition.valueOf(resultSet.getString(3)));
                    employee.setEmployeeAddress(resultSet.getString(4));
                    employee.setPhoneNumber(resultSet.getString(5));
                    employee.setEmployeeSalary(resultSet.getBigDecimal(6));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    public void updateEmployeeInfo(int id, Employee employee) {
        String sql = "UPDATE employees " +
                "SET employee_name = ?, employee_birth = ?, employee_position = ?, employee_address = ?, phone_number = ?, employee_salary = ? " +
                "WHERE employee_id = ?";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employee.getEmployeeName());
            statement.setDate(2, employee.getEmployeeBirth());
            statement.setString(3, employee.getEmployeePosition().toString());
            statement.setString(4, employee.getEmployeeAddress());
            statement.setString(5, employee.getPhoneNumber());
            statement.setBigDecimal(6, employee.getEmployeeSalary());
            statement.setInt(7, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE employee_id = ?";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EmployeePosition getEmployeePositionById(int id) {
        String sql = "SELECT employee_position FROM employees WHERE employee_id = ?";
        EmployeePosition position = null;

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    position = EmployeePosition.valueOf(resultSet.getString(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return position;
    }

    public boolean employeeIsExist(int id, String password) {
        String sql = "SELECT employee_id, employee_password, employee_name, employee_birth, employee_position, employee_address, phone_number, employee_salary " +
                "FROM employees WHERE employee_id = ? AND employee_password = ?";

        try (Connection connection = jdbcManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.setString(2, password.trim());

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
