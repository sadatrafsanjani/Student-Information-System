package com.rafsan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DeleteStudentModel {
    
    private final DatabaseModel model;
    private final Connection connect;
    private boolean status;
    private int studentId;
        
    public DeleteStudentModel(){
    
        model = new DatabaseModel();
        model.dbConnector();
        connect = model.getConnect();
    }
    
    public void getStudentByRoll(int roll){
    
        PreparedStatement statement;
        ResultSet result;
        
        try {
            String sql = "SELECT student_id FROM student WHERE student_roll=?";
            statement = connect.prepareStatement(sql);
            statement.setInt(1,roll);
            result = statement.executeQuery();
            if(result.next()){
            
                status = true;
                studentId = result.getInt("student_id");
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
    
    public void deleteStudentById(int id){
    
        PreparedStatement statement;
        
        try {
            String sql = "DELETE FROM student "
                    + "WHERE student_id=?";
            statement = connect.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
            JOptionPane.showMessageDialog(null, "Database Deleted!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Couldn't Delete!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean getStatus(){
    
        return status;
    }
    
    public String getId(){
    
        return Integer.toString(studentId);
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
