package com.rafsan.controller;

import com.rafsan.model.AdminModel;
import com.rafsan.model.LoginModel;
import com.rafsan.view.AdminView;
import com.rafsan.view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginController {

    private final LoginModel model;
    private final LoginView view;
    
    public LoginController(LoginModel m,LoginView v){
    
        model = m;
        view = v;
        
        view.loginButtonListener(new LoginListener());
        view.cancelButtonListener(new ClearListener());
    }
    
    class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            model.makeLogin(view.getUsername(), view.getUpassword());
         
            if(model.getStatus()){
                AdminModel adminModel = new AdminModel();
                AdminView adminView = new AdminView();
                AdminController adminController = new AdminController(adminModel,adminView);
                adminView.setVisible(true);
                view.setVisible(false);
                view.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Username / Password!", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    class ClearListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            view.clearUsername();
            view.clearPassword();
        }
    }
}

