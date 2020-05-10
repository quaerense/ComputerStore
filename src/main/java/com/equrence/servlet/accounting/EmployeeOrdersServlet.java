package com.equrence.servlet.accounting;

import com.equrence.model.entity.Employee;
import com.equrence.model.entity.Order;
import com.equrence.model.service.EmployeeService;
import com.equrence.model.service.EmployeeServiceImpl;
import com.equrence.model.service.OrderService;
import com.equrence.model.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/accounting/employee_orders")
public class EmployeeOrdersServlet extends HttpServlet {
    private OrderService orderService;
    private EmployeeService employeeService;

    @Override
    public void init() {
        orderService = new OrderServiceImpl();
        employeeService = new EmployeeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        List<Order> orders = orderService.getAllOrdersByEmployeeId(id);
        Employee employee = employeeService.getEmployeeById(id);

        req.setAttribute("orders", orders);
        req.setAttribute("employee", employee);

        req.getRequestDispatcher("/view/accounting/employee_orders.jsp").forward(req, resp);
    }
}
