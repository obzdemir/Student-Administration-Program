package com.company.GUI;

import com.company.AdministrationProgram;
import com.company.Course;

import javax.swing.*;

public class CourseListGUI {
    public CourseListGUI(AdministrationProgram program){
        JFrame f = new JFrame("All Students");
        String[] data = new String[program.getCourses().size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = program.getCourses().get(i).toString();
        }
        f.add(new JList(data));
        f.pack();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
