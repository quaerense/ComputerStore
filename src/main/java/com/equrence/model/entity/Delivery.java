package com.equrence.model.entity;

import java.sql.Date;

public class Delivery {
    private long deliveryId;
    private int supplierId;
    private Date deliveryDate;

    public Delivery() {
    }

    public long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Deliveries{" +
                "deliveryId=" + deliveryId +
                ", supplierId=" + supplierId +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
