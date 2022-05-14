package com.company.GUI;

import com.company.AdministrationProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI implements ActionListener {
    private AdministrationProgram program;
    private JButton studentButton;
    private JButton enrollButton;
    private JButton addAStudentButton;

    public StudentGUI(AdministrationProgram program){
        this.program = program;

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        studentButton = new JButton("Show All Students");
        studentButton.addActionListener(this);
        enrollButton = new JButton("enroll a student");
        enrollButton.addActionListener(this);
        addAStudentButton = new JButton("add a student");
        addAStudentButton.addActionListener(this);


        JLabel studentsLabel = new JLabel("Students");

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(studentsLabel);
        panel.add(studentButton);
        panel.add(enrollButton);
        panel.add(addAStudentButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Student Administration Program");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressedButton = (JButton) e.getSource();
        if (pressedButton == studentButton){
            new StudentListGUI(program);
        }
        if (pressedButton == enrollButton){
            new EnrollSelectStudentGUI(program);
        }
        if (pressedButton == addAStudentButton){
            new AddStudentGUI(program);
        }
    }
}
