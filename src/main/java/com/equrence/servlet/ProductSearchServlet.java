package com.equrence.servlet;

import com.equrence.model.entity.Product;
import com.equrence.model.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product_search")
public class ProductSearchServlet extends HttpServlet {
    private ProductService service;

    @Override
    public void init() {
        service = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        Product product = service.getProductById(id);


    }
}
