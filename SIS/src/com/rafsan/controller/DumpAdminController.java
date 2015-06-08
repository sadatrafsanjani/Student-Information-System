package com.rafsan.controller;

import com.rafsan.model.DumpAdminModel;
import com.rafsan.view.DumpAdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DumpAdminController {
    
    private final DumpAdminModel model;
    private final DumpAdminView view;
    
    public DumpAdminController(DumpAdminModel m,DumpAdminView v){
    
        model = m;
        view = v;
        
        view.searchButtonListener(new SearchListener());
        view.deleteButtonListener(new SubmitListener());
        view.cancelButtonListener(new CancelListener());
        view.closeWindowListener(new CloseListener());
    }
    
    class SearchListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            model.getAdminByName(view.getAdminName());
            
            if(model.getStatus()){
                view.deleteButtonVisibilityOn();
            }
        }
    }
    
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            int id = Integer.parseInt(model.getId());
            model.dumpAdminById(id);
        }
    }
    
    class CancelListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
           
            view.setAdminName(null);
            view.deleteButtonVisibilityOff();
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
