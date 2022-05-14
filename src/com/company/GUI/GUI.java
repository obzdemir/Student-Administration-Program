package com.company.GUI;

import com.company.AdministrationProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel welcomePanel;
    private JPanel studentPanel;
    private JPanel coursePanel;
    private AdministrationProgram program;

    private JButton studentButton;
    private JButton enrollButton;
    private JButton addAStudentButton;

    private JButton courseListButton;
    //TODO: show enrolled students
    private JButton showEnrolledButton;

    public GUI(AdministrationProgram program){
        this.program = program;
        frame = new JFrame();
        JTabbedPane tabbedPane = new JTabbedPane();

        createWelcomePanel();
        createStudentPanel();
        createCoursePanel();

        tabbedPane.add("Welcome", welcomePanel);
        tabbedPane.add("Students", studentPanel);
        tabbedPane.add("Courses", coursePanel);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setSize(320,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Student Administration Program");
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressedButton = (JButton) e.getSource();
        if (pressedButton == studentButton){
            new ListGUI(program.getStudents());
        }
        if (pressedButton == enrollButton){
            new EnrollSelectStudentGUI(program);
        }
        if (pressedButton == addAStudentButton){
            new AddStudentGUI(program);
        }

        if (pressedButton == courseListButton){
            new ListGUI(program.getCourses());
        }
    }

    private void createWelcomePanel(){
        welcomePanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome!");
        JLabel descriptionLabel = new JLabel("This is a student administration program.");
        JLabel enjoyLabel = new JLabel("Enjoy!");

        welcomePanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));
        welcomePanel.setLayout(new GridLayout(0,1));
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(descriptionLabel);
        welcomePanel.add(enjoyLabel);
    }

    private void createStudentPanel(){
        studentPanel = new JPanel();
        studentButton = new JButton("Show all students");
        studentButton.addActionListener(this);
        enrollButton = new JButton("enroll a student");
        enrollButton.addActionListener(this);
        addAStudentButton = new JButton("add a student");
        addAStudentButton.addActionListener(this);
        studentPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        studentPanel.setLayout(new GridLayout(0,1));
        studentPanel.add(studentButton);
        studentPanel.add(studentButton);
        studentPanel.add(enrollButton);
        studentPanel.add(addAStudentButton);
    }

    private void createCoursePanel(){
        coursePanel = new JPanel();
        courseListButton = new JButton("Show all courses");
        courseListButton.addActionListener(this);
        showEnrolledButton = new JButton("Show enrolled students");
        showEnrolledButton.addActionListener(this);
        coursePanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        coursePanel.setLayout(new GridLayout(0,1));
        coursePanel.add(courseListButton);
        coursePanel.add(showEnrolledButton);
    }
}

