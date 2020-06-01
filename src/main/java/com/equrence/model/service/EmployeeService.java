package com.equrence.model.service;

import com.equrence.model.entity.Employee;
import com.equrence.model.entity.enumeration.EmployeePosition;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    void updateEmployeeInfo(int id, Employee employee);

    boolean updateEmployeePassword(int id, String oldPassword, String newPassword1, String newPassword2);

    void deleteEmployee(int id);

    EmployeePosition getRoleById(int id);

    boolean employeeIsExist(int id, String password);
}
