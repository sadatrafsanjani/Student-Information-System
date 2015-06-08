package com.rafsan.controller;

import com.rafsan.model.AddStudentModel;
import com.rafsan.model.AdminModel;
import com.rafsan.model.AlterAdminModel;
import com.rafsan.model.CreateAdminModel;
import com.rafsan.model.DeleteStudentModel;
import com.rafsan.model.DumpAdminModel;
import com.rafsan.model.LoginModel;
import com.rafsan.model.StudentModel;
import com.rafsan.model.UpdateStudentModel;
import com.rafsan.view.AddStudentView;
import com.rafsan.view.AdminView;
import com.rafsan.view.AlterAdminView;
import com.rafsan.view.CreateAdminView;
import com.rafsan.view.DeleteStudentView;
import com.rafsan.view.DumpAdminView;
import com.rafsan.view.LoginView;
import com.rafsan.view.StudentView;
import com.rafsan.view.UpdateStudentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController {
    
    private final AdminModel model;
    private final AdminView view;
    
    public AdminController(AdminModel m,AdminView v){
    
        model = m;
        view = v;
        
        view.logoutItemListener(new LogoutListener());
        view.closeItemListener(new CloseListener());
        view.createButtonListener(new CreateListener());
        view.alterButtonListener(new AlterListener());
        view.dumpButtonListener(new DumpListener());
        view.addButtonListener(new NewListener());
        view.viewButtonListener(new ViewListener());
        view.updateButtonListener(new UpdateListener());
        view.deleteButtonListener(new DeleteListener());
    }
    
    class LogoutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            LoginModel loginModel = new LoginModel();
            LoginView loginView = new LoginView();
            LoginController loginController = new LoginController(loginModel,loginView);
            loginView.setVisible(true);
            view.setVisible(false);
            view.dispose();
        }
    }
    
    class CloseListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            view.setVisible(false);
            System.exit(0);
        }
    }
    
    class CreateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            CreateAdminModel createAdminModel = new CreateAdminModel();
            CreateAdminView createAdminView = new CreateAdminView();
            CreateAdminController createAdminController = new CreateAdminController(createAdminModel,createAdminView);
            createAdminView.setVisible(true);
        }
    }
    
    class AlterListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            AlterAdminModel alterAdminModel = new AlterAdminModel();
            AlterAdminView alterAdminView = new AlterAdminView();
            AlterAdminController alterAdminController = new AlterAdminController(alterAdminModel,alterAdminView);
            alterAdminView.setVisible(true);
        }
    }
    
    class DumpListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            DumpAdminModel dumpAdminModel = new DumpAdminModel();
            DumpAdminView dumpAdminView = new DumpAdminView();
            DumpAdminController dumpAdminController = new DumpAdminController(dumpAdminModel,dumpAdminView);
            dumpAdminView.setVisible(true);
        }
    }
    
    class NewListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            AddStudentModel studentModel = new AddStudentModel();
            AddStudentView studentView = new AddStudentView();
            AddStudentController studentController = new AddStudentController(studentModel,studentView);
            studentView.setVisible(true);
        }
    }
    
    
    
    class ViewListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            StudentModel studentModel = new StudentModel();
            StudentView studentView = new StudentView();
            StudentController studentController = new StudentController(studentModel,studentView);
            studentView.setVisible(true);
        }
    }
    
    class UpdateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            UpdateStudentModel updateStudentModel = new UpdateStudentModel();
            UpdateStudentView updateStudentView = new UpdateStudentView();
            UpdateStudentController updateStudentController = new UpdateStudentController(updateStudentModel,updateStudentView);
            updateStudentView.setVisible(true);
        }
    }
    
    class DeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            DeleteStudentModel deleteStudentModel = new DeleteStudentModel();
            DeleteStudentView deleteStudentView = new DeleteStudentView();
            DeleteStudentController deleteStudentController = new DeleteStudentController(deleteStudentModel,deleteStudentView);
            deleteStudentView.setVisible(true);
        }
    }
}
