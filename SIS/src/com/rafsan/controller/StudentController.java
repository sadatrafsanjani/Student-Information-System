package com.rafsan.controller;

import com.rafsan.model.StudentModel;
import com.rafsan.view.StudentView;


public class StudentController {

    private final StudentModel model;
    private final StudentView view;
    
    public StudentController(StudentModel m,StudentView v){
    
        model = m;
        view = v;
        
        model.showStudent();
        view.setStudentTable(model.getTable());
    }
}

