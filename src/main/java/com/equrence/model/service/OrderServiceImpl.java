package com.equrence.model.service;

import com.equrence.model.dao.OrderDao;
import com.equrence.model.dao.OrderDaoImpl;
import com.equrence.model.entity.Employee;
import com.equrence.model.entity.Order;
import com.equrence.model.entity.Product;
import com.equrence.model.entity.enumeration.EmployeePosition;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private final ProductServiceImpl productService = new ProductServiceImpl();
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    private final OrderDao dao = new OrderDaoImpl();

    public void createOrder(Order order) {
        BigDecimal costOfOneProduct = productService.getProductById(order.getProductId()).getSellingPrice();
        int quantity = order.getProductQuantity();

        BigDecimal totalCost = costOfOneProduct.multiply(new BigDecimal(quantity));

        order.setTotalAmount(totalCost);

        dao.createOrder(order);
    }

    public List<Order> getAllOrders() {
        return dao.getAllOrders();
    }

    public List<Order> getAllOrdersByEmployeeId(int id) {
        return dao.getAllOrdersByEmployeeId(id);
    }

    public Order getOrderById(long id) {
        return dao.getOrderById(id);
    }

    public Order getOrderByIdAndEmployeeId(long orderId, int employeeId) {
        return dao.getOrderByIdAndEmployeeId(orderId, employeeId);
    }

    public Map<String, String> showOrderDetails(long id) {
        Map<String, String> orderDetails = new HashMap<>();
        Order order = getOrderById(id);

        if (order != null) {
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

        return null;
    }

    public Map<String, String> showOrderDetails(long orderId, int employeeId) {
        Map<String, String> orderDetails = new HashMap<>();
        Order order = getOrderByIdAndEmployeeId(orderId, employeeId);

        if (order != null) {
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

        return null;
    }
}
