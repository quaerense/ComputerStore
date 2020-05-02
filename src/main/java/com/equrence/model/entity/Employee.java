package com.equrence.model.entity;

import com.equrence.model.entity.enumeration.EmployeePosition;

import java.math.BigDecimal;
import java.sql.Date;

public class Employee {
    private int employeeId;
    private String employeePassword;
    private String employeeName;
    private Date employeeBirth;
    private EmployeePosition employeePosition;
    private String employeeAddress;
    private String phoneNumber;
    private BigDecimal employeeSalary;

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirth() {
        return employeeBirth;
    }

    public void setEmployeeBirth(Date employeeBirth) {
        this.employeeBirth = employeeBirth;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(BigDecimal employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employeeId != employee.employeeId) return false;
        if (!employeeName.equals(employee.employeeName)) return false;
        if (!employeeBirth.equals(employee.employeeBirth)) return false;
        if (employeePosition != employee.employeePosition) return false;
        if (!employeeAddress.equals(employee.employeeAddress)) return false;
        if (!phoneNumber.equals(employee.phoneNumber)) return false;
        return employeeSalary.equals(employee.employeeSalary);
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + employeeName.hashCode();
        result = 31 * result + employeeBirth.hashCode();
        result = 31 * result + employeePosition.hashCode();
        result = 31 * result + employeeAddress.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + employeeSalary.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeBirth=" + employeeBirth +
                ", employeePosition=" + employeePosition +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}
