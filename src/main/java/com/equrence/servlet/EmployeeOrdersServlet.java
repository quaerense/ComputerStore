package com.equrence.servlet;

import com.equrence.model.entity.Employee;
import com.equrence.model.entity.Order;
import com.equrence.model.service.EmployeeService;
import com.equrence.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/administration/employee_orders")
public class EmployeeOrdersServlet extends HttpServlet {
    private OrderService orderService;
    private EmployeeService employeeService;

    @Override
    public void init() {
        orderService = new OrderService();
        employeeService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        List<Order> orders = orderService.getAllOrdersByEmployeeId(id);
        Employee employee = employeeService.getEmployeeById(id);

        req.setAttribute("orders", orders);
        req.setAttribute("employee", employee);

        req.getRequestDispatcher(req.getContextPath() + "/view/administration/employee_orders.jsp").forward(req, resp);
    }
}
