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
import java.util.List;

@WebServlet("/selling")
public class ProductsServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() {
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getAllProducts();

        req.setAttribute("products", products);

        req.getRequestDispatcher("/view/selling/products.jsp").forward(req, resp);
    }
}
