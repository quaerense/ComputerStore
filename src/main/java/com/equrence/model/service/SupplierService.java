package com.equrence.model.service;

import com.equrence.model.entity.Supplier;

import java.util.List;

public interface SupplierService {
    void addSupplier(Supplier supplier);

    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(int id);

    void updateSupplierInfo(long id, Supplier supplier);

    void deleteSupplier(int id);
}
