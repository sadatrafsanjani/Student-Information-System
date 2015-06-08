package com.rafsan.controller;

import com.rafsan.model.AddStudentModel;
import com.rafsan.view.AddStudentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddStudentController {
    
    private final AddStudentModel model;
    private final AddStudentView view;
    
    public AddStudentController(AddStudentModel m,AddStudentView v){
    
        model = m;
        view = v;
        
        view.submitButtonListener(new SubmitListener());
        view.cancelButtonListener(new CancelListener());
        view.closeWindowListener(new CloseListener());
    }
    
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            int roll = view.getRoll();
            String sName = view.getSname();
            String fName = view.getFname();
            String mName = view.getMname();
            String sAddress = view.getAddress();
            model.addStudent(roll, sName, fName, mName, sAddress);
        }
    }
    
    class CancelListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            view.setRoll();
            view.setSname();
            view.setFname();
            view.setMname();
            view.setAddress();
        }
    }
    
    class CloseListener extends WindowAdapter{
       
        @Override
        public void windowClosing(WindowEvent e) {
        
            model.closeConnection();
            view.setVisible(false);
            view.dispose();
        }
    }
}
