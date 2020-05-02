package com.equrence.model.service;

import com.equrence.model.dao.SupplierDao;
import com.equrence.model.entity.Supplier;

import java.util.List;

public class SupplierService {
    private final SupplierDao dao = new SupplierDao();

    public void addSupplier(Supplier supplier) {
        dao.addSupplier(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return dao.getAllSuppliers();
    }

    public Supplier getSupplierById(int id) {
        return dao.getSupplierById(id);
    }

    public void updateSupplierInfo(long id, Supplier supplier) {
        dao.updateSupplierInfo(id, supplier);
    }

    public void deleteSupplier(int id) {
        dao.deleteSupplier(id);
    }
}
