package com.equrence.servlet.management;

import com.equrence.model.entity.Supplier;
import com.equrence.model.service.SupplierService;
import com.equrence.model.service.SupplierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/management/supplier_create")
public class SupplierCreateServlet extends HttpServlet {
    private SupplierService service;

    @Override
    public void init() {
        service = new SupplierServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/management/supplier_create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Supplier supplier = new Supplier();

        supplier.setSupplierName(req.getParameter("name"));
        supplier.setSupplierRepresentative(req.getParameter("representative"));
        supplier.setSupplierAddress(req.getParameter("address"));
        supplier.setPhoneNumber(req.getParameter("phone_number"));

        service.addSupplier(supplier);

        resp.sendRedirect(req.getContextPath() + "/management");
    }
}
