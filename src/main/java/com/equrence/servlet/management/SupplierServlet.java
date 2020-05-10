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
import java.util.List;

@WebServlet("/management")
public class SupplierServlet extends HttpServlet {
    private SupplierService service;

    @Override
    public void init() {
        service = new SupplierServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Supplier> suppliers = service.getAllSuppliers();

        req.setAttribute("suppliers", suppliers);

        req.getRequestDispatcher("/view/management/suppliers.jsp").forward(req, resp);
    }
}
