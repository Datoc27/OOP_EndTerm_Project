package com.company.entities;

import com.company.entities.interfaces.ICustomer;

public class Customer implements ICustomer {
    private int id;
    private String name;
    private String surname;
    private int age;
    private double bankAccount;

    public Customer() {
    }

    public Customer(String name, String surname, int age, double bankAccount) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bankAccount = bankAccount;
    }

    public Customer(int id, String name, String surname, int age, double bankAccount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bankAccount = bankAccount;
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

    public String lookFor() {return this.getName() + " " + this.getSurname() + " is looking for a beautiful place to live";}

    public String buyProperty() {return this.getName() + " " + this.getSurname() + " has bought a new property. There is " + this.getBankAccount() + " left in their bank account!";}

    public void customerInfo(){
        System.out.println(lookFor());
        System.out.println(buyProperty());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
