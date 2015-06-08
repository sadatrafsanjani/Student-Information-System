package com.rafsan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginModel {
    
    private final DatabaseModel model;
    private final Connection connect;
    private boolean status = false;
    
    public LoginModel(){
    
        model = new DatabaseModel();
        model.dbConnector();
        connect = model.getConnect();
    }
    
    public void makeLogin(String username, String password){
    
        PreparedStatement statement;
        ResultSet result;
        
        try {
            String sql = "SELECT * FROM admin WHERE admin_name=? AND admin_password=?";
            statement = connect.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            result = statement.executeQuery();
            status = result.next();
            connect.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not log in!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean getStatus(){
    
        return status;
    }
}
