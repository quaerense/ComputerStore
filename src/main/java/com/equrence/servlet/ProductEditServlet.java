package com.equrence.servlet;

import com.equrence.model.entity.Product;
import com.equrence.model.entity.enumeration.ProductType;
import com.equrence.model.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/administration/product_edit")
public class ProductEditServlet extends HttpServlet {
    ProductService service;

    @Override
    public void init() {
        service = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        Product product = service.getProductById(id);

        req.setAttribute("product", product);

        req.getRequestDispatcher("/view/administration/product_edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Product product = new Product();

        long id = Integer.parseInt(req.getParameter("product_id"));

        product.setDeliveryId(Integer.parseInt(req.getParameter("delivery_id")));
        product.setProductType(ProductType.valueOf(req.getParameter("type")));
        product.setProductName(req.getParameter("name"));
        product.setProductDescription(req.getParameter("description"));
        product.setProductQuantity(Integer.parseInt(req.getParameter("quantity")));
        product.setPurchasePrice(new BigDecimal(req.getParameter("purchase_price")));
        product.setSellingPrice(new BigDecimal(req.getParameter("selling_price")));

        service.editProduct(id, product);

        resp.sendRedirect(req.getContextPath() + "/products");
    }
}