package com.equrence.model.dao;

import com.equrence.model.entity.Order;

import java.util.List;

public interface OrderDao {
    void createOrder(Order order);

    List<Order> getAllOrders();

    List<Order> getAllOrdersByEmployeeId(int id);

    Order getOrderById(long id);

    Order getOrderByIdAndEmployeeId(long orderId, int employeeId);
}
