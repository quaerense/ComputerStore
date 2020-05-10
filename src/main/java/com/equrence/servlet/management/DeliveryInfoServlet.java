package com.equrence.servlet.management;

import com.equrence.model.entity.Delivery;
import com.equrence.model.entity.Supplier;
import com.equrence.model.service.DeliveryService;
import com.equrence.model.service.DeliveryServiceImpl;
import com.equrence.model.service.SupplierService;
import com.equrence.model.service.SupplierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/management/delivery_info")
public class DeliveryInfoServlet extends HttpServlet {
    private DeliveryService deliveryService;
    private SupplierService supplierService;

    @Override
    public void init() {
        deliveryService = new DeliveryServiceImpl();
        supplierService = new SupplierServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long deliveryId = -1;

        if (req.getParameter("id") != null && !req.getParameter("id").isEmpty()) {
            deliveryId = Long.parseLong(req.getParameter("id"));
        } else {
            req.getRequestDispatcher("/view/error/error404.jsp").forward(req, resp);
        }

        Delivery delivery = deliveryService.getDeliveryById(deliveryId);

        if (delivery != null) {
            int supplierId = delivery.getSupplierId();

            Supplier supplier = supplierService.getSupplierById(supplierId);

            String supplierName = supplier.getSupplierName();

            req.setAttribute("delivery", delivery);
            req.setAttribute("supplierName", supplierName);

            req.getRequestDispatcher("/view/management/delivery_info.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/view/error/delivery_not_found.jsp").forward(req, resp);
        }
    }
}
