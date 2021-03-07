package com.company;

import com.company.controllers.DealController;
import com.company.data.DBManager;
import com.company.data.interfaces.IDBManager;
import com.company.repositories.DealRepository;
import com.company.repositories.interfaces.IDealRepository;

public class Main {

    public static void main(String[] args) {
        IDBManager dbManager = new DBManager(); //database manager
        IDealRepository dealRepository = new DealRepository(dbManager); //repository
        DealController dealController = new DealController(dealRepository); //controller
        MyApplication myApplication = new MyApplication(dealController); //application
        myApplication.start(); //starting the application
    }
}
