package com.equrence.servlet.accounting;

import com.equrence.model.service.OrderService;
import com.equrence.model.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/accounting/order_info")
public class OrderInfoServlet extends HttpServlet {
    private OrderService service;

    @Override
    public void init() {
        service = new OrderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = -1;

        if (req.getParameter("id") != null && !req.getParameter("id").isEmpty()) {
            id = Integer.parseInt(req.getParameter("id"));
        } else {
            req.getRequestDispatcher("/view/error/error404.jsp").forward(req, resp);
        }

        Map<String, String> orderDetails = service.showOrderDetails(id);

        if (orderDetails != null) {
            req.setAttribute("orderDetails", orderDetails);
            req.getRequestDispatcher("/view/accounting/order_info.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/view/error/order_not_found.jsp").forward(req, resp);
        }
    }
}
