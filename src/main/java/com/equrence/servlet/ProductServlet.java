package com.equrence.servlet;

import com.equrence.model.entity.Employee;
import com.equrence.model.entity.Product;
import com.equrence.model.entity.enumeration.EmployeePosition;
import com.equrence.model.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Employee employee = (Employee) session.getAttribute("employee");

        List<Product> products = productService.getAllProducts();

        req.setAttribute("products", products);

        if (employee.getEmployeePosition() == EmployeePosition.ADMINISTRATOR) {
            req.getRequestDispatcher(req.getContextPath() + "/view/administration/products.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher(req.getContextPath() + "/view/selling/products.jsp").forward(req, resp);
        }
    }
}
