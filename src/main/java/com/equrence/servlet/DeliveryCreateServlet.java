package com.equrence.servlet;

import com.equrence.model.entity.Delivery;
import com.equrence.model.service.DeliveryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/administration/delivery_create")
public class DeliveryCreateServlet extends HttpServlet {
    private DeliveryService service;

    @Override
    public void init() {
        service = new DeliveryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(req.getContextPath() + "/view/administration/delivery_create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Delivery delivery = new Delivery();

        delivery.setSupplierId(Integer.parseInt(req.getParameter("supplier_id")));
        delivery.setDeliveryDate(Date.valueOf(req.getParameter("date")));

        service.addDelivery(delivery);

        resp.sendRedirect(req.getContextPath() + "/administration/deliveries");
    }
}
