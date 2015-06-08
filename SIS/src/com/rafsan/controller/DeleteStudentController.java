package com.rafsan.controller;

import com.rafsan.model.DeleteStudentModel;
import com.rafsan.view.DeleteStudentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeleteStudentController {
    
    private final DeleteStudentModel model;
    private final DeleteStudentView view;
    
    public DeleteStudentController(DeleteStudentModel m,DeleteStudentView v){
    
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
            
            model.getStudentByRoll(view.getStudentRoll());
            
            if(model.getStatus()){
                view.deleteButtonVisibilityOn();
            }
        }
    }
    
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            int id = Integer.parseInt(model.getId());
            model.deleteStudentById(id);
        }
    }
    
    class CancelListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
           
            view.setStudentRoll(null);
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
