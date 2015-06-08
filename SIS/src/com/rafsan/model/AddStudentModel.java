package com.rafsan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AddStudentModel {

    private final Connection connect;
    private final DatabaseModel model;

    public AddStudentModel() {

        model = new DatabaseModel();
        model.dbConnector();
        connect = model.getConnect();
    }

    public void addStudent(int roll, String sName, String fName, String mName, String sAddress) {

        PreparedStatement statement;

        try {
            String sql = "INSERT INTO student "
                    + "(student_roll,student_name,student_father,student_mother,student_address) "
                    + "VALUES (?,?,?,?,?)";
            statement = connect.prepareStatement(sql);
            statement.setInt(1, roll);
            statement.setString(2, sName);
            statement.setString(3, fName);
            statement.setString(4, mName);
            statement.setString(5, sAddress);
            statement.execute();
            statement.close();
            JOptionPane.showMessageDialog(null, "Data Saved Successfully!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database insert error!", "Error", JOptionPane.ERROR_MESSAGE);
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
