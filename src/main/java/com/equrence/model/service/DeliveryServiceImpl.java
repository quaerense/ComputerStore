package com.equrence.model.service;

import com.equrence.model.dao.DeliveryDao;
import com.equrence.model.dao.DeliveryDaoImpl;
import com.equrence.model.entity.Delivery;

import java.util.List;

public class DeliveryServiceImpl implements DeliveryService {
    DeliveryDao dao = new DeliveryDaoImpl();

    public void addDelivery(Delivery delivery) {
        dao.addDelivery(delivery);
    }

    public List<Delivery> getAllDeliveries() {
        return dao.getAllDeliveries();
    }

    public Delivery getDeliveryById(long id) {
        return dao.getDeliveryById(id);
    }

    public void editDeliveryInfo(long id, Delivery delivery) {
        dao.editDeliveryInfo(id, delivery);
    }

    public void deleteDelivery(long id) {
        dao.deleteDelivery(id);
    }
}
