package com.company.GUI;

import com.company.AdministrationProgram;

import javax.swing.*;
import java.util.List;

public class StudentListGUI {
    public StudentListGUI(AdministrationProgram program){
        JFrame f = new JFrame("All Students");
        String[] data = new String[program.getStudents().size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = program.getStudents().get(i).toString();
        }
        f.add(new JList(data));
        f.pack();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
