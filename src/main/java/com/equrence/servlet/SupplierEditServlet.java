package com.equrence.servlet;

import com.equrence.model.entity.Supplier;
import com.equrence.model.service.SupplierService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/administration/supplier_edit")
public class SupplierEditServlet extends HttpServlet {
    private SupplierService service;

    @Override
    public void init() {
        service = new SupplierService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Supplier supplier = service.getSupplierById(id);

        req.setAttribute("supplier", supplier);

        req.getRequestDispatcher(req.getContextPath() + "/view/administration/supplier_edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Supplier supplier = new Supplier();

        int id = Integer.parseInt(req.getParameter("id"));

        supplier.setSupplierName(req.getParameter("name"));
        supplier.setSupplierRepresentative(req.getParameter("representative"));
        supplier.setSupplierAddress(req.getParameter("address"));
        supplier.setPhoneNumber(req.getParameter("phone_number"));

        service.updateSupplierInfo(id, supplier);

        resp.sendRedirect(req.getContextPath() + "/administration/suppliers");
    }
}
