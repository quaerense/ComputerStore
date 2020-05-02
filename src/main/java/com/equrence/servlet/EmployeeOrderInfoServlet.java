package com.equrence.servlet;

import com.equrence.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/administration/employee_order_info")
public class EmployeeOrderInfoServlet extends HttpServlet {
    private OrderService service;

    @Override
    public void init() {
        service = new OrderService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Integer.parseInt(req.getParameter("id"));

        Map<String, String> orderDetails = service.showOrderDetails(id);

        req.setAttribute("orderDetails", orderDetails);

        req.getRequestDispatcher(req.getContextPath() + "/view/administration/employee_order_info.jsp").forward(req, resp);
    }
}
