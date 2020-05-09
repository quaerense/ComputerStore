package com.equrence.model.service;

import com.equrence.model.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    void createOrder(Order order);

    List<Order> getAllOrders();

    List<Order> getAllOrdersByEmployeeId(int id);

    Order getOrderById(long id);

    Order getOrderByIdAndEmployeeId(long orderId, int employeeId);

    Map<String, String> showOrderDetails(long id);

    Map<String, String> showOrderDetails(long orderId, int employeeId);
}
