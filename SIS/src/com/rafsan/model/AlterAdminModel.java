package com.rafsan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AlterAdminModel {
    
    private final DatabaseModel model;
    private final Connection connect;
    private boolean status;
    private int adminId;
    private String adminName;
    private String adminPassword;
    
    public AlterAdminModel(){
    
        model = new DatabaseModel();
        model.dbConnector();
        connect = model.getConnect();
    }
    
    public void getAdminByName(String name){
    
        PreparedStatement statement;
        ResultSet result;
        
        try {
            String sql = "SELECT * FROM admin WHERE admin_name=?";
            statement = connect.prepareStatement(sql);
            statement.setString(1,name);
            result = statement.executeQuery();
            if(result.next()){
            
                status = true;
                adminId = result.getInt("admin_id");
                adminName = result.getString("admin_name");
                adminPassword = result.getString("admin_password");
            }
            else{
                status = false;
                JOptionPane.showMessageDialog(null, "Record Not Found");
            }
            statement.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Couldn't Retrive Record!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void alterAdminById(int id,String name,String password){
    
        PreparedStatement statement;
        
        try {
            String sql = "UPDATE admin SET "
                    + "admin_name=?,"
                    + "admin_password=?"
                    + "WHERE admin_id=?";
            statement = connect.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,password);
            statement.setInt(3,id);
            statement.executeUpdate();
            statement.close();
            JOptionPane.showMessageDialog(null, "Database Altered!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Couldn't be Altered!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean getStatus(){
    
        return status;
    }
    
    public String getId(){
    
        return Integer.toString(adminId);
    }
    
    public String getAname(){
    
        return adminName;
    }
    
    public String getApassword(){
    
        return adminPassword;
    }
    
    public void closeConnection(){
    
        if(connect != null){
        
            try {
                connect.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error Closing Connection!","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
