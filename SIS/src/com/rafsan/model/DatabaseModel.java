package com.rafsan.model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DatabaseModel {

    private Connection connect;
    
    public void dbConnector(){
    
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:D:\\Java\\SIS\\resource\\database\\information.sqlite");
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Database connection failed");
        }       
    }
    
    public Connection getConnect(){
    
        return connect;
    }
}
