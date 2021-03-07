package com.company.entities;

import com.company.entities.interfaces.IDeal;

public class Deal implements IDeal {
    private int id;
    private int customerId;
    private int propertyId;
    private boolean finished;

    public Deal() {
    }

    public Deal(int id, int customerId, int propertyId) {
        this.id = id;
        this.customerId = customerId;
        this.propertyId = propertyId;
    }

    public Deal(int customerId, int propertyId, boolean finished) {
        this.customerId = customerId;
        this.propertyId = propertyId;
        this.finished = finished;
    }

    public Deal(int id, int customerId, int propertyId, boolean finished) {
        this.id = id;
        this.customerId = customerId;
        this.propertyId = propertyId;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customerId;
    }

    public void setCustomer_id(int customerId) {
        this.customerId = customerId;
    }

    public int getProperty_id() {
        return propertyId;
    }

    public void setProperty_id(int propertyId) {
        this.propertyId = propertyId;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String happen() {return "The deal is going to be completed!";}

    public void dealInfo(){
        System.out.println(happen());
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", customer_id=" + customerId +
                ", property_id=" + propertyId +
                ", finished=" + finished +
                '}';
    }
}
