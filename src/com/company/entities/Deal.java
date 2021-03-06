package com.company.entities;

import com.company.entities.interfaces.IDeal;

public class Deal implements IDeal {
    private int id;
    private int customer_id;
    private int property_id;
    private boolean finished;

    public Deal() {
    }

    public Deal(int customer_id, int property_id, boolean finished) {
        this.customer_id = customer_id;
        this.property_id = property_id;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
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
                ", customer_id=" + customer_id +
                ", property_id=" + property_id +
                ", finished=" + finished +
                '}';
    }
}
