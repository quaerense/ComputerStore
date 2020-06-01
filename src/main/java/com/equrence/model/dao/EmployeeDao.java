package com.equrence.model.dao;

import com.equrence.model.entity.Employee;
import com.equrence.model.entity.enumeration.EmployeePosition;

import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    void updateEmployeeInfo(int id, Employee employee);

    void updateEmployeePassword(int id, String password);

    void deleteEmployee(int id);

    EmployeePosition getEmployeePositionById(int id);

    boolean employeeIsExist(int id, String password);
}
