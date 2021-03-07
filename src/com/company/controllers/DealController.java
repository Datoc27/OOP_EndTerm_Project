package com.company.controllers;

import com.company.entities.Customer;
import com.company.entities.Deal;
import com.company.entities.Property;
import com.company.repositories.interfaces.IDealRepository;

public class DealController {
    private final IDealRepository dealRepository;

    public DealController(IDealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public String getCustomerById(int id) {
        return dealRepository.getCustomerById(id).toString();
    }

    public String getPropertyById(int id) {
        return dealRepository.getPropertyById(id).toString();
    }

    public String addCustomer(String name, String surname, int age, double bankAccount) {

        boolean added = dealRepository.addCustomer(new Customer(name, surname, age, bankAccount));

        if (added) {
            return "The customer was successfully added to the database!";
        }
        return "An error occurred!";
    }

    public String addProperty(String type, String location, int rooms, boolean hasOwner, double price) {

        boolean added = dealRepository.addProperty(new Property(type, location, rooms, hasOwner, price));

        if (added) {
            return "The property was successfully added to the database!";
        }
        return "An error occurred!";
    }

    public String makeDeal(int customer_id, int property_id) {

        boolean made = dealRepository.makeDeal(new Deal(customer_id, property_id, false));

        if (made) {
            return "The deal has successfully finished. Congratulations!!!";
        }
        return "An error occurred!";
    }

    public String addMoneyToBankAccount(int id, int money) {

        boolean added = dealRepository.addMoneyToBankAccount(id, money);

        if (added) {
            return "The data was updated!!";
        }
        return "An error occurred!";
    }

    public String setDiscountForHouses(double discount) {

        boolean set = dealRepository.setDiscountForHouses(discount);

        if (set) {
            return "The discount for houses was set!!";
        }
        return "An error occurred!";
    }

    public String setPublicServicesForFlats(double publicServices) {

        boolean set = dealRepository.setPublicServicesForFlats(publicServices);

        if (set) {
            return "The cost of public services was updated!!";
        }
        return "An error occurred!";
    }

    public String showCustomers() {
        return dealRepository.showCustomers().toString();
    }

    public String showAvailableProperty() {
        return dealRepository.showAvailableProperty().toString();
    }

    public String showDeals() {
        return dealRepository.showDeals().toString();
    }
}
