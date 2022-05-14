package com.company.GUI;

import com.company.AdministrationProgram;
import com.company.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EnrollSelectStudentGUI implements ActionListener {
    private AdministrationProgram program;

    private List<JButton> studentButtons;

    public EnrollSelectStudentGUI(AdministrationProgram program){
        this.program = program;
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        studentButtons = new ArrayList<JButton>();

        for (int i = 0; i < program.getStudents().size(); i++) {
            JReferencingButton<Student> button = new JReferencingButton<Student>(program.getStudents().get(i).toString(), program.getStudents().get(i));
            studentButtons.add(button);
            button.addActionListener(this);
        }
        JLabel welcomeLabel = new JLabel("Students");

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(welcomeLabel);
        for (JButton b: studentButtons){
            panel.add(b);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Student Administration Program");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JReferencingButton<Student> pressedButton = (JReferencingButton) e.getSource();
        Student student = pressedButton.getValue();
        new EnrollSelectCourseGUI(program, student);
    }
}
