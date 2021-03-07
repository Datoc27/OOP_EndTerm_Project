package com.company.repositories;

import com.company.data.interfaces.IDBManager;
import com.company.repositories.interfaces.IDealRepository;

public class DealRepository implements IDealRepository {
    private final IDBManager dbManager;

    public DealRepository(IDBManager dbManager) {
        this.dbManager = dbManager;
    }


}
