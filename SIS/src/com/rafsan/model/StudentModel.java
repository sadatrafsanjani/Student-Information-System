package com.rafsan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class StudentModel {

    private final Connection connect;
    private final DatabaseModel model;
    private TableModel table;; 

    public StudentModel() {

        model = new DatabaseModel();
        model.dbConnector();
        connect = model.getConnect();
    }

    public void showStudent() {

        PreparedStatement statement;
        ResultSet result;
        
        try {
            String sql = "SELECT * FROM student";
            statement = connect.prepareStatement(sql);
            result = statement.executeQuery();
            table = DbUtils.resultSetToTableModel(result);
            statement.close();
            connect.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database read error!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public TableModel getTable(){
    
        return table;
    }
}
