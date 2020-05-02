package com.equrence.model.service;

import com.equrence.model.dao.OrderDao;
import com.equrence.model.entity.Employee;
import com.equrence.model.entity.Order;
import com.equrence.model.entity.Product;
import com.equrence.model.entity.enumeration.EmployeePosition;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private final ProductService productService = new ProductService();
    private final EmployeeService employeeService = new EmployeeService();
    private final OrderDao orderDao = new OrderDao();

    public synchronized void createOrder(Order order) {
        long productId = order.getProductId();
        int quantityForSale = order.getProductQuantity();

        Product product = productService.getProductById(productId);

        int totalQuantity = product.getProductQuantity();
        BigDecimal sellingPrice = product.getSellingPrice();

        if (quantityForSale > 0 && totalQuantity >= quantityForSale) {
            productService.updateProductQuantityById(productId, -quantityForSale);

            BigDecimal totalAmount = sellingPrice.multiply(new BigDecimal(quantityForSale));

            order.setTotalAmount(totalAmount);
            orderDao.createOrder(order);
        }
    }

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public List<Order> getAllOrdersByEmployeeId(int id) {
        return orderDao.getAllOrdersByEmployeeId(id);
    }

    public Order getOrderById(long id) {
        return orderDao.getOrderById(id);
    }

    public Order getOrderByIdAndEmployeeId(long orderId, int employeeId) {
        return orderDao.getOrderByIdAndEmployeeId(orderId, employeeId);
    }

    public Map<String, String> showOrderDetails(long id) {
        Map<String, String> orderDetails = new HashMap<>();
        Order order = getOrderById(id);

        long orderId = order.getOrderId();
        long productId = order.getProductId();
        int employeeId = order.getEmployeeId();
        int productQuantity = order.getProductQuantity();
        BigDecimal totalAmount = order.getTotalAmount();
        Timestamp orderDate = order.getOrderDate();

        Product product = productService.getProductById(productId);
        Employee employee = employeeService.getEmployeeById(employeeId);

        String productName = product.getProductName();
        String employeeName = employee.getEmployeeName();
        EmployeePosition employeePosition = employee.getEmployeePosition();

        orderDetails.put("order_id", Long.toString(orderId));
        orderDetails.put("product_id", Long.toString(productId));
        orderDetails.put("product_name", productName);
        orderDetails.put("product_quantity", Integer.toString(productQuantity));
        orderDetails.put("employee_name", employeeName);
        orderDetails.put("employee_position", employeePosition.toString());
        orderDetails.put("total_amount", totalAmount.toString());
        orderDetails.put("order_date", String.valueOf(orderDate));

        return orderDetails;
    }

    public Map<String, String> showOrderDetails(long orderId, int employeeId) {
        Map<String, String> orderDetails = new HashMap<>();
        Order order = getOrderByIdAndEmployeeId(orderId, employeeId);

        long productId = order.getProductId();
        int productQuantity = order.getProductQuantity();
        BigDecimal totalAmount = order.getTotalAmount();
        Timestamp orderDate = order.getOrderDate();

        Product product = productService.getProductById(productId);
        Employee employee = employeeService.getEmployeeById(employeeId);

        String productName = product.getProductName();
        String employeeName = employee.getEmployeeName();
        EmployeePosition employeePosition = employee.getEmployeePosition();

        orderDetails.put("order_id", Long.toString(orderId));
        orderDetails.put("product_id", Long.toString(productId));
        orderDetails.put("product_name", productName);
        orderDetails.put("product_quantity", Integer.toString(productQuantity));
        orderDetails.put("employee_name", employeeName);
        orderDetails.put("employee_position", employeePosition.toString());
        orderDetails.put("total_amount", totalAmount.toString());
        orderDetails.put("order_date", String.valueOf(orderDate));

        return orderDetails;
    }
}
