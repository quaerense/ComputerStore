package com.equrence.servlet.management;

import com.equrence.model.entity.Product;
import com.equrence.model.entity.enumeration.ProductType;
import com.equrence.model.service.ProductService;
import com.equrence.model.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/management/product_create")
public class ProductCreateServlet extends HttpServlet {
    private ProductService service;

    @Override
    public void init() {
        service = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher(req.getContextPath() + "/view/management/product_create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Product product = new Product();

        product.setDeliveryId(Integer.parseInt(req.getParameter("delivery_id")));
        product.setProductType(ProductType.valueOf(req.getParameter("type")));
        product.setProductName(req.getParameter("name"));
        product.setProductDescription(req.getParameter("description"));
        product.setProductQuantity(Integer.parseInt(req.getParameter("quantity")));
        product.setPurchasePrice(new BigDecimal(req.getParameter("purchase_price")));
        product.setSellingPrice(new BigDecimal(req.getParameter("selling_price")));

        service.addProduct(product);

        resp.sendRedirect(req.getContextPath() + "/selling");
    }
}
