package com.company.GUI;

import com.company.AdministrationProgram;

import javax.swing.*;
import java.util.List;

public class ListGUI {
    public ListGUI(List list){
        JFrame f = new JFrame("All Students");
        String[] data = new String[list.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = list.get(i).toString();
        }
        f.add(new JList(data));
        f.pack();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
