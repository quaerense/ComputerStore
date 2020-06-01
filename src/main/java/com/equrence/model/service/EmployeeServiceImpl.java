package com.equrence.model.service;

import com.equrence.model.dao.EmployeeDao;
import com.equrence.model.dao.EmployeeDaoImpl;
import com.equrence.model.entity.Employee;
import com.equrence.model.entity.enumeration.EmployeePosition;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao dao = new EmployeeDaoImpl();

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

    public boolean updateEmployeePassword(int id, String oldPassword, String newPassword1, String newPassword2) {
        Employee employee = dao.getEmployeeById(id);

        String currentPassword = employee.getEmployeePassword();

        if (oldPassword.equals(currentPassword) && newPassword1.equals(newPassword2)) {
            dao.updateEmployeePassword(id, newPassword1);
            return true;
        }

        return false;
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
