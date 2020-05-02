package com.equrence.servlet;

import com.equrence.model.entity.Delivery;
import com.equrence.model.entity.Supplier;
import com.equrence.model.service.DeliveryService;
import com.equrence.model.service.SupplierService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/administration/delivery_info")
public class DeliveryInfoServlet extends HttpServlet {
    private DeliveryService deliveryService;
    private SupplierService supplierService;

    @Override
    public void init() {
        deliveryService = new DeliveryService();
        supplierService = new SupplierService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long deliveryId = Long.parseLong(req.getParameter("id"));

        Delivery delivery = deliveryService.getDeliveryById(deliveryId);

        int supplierId = delivery.getSupplierId();

        Supplier supplier = supplierService.getSupplierById(supplierId);

        String supplierName = supplier.getSupplierName();

        req.setAttribute("delivery", delivery);
        req.setAttribute("supplierName", supplierName);

        req.getRequestDispatcher(req.getContextPath() + "/view/administration/delivery_info.jsp").forward(req, resp);
    }
}
