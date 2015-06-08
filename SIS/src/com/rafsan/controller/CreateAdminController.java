package com.rafsan.controller;

import com.rafsan.model.CreateAdminModel;
import com.rafsan.view.CreateAdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CreateAdminController {
    
    private final CreateAdminModel model;
    private final CreateAdminView view;
    
    public CreateAdminController(CreateAdminModel m,CreateAdminView v){
    
        model = m;
        view = v;
        
        view.submitButtonListener(new SubmitListener());
        view.cancelButtonListener(new CancelListener());
        view.closeWindowListener(new CloseListener());
    }
    
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            model.createAdmin(view.getUsername(), view.getApassword());
        }
    }
    
    class CancelListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            view.setUsername(null);
            view.setApassword(null);
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
