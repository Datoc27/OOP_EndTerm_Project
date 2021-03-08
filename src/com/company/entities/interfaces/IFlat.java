package com.company.entities.interfaces;

public interface IFlat extends IProperty { //flat interface which is derived from property interface
    String beRented();
    void setPublicService(double publicServicePrice);
}
