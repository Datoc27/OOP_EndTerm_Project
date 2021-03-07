package com.company.repositories.interfaces;

import com.company.entities.Customer;
import com.company.entities.Deal;
import com.company.entities.Property;

import java.util.ArrayList;

public interface IDealRepository {
    boolean addCustomer(Customer customer); // add customers to the database
    boolean addProperty(Property property); // add property to the database
    boolean makeDeal(Deal deal); // make a deal
    boolean addMoneyToBankAccount(int id, double money); // adding money to one's bank account
    boolean setDiscountForHouses(double discount); // setting discount for houses
    boolean setPublicServicesForFlats(double publicServices); // setting money for public services
    ArrayList<Customer> showCustomers(); // show all customers
    ArrayList<Property> showAvailableProperty(); // properties with no owner
    ArrayList<Deal> showDeals(); // show all deals
}
