package com.equrence.servlet.selling;

import com.equrence.model.entity.Employee;
import com.equrence.model.entity.Order;
import com.equrence.model.entity.Product;
import com.equrence.model.service.OrderService;
import com.equrence.model.service.OrderServiceImpl;
import com.equrence.model.service.ProductService;
import com.equrence.model.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/selling/order_create")
public class OrderCreateServlet extends HttpServlet {
    private OrderService orderService;
    private ProductService productService;
    private int id;

    @Override
    public void init() {
        orderService = new OrderServiceImpl();
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            id = Integer.parseInt(req.getParameter("id"));
        }

        Product product = productService.getProductById(id);

        req.setAttribute("product", product);

        req.getRequestDispatcher(req.getContextPath() + "/view/selling/order_create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        Employee employee = (Employee) session.getAttribute("employee");

        int employeeId = employee.getEmployeeId();
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Order order = new Order();
        order.setProductId(id);
        order.setEmployeeId(employeeId);
        order.setProductQuantity(quantity);

        orderService.createOrder(order);

        resp.sendRedirect(req.getContextPath() + "/selling");
    }
}
