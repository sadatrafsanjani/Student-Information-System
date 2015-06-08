package com.rafsan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DumpAdminModel {
    
    private final DatabaseModel model;
    private final Connection connect;
    private boolean status;
    private int adminId;
        
    public DumpAdminModel(){
    
        model = new DatabaseModel();
        model.dbConnector();
        connect = model.getConnect();
    }
    
    public void getAdminByName(String name){
    
        PreparedStatement statement;
        ResultSet result;
        
        try {
            String sql = "SELECT admin_id FROM admin WHERE admin_name=?";
            statement = connect.prepareStatement(sql);
            statement.setString(1,name);
            result = statement.executeQuery();
            if(result.next()){
            
                status = true;
                adminId = result.getInt("admin_id");
                JOptionPane.showMessageDialog(null, "Record Found");
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
    
    public void dumpAdminById(int id){
    
        PreparedStatement statement;
        
        try {
            String sql = "DELETE FROM admin "
                    + "WHERE admin_id=?";
            statement = connect.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
            JOptionPane.showMessageDialog(null, "Admin Dumped!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Couldn't Dump!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean getStatus(){
    
        return status;
    }
    
    public String getId(){
    
        return Integer.toString(adminId);
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
