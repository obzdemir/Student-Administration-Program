package com.company.GUI;

import com.company.AdministrationProgram;
import com.company.Course;
import com.company.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EnrollSelectCourseGUI implements ActionListener {
    private AdministrationProgram program;
    private Student student;
    private List<JButton> courseButtons;
    private JFrame frame;
    private JPanel panel;
    public EnrollSelectCourseGUI(AdministrationProgram program, Student student){
        this.student = student;
        this.program = program;
        frame = new JFrame();
        panel = new JPanel();
        courseButtons = new ArrayList<JButton>();

        for (int i = 0; i < program.getCourses().size(); i++) {
            JReferencingButton<Course> button = new JReferencingButton<Course>(program.getCourses().get(i).toString(), program.getCourses().get(i));
            courseButtons.add(button);
            button.addActionListener(this);
        }
        JLabel welcomeLabel = new JLabel("Courses");

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(welcomeLabel);
        for (JButton b: courseButtons){
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
        JReferencingButton<Course> pressedButton = (JReferencingButton) e.getSource();
        Course course = pressedButton.getValue();
        try {
            program.enrollStudent(course, student);
        } catch (Exception exc){
            JOptionPane.showMessageDialog(frame, exc.getMessage());
        }
        frame.setVisible(false);
    }
}
