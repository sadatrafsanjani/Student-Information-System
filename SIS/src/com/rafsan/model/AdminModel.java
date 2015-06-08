package com.rafsan.model;

import java.sql.Connection;

public class AdminModel {
    
    private final Connection connect;
    private final DatabaseModel model;
    
    public AdminModel(){
    
        model = new DatabaseModel();
        model.dbConnector();
        connect = model.getConnect();
    }
}
