package com.rafsan.controller;

import com.rafsan.model.UpdateStudentModel;
import com.rafsan.view.UpdateStudentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UpdateStudentController {
    
    private final UpdateStudentModel model;
    private final UpdateStudentView view;
    
    public UpdateStudentController(UpdateStudentModel m,UpdateStudentView v){
    
        model = m;
        view = v;
        
        view.searchButtonListener(new SearchListener());
        view.submitButtonListener(new SubmitListener());
        view.cancelButtonListener(new CancelListener());
        view.closeWindowListener(new CloseListener());
    }
    
    class SearchListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            model.getStudentByRoll(view.getStudentRoll());
            
            if(model.getStatus()){
                view.setPermissionOn();
                view.setRoll(model.getRoll());
                view.setSname(model.getName());
                view.setFname(model.getFather());
                view.setMname(model.getMother());
                view.setAddress(model.getAddress());
                view.submitButtonVisibilityOn();
            }
            else{
                view.setPermissionOff();
                view.setRoll(null);
                view.setSname(null);
                view.setFname(null);
                view.setMname(null);
                view.setAddress(null);
            }
        }
    }
    
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            int id = Integer.parseInt(model.getId());
            int roll = view.getRoll();
            String sName = view.getSname();
            String fName = view.getFname();
            String mName = view.getMname();
            String sAddress = view.getAddress();
            model.updateStudentByRoll(id,roll, sName, fName, mName, sAddress);
        }
    }
    
    class CancelListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
           
            view.setPermissionOff();
            view.setRoll(null);
            view.setSname(null);
            view.setFname(null);
            view.setMname(null);
            view.setAddress(null);
            view.submitButtonVisibilityOff();
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
