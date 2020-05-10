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
import java.util.List;

@WebServlet("/management/deliveries")
public class DeliveryServlet extends HttpServlet {
    private DeliveryService deliveryService;

    @Override
    public void init() {
        deliveryService = new DeliveryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();

        req.setAttribute("deliveries", deliveries);

        req.getRequestDispatcher("/view/management/deliveries.jsp").forward(req, resp);
    }
}
