package com.equrence.servlet.management;

import com.equrence.model.entity.Delivery;
import com.equrence.model.service.DeliveryService;
import com.equrence.model.service.DeliveryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/management/delivery_create")
public class DeliveryCreateServlet extends HttpServlet {
    private DeliveryService service;

    @Override
    public void init() {
        service = new DeliveryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/management/delivery_create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Delivery delivery = new Delivery();

        delivery.setSupplierId(Integer.parseInt(req.getParameter("supplier_id")));
        delivery.setDeliveryDate(Date.valueOf(req.getParameter("date")));

        service.addDelivery(delivery);

        resp.sendRedirect(req.getContextPath() + "/management/deliveries");
    }
}
