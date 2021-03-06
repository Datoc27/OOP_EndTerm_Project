package com.company.entities;

import com.company.entities.interfaces.ICustomer;

public class Customer implements ICustomer {
    private int id;
    private String name;
    private String surname;
    private int age;
    private double bankAccount;
    private int propertyId;

    public Customer() {
    }

    public Customer(String name, String surname, int age, double bankAccount, int propertyId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bankAccount = bankAccount;
        this.propertyId = propertyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(double bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String lookFor() {return this.getName() + " " + this.getSurname() + " is looking for a neautiful place to live";}

    public void customerInfo(){
        System.out.println(lookFor());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", bankAccount=" + bankAccount +
                ", propertyId=" + propertyId +
                '}';
    }
}
