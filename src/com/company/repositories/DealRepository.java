package com.company.repositories;

import com.company.data.interfaces.IDBManager;
import com.company.entities.*;
import com.company.repositories.interfaces.IDealRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DealRepository implements IDealRepository {
    private final IDBManager dbManager;

    public DealRepository(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    public Customer getCustomerById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Customer customer = new Customer();

            if (resultSet.next()) {
                customer.setId(resultSet.getInt("customer_id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setAge(resultSet.getInt("age"));
                customer.setBankAccount(resultSet.getDouble("bankAccount"));
            }

            return customer;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Property getPropertyById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM properties WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Property property = new Property();

            if (resultSet.next()) {
                property.setId(resultSet.getInt("property_id"));
                property.setType(resultSet.getString("type"));
                property.setLocation(resultSet.getString("location"));
                property.setRooms(resultSet.getInt("rooms"));
                property.setHasOwner(resultSet.getBoolean("hasOwner"));
                property.setPrice(resultSet.getDouble("price"));
                property.setCustomerId(resultSet.getInt("customer_id"));
            }

            return property;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addCustomer(Customer customer) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers (name, surname, age, bankAccount) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getSurname());
            preparedStatement.setInt(3, customer.getAge());
            preparedStatement.setDouble(4, customer.getBankAccount());

            preparedStatement.execute();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addProperty(Property property) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            if (property.getCustomerId() == null) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO properties (type, location, rooms, hasOwner, price) VALUES (?, ?, ?, ?, ?)");

                preparedStatement.setString(1, property.getType());
                preparedStatement.setString(2, property.getLocation());
                preparedStatement.setInt(3, property.getRooms());
                preparedStatement.setBoolean(4, property.isHasOwner());
                preparedStatement.setDouble(5, property.getPrice());

                preparedStatement.execute();
            }
            else {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO properties (type, location, rooms, hasOwner, price, customer_id) VALUES (?, ?, ?, ?, ?, ?)");

                preparedStatement.setString(1, property.getType());
                preparedStatement.setString(2, property.getLocation());
                preparedStatement.setInt(3, property.getRooms());
                preparedStatement.setBoolean(4, property.isHasOwner());
                preparedStatement.setDouble(5, property.getPrice());
                preparedStatement.setInt(6, property.getCustomerId().intValue());


                preparedStatement.execute();
            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean makeDeal(Deal deal) {
        Connection connection = null;

        try {
        connection = dbManager.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO deals ( customer_id, property_id, finished) VALUES (?, ?, ?)");

        preparedStatement.setInt(1, deal.getCustomer_id());
        preparedStatement.setInt(2, deal.getProperty_id());
        if (getCustomerById(deal.getCustomer_id()).getAge() < 18 || getCustomerById(deal.getCustomer_id()).getBankAccount() < getPropertyById(deal.getProperty_id()).getPrice() || getPropertyById(deal.getProperty_id()).isHasOwner()) {
            preparedStatement.setBoolean(3, false);

            preparedStatement.execute();
            return false;
        }
        preparedStatement.setBoolean(3, true);

        preparedStatement.execute();

        preparedStatement = connection.prepareStatement("UPDATE customers SET bankAccount=(SELECT customers WHERE id=?)-?-? WHERE id=?");

        preparedStatement.setInt(1, getCustomerById(deal.getCustomer_id()).getId());

        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM properties WHERE id=?");

        preparedStatement1.setInt(1, getPropertyById(deal.getProperty_id()).getId());

        ResultSet resultSet = preparedStatement1.executeQuery();

        Property property = new Property();

        if (resultSet.next()) {
            property.setId(resultSet.getInt("property_id"));
            property.setType(resultSet.getString("type"));
            property.setLocation(resultSet.getString("location"));
            property.setRooms(resultSet.getInt("rooms"));
            property.setHasOwner(resultSet.getBoolean("hasOwner"));
            property.setPrice(resultSet.getDouble("price"));
            property.setCustomerId(resultSet.getInt("customer_id"));
        }

        if (property.getType().equals("Flat")) {
            Flat flat = (Flat) property;

            preparedStatement.setDouble(2, flat.getPrice());
            preparedStatement.setDouble(3, flat.getPublicServices());
            flat.flatInfo();
        } else if (property.getType().equals("House")) {
            House house = (House) property;

            preparedStatement.setDouble(2, house.getPrice());
            preparedStatement.setDouble(3, house.getDiscount());
            house.houseInfo();
        }

        preparedStatement.setInt(4, getCustomerById(deal.getCustomer_id()).getId());

        preparedStatement.execute();

        preparedStatement = connection.prepareStatement("UPDATE properties SET hasOwner=true, customer_id=? WHERE id=?");

        preparedStatement.setInt(1, getCustomerById(deal.getCustomer_id()).getId());
        preparedStatement.setInt(2, getPropertyById(deal.getProperty_id()).getId());

        preparedStatement.execute();

        getCustomerById(deal.getCustomer_id()).customerInfo();

        return true;
    }
        catch (Exception e) {
        e.printStackTrace();
    }

        return false;
}

    public boolean addMoneyToBankAccount(int id, double money) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customers SET bankAccount=(SELECT customers WHERE id=?)+? WHERE id=?");

            preparedStatement.setInt(1, id);
            preparedStatement.setDouble(2, money);
            preparedStatement.setInt(3, id);

            preparedStatement.execute();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean setDiscountForHouses(double discount) {
        try {
            House.discount = discount;

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean setPublicServicesForFlats(double publicServices) {
        try {
            Flat.publicServices = publicServices;

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Customer> showCustomers() {
        Connection connection = null;

        try {
            connection = dbManager.getConnection(); //connection with database

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers"); //sql statement

            ResultSet resultSet = preparedStatement.executeQuery(); //executeQuery method to change the data from the database into String data type

            ArrayList<Customer> customers = new ArrayList<>(); //arraylist of customers

            while(resultSet.next()) { //iteration through resultSet from the database
                Customer customer = new Customer(resultSet.getInt("customer_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getDouble("bankAccount"));

                customers.add(customer); //add a customer to the arraylist
            }

            return customers;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Property> showAvailableProperty() {
        Connection connection = null;

        try {
            connection = dbManager.getConnection(); //connection with database

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM properties WHERE hasOwner=0"); //sql statement

            ResultSet resultSet = preparedStatement.executeQuery(); //executeQuery method to change the data from the database into String data type

            ArrayList<Property> properties = new ArrayList<>(); //arraylist of properties

            while(resultSet.next()) { //iteration through resultSet from the database
                Property property = new Property(resultSet.getInt("property_id"),
                        resultSet.getString("type"),
                        resultSet.getString("location"),
                        resultSet.getInt("rooms"),
                        resultSet.getBoolean("hasOwner"),
                        resultSet.getInt("customer_id"));

                properties.add(property); //add a property to the arraylist
            }

            return properties;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Deal> showDeals() {
        Connection connection = null;

        try {
            connection = dbManager.getConnection(); //connection with database

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM deals"); //sql statement

            ResultSet resultSet = preparedStatement.executeQuery(); //executeQuery method to change the data from the database into String data type

            ArrayList<Deal> deals = new ArrayList<>(); //arraylist of deals

            while(resultSet.next()) { //iteration through resultSet from the database
                Deal deal = new Deal(resultSet.getInt("deal_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("property_id"),
                        resultSet.getBoolean("finished"));

                deals.add(deal); //add a deal to the arraylist
            }

            return deals;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
