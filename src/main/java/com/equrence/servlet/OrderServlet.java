package com.equrence.servlet;

import com.equrence.model.entity.Order;
import com.equrence.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/administration/orders")
public class OrderServlet extends HttpServlet {
    private OrderService service;

    @Override
    public void init() {
        service = new OrderService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = service.getAllOrders();

        req.setAttribute("orders", orders);

        req.getRequestDispatcher(req.getContextPath() + "/view/administration/orders.jsp").forward(req, resp);
    }
}
