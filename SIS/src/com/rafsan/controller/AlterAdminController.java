package com.rafsan.controller;

import com.rafsan.model.AlterAdminModel;
import com.rafsan.view.AlterAdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AlterAdminController {
    
    private final AlterAdminModel model;
    private final AlterAdminView view;
    
    public AlterAdminController(AlterAdminModel m,AlterAdminView v){
    
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
            
            model.getAdminByName(view.getAdminName());
            
            if(model.getStatus()){
                view.setPermissionOn();
                view.setAname(model.getAname());
                view.setApassword(model.getApassword());
                view.submitButtonVisibilityOn();
                
            }
            else{
                view.setPermissionOff();
                view.setAname(null);
                view.setApassword(null);
                
            }
        }
    }
    
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            int id = Integer.parseInt(model.getId());
            String name = view.getAname();
            String password = view.getApassword();
            model.alterAdminById(id,name,password);
        }
    }
    
    class CancelListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
           
            view.setPermissionOff();
            view.setAname(null);
            view.setApassword(null);
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
