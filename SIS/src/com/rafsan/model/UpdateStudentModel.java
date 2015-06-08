package com.rafsan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UpdateStudentModel {
    
    private final DatabaseModel model;
    private final Connection connect;
    private boolean status;
    private int studentId;
    private int studentRoll;
    private String studentName;
    private String studentFather;
    private String studentMother;
    private String studentAddress;
    
    public UpdateStudentModel(){
    
        model = new DatabaseModel();
        model.dbConnector();
        connect = model.getConnect();
    }
    
    public void getStudentByRoll(int roll){
    
        PreparedStatement statement;
        ResultSet result;
        
        try {
            String sql = "SELECT * FROM student WHERE student_roll=?";
            statement = connect.prepareStatement(sql);
            statement.setInt(1,roll);
            result = statement.executeQuery();
            if(result.next()){
            
                status = true;
                studentId = result.getInt("student_id");
                studentRoll = result.getInt("student_roll");
                studentName = result.getString("student_name");
                studentFather = result.getString("student_father");
                studentMother = result.getString("student_mother");
                studentAddress = result.getString("student_address");
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
    
    public void updateStudentByRoll(int id,int roll, String sName, String fName, String mName, String sAddress){
    
        PreparedStatement statement;
        
        try {
            String sql = "UPDATE student SET "
                    + "student_roll=?,"
                    + "student_name=?,"
                    + "student_father=?,"
                    + "student_mother=?,"
                    + "student_address=?"
                    + "WHERE student_id=?";
            statement = connect.prepareStatement(sql);
            statement.setInt(1,roll);
            statement.setString(2,sName);
            statement.setString(3,fName);
            statement.setString(4,mName);
            statement.setString(5,sAddress);
            statement.setInt(6,id);
            statement.executeUpdate();
            statement.close();
            JOptionPane.showMessageDialog(null, "Database Updated!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not update!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean getStatus(){
    
        return status;
    }
    
    public String getId(){
    
        return Integer.toString(studentId);
    }
    
    public String getRoll(){
    
        return Integer.toString(studentRoll);
    }
    
    public String getName(){
    
        return studentName;
    }
    
    public String getFather(){
    
        return studentFather;
    }
    
    public String getMother(){
    
        return studentMother;
    }
    
    public String getAddress(){
    
        return studentAddress;
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
