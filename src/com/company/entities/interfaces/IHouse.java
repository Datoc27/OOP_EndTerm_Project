package com.company.entities.interfaces;

public interface IHouse extends IProperty{ //house interface which is derived from property interface
    String beSold();
    void setDiscount(double discount);
}
