package com.company.GUI;

import com.company.AdministrationProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private AdministrationProgram program;

    private JButton studentButton;
    private JButton courseButton;

    public GUI(AdministrationProgram program){
        this.program = program;
        frame = new JFrame();
        panel = new JPanel();

        studentButton = new JButton("Students");
        studentButton.addActionListener(this);
        courseButton = new JButton("Courses");
        courseButton.addActionListener(this);
        JLabel welcomeLabel = new JLabel("Welcome!");

        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 20, 50));
        panel.setLayout(new GridLayout(0,1));
        panel.add(welcomeLabel);
        panel.add(studentButton);
        panel.add(courseButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Student Administration Program");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressedButton = (JButton) e.getSource();
        if (pressedButton == studentButton){
            new StudentGUI(program);
        }
        if (pressedButton == courseButton){
            new CourseListGUI(program);
        }
    }
}
