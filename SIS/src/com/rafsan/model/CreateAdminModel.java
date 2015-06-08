package com.rafsan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CreateAdminModel {

    private final Connection connect;
    private final DatabaseModel model;

    public CreateAdminModel() {

        model = new DatabaseModel();
        model.dbConnector();
        connect = model.getConnect();
    }

    public void createAdmin(String name, String password) {

        PreparedStatement statement;

        try {
            String sql = "INSERT INTO admin "
                    + "(admin_name,admin_password) "
                    + "VALUES (?,?)";
            statement = connect.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.execute();
            statement.close();
            JOptionPane.showMessageDialog(null, "Admin Created!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Admin Couldn't be Created!", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
