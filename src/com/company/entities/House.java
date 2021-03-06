package com.company.entities;

import com.company.entities.interfaces.IHouse;

public class House extends Property implements IHouse {
    public static double discount;

    public House() {
    }

    public House(String type, String location, int rooms, boolean hasOwner, double price) {
        super(type, location, rooms, hasOwner, price);
    }

    public String onSelling() {return super.getType() + " which is located in " + super.getLocation() + " is on the market for buying";}

    public String beSold() {return super.getType() + " which is located in " + super.getLocation() + " is being sold to a customer";}

    public void setDiscount(double discount) {this.discount = discount;}

    public static double getDiscount() {
        return discount;
    }

    public void houseInfo(){
        System.out.println(onSelling());
        System.out.println(beSold());
    }

}
