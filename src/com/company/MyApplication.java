package com.company;

import com.company.controllers.DealController;

import java.util.Scanner;

public class MyApplication {
    private final DealController dealController;
    private final Scanner scanner;

    public MyApplication(DealController employeeController) {
        this.dealController = employeeController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while(true) { //choice menu
            System.out.println("1. Get customer by id\n" +
                    "2. Get property by id\n" +
                    "3. Add a customer to the database\n" +
                    "4. Add a new property to the database\n" +
                    "5. Make a deal\n" +
                    "6. Update customer's bank account data\n" +
                    "7. Set discount for houses\n" +
                    "8. Set cost for public services for flats\n" +
                    "9. Show all customers in the database\n" +
                    "10. Show all available houses\n" +
                    "11. Show all available houses\n" +
                    "0. Exit\n");
            int operation = scanner.nextInt();

            switch(operation) {
                case 1:
                    getCustomerByIdMenu();
                    break;
                case 2:
                    getPropertyByIdMenu();
                    break;
                case 3:
                    addCustomerMenu();
                    break;
                case 4:
                    addPropertyMenu();
                    break;
                case 5:
                    makeDealMenu();
                    break;
                case 6:
                    addMoneyToBankAccountMenu();
                    break;
                case 7:
                    setDiscountForHousesMenu();
                    break;
                case 8:
                    setPublicServicesForFlatsMenu();
                    break;
                case 9:
                    showCustomersMenu();
                    break;
                case 10:
                    showAvailablePropertyMenu();
                    break;
                case 11:
                    showDealsMenu();
                    break;
                default:
                    System.exit(0);
                    break;
            }

            System.out.println("*****************");
        }

    }

    public void getCustomerByIdMenu() {
        System.out.println("Type the id of the customer:");
        int id = scanner.nextInt();

        String result = dealController.getCustomerById(id);

        System.out.println(result);
    }

    public void getPropertyByIdMenu() {
        System.out.println("Type the id of the property:");
        int id = scanner.nextInt();

        String result = dealController.getPropertyById(id);

        System.out.println(result);
    }

    public void addCustomerMenu() {
        System.out.println("Type the name of the customer:");
        String name = scanner.next();
        System.out.println("Type the surname of the employee:");
        String surname = scanner.next();
        System.out.println("Type the age of the customer:");
        int age= scanner.nextInt();
        System.out.println("Type the money in bank account of the customer:");
        double bankAccount= scanner.nextDouble();

        String result = dealController.addCustomer(name, surname, age, bankAccount);

        System.out.println(result);
    }

    public void addPropertyMenu() {
        System.out.println("Type the type of the property(Flat or House):");
        String type = scanner.next();
        System.out.println("Type the location of the property:");
        String location = scanner.next();
        System.out.println("Type the number of rooms of the property:");
        int rooms= scanner.nextInt();
        System.out.println("Type the price of the property:");
        double price= scanner.nextDouble();

        String result = dealController.addProperty(type, location, rooms, false, price);

        System.out.println(result);
    }

    public void makeDealMenu() {
        System.out.println("Type the id of the customer:");
        int customer_id = scanner.nextInt();
        System.out.println("Type the id of the property:");
        int property_id = scanner.nextInt();

        String result = dealController.makeDeal(customer_id, property_id);

        System.out.println(result);
    }

    public void addMoneyToBankAccountMenu() {
        System.out.println("Type the id of the customer:");
        int customer_id = scanner.nextInt();
        System.out.println("Type the sum to add:");
        int money = scanner.nextInt();

        String result = dealController.addMoneyToBankAccount(customer_id, money);

        System.out.println(result);
    }

    public void setDiscountForHousesMenu() {
        System.out.println("Type the discount for houses:");
        double discount = scanner.nextDouble();

        String result = dealController.setDiscountForHouses(discount);

        System.out.println(result);
    }

    public void setPublicServicesForFlatsMenu() {
        System.out.println("Type the cost for the public services for flats:");
        double publicServices = scanner.nextDouble();

        String result = dealController.setPublicServicesForFlats(publicServices);

        System.out.println(result);
    }

    public void showCustomersMenu() {
        String result = dealController.showCustomers();

        System.out.println(result);
    }

    public void showAvailablePropertyMenu() {
        String result = dealController.showAvailableProperty();

        System.out.println(result);
    }

    public void showDealsMenu() {
        String result = dealController.showDeals();

        System.out.println(result);
    }
}
