package com.equrence.model.entity;

public class Supplier {
    private int supplierId;
    private String supplierName;
    private String supplierRepresentative;
    private String supplierAddress;
    private String phoneNumber;

    public Supplier() {
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierRepresentative() {
        return supplierRepresentative;
    }

    public void setSupplierRepresentative(String supplierRepresentative) {
        this.supplierRepresentative = supplierRepresentative;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", supplierRepresentative='" + supplierRepresentative + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
