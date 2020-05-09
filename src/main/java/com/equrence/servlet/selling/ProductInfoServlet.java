package com.equrence.servlet.selling;

import com.equrence.model.entity.Product;
import com.equrence.model.service.ProductService;
import com.equrence.model.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selling/product_info")
public class ProductInfoServlet extends HttpServlet {
    private ProductService service;

    @Override
    public void init() {
        service = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        long id = -1;

        if (req.getParameter("id") != null && !req.getParameter("id").isEmpty()) {
            id = Long.parseLong(req.getParameter("id"));
        } else {
            req.getRequestDispatcher(contextPath + "/view/error/error404.jsp").forward(req, resp);
        }

        Product product = service.getProductById(id);

        if (product != null) {
            req.setAttribute("product", product);
            req.getRequestDispatcher(contextPath + "/view/selling/product_info.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher(contextPath + "/view/error/product_not_found.jsp").forward(req, resp);
        }
    }
}
