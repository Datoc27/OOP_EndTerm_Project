package com.company.entities;

import com.company.entities.interfaces.IFlat;

public class Flat extends Property implements IFlat {
    public static double publicServices;

    public Flat() {
    } //1st constructor

    public Flat(String type, String location, int rooms, boolean hasOwner, double price) {
        super(type, location, rooms, hasOwner, price);
    } //2nd constructor

    public String onSelling() {return super.getType() + " which is located in " + super.getLocation() + " is on the market for renting";}

    public String beRented() {return super.getType() + " which is located in " + super.getLocation() + " is being rented by a customer";}

    public void setPublicService(double publicServicePrice) {this.publicServices = publicServicePrice;}

    public static double getPublicServices() {
        return publicServices;
    }

    public void flatInfo(){
        System.out.println(onSelling());
        System.out.println(beRented());
    }
}
