package com.equrence.model.dao;

import com.equrence.model.entity.Supplier;

import java.util.List;

public interface SupplierDao {
    void addSupplier(Supplier supplier);

    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(int id);

    void updateSupplierInfo(long id, Supplier supplier);

    void deleteSupplier(int id);
}
