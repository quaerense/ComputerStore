package com.equrence.model.service;

import com.equrence.model.dao.EmployeeDao;
import com.equrence.model.entity.Employee;
import com.equrence.model.entity.enumeration.EmployeePosition;

import java.util.List;

public class EmployeeService {
    private final EmployeeDao dao = new EmployeeDao();

    public void addEmployee(Employee employee) {
        dao.addEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return dao.getEmployeeById(id);
    }

    public void updateEmployeeInfo(int id, Employee employee) {
        dao.updateEmployeeInfo(id, employee);
    }

    public void deleteEmployee(int id) {
        dao.deleteEmployee(id);
    }

    public EmployeePosition getRoleById(int id) {
        return dao.getEmployeePositionById(id);
    }

    public boolean employeeIsExist(int id, String password) {
        return dao.employeeIsExist(id, password);
    }
}
