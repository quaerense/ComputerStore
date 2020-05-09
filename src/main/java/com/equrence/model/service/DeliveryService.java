package com.equrence.model.service;

import com.equrence.model.entity.Delivery;

import java.util.List;

public interface DeliveryService {
    void addDelivery(Delivery delivery);

    List<Delivery> getAllDeliveries();

    Delivery getDeliveryById(long id);

    void editDeliveryInfo(long id, Delivery delivery);

    void deleteDelivery(long id);
}
