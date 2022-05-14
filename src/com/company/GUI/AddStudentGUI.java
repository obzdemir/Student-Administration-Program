package com.company.GUI;

import com.company.AdministrationProgram;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentGUI implements ActionListener {
    AdministrationProgram program;
    private JLabel firstNameLabel;
    private JTextField firstNameText;
    private JLabel lastNameLabel;
    private JTextField lastNameText;
    private JLabel masterLabel;
    private JTextField masterText;
    private JLabel ageLabel;
    private JTextField ageText;
    private JLabel semesterLabel;
    private JTextField semesterText;
    private JButton button;
    private JLabel message;

    public AddStudentGUI(AdministrationProgram program){
        this.program = program;
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(350,270);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);

        panel.setLayout(null);

        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(10, 20, 80, 25);
        panel.add(firstNameLabel);

        firstNameText = new JTextField(20);
        firstNameText.setBounds(100, 20 ,165 ,25);
        panel.add(firstNameText);

        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(10, 50, 80, 25);
        panel.add(lastNameLabel);

        lastNameText = new JTextField(20);
        lastNameText.setBounds(100, 50 ,165 ,25);
        panel.add(lastNameText);

        masterLabel = new JLabel("Master/Bachelor");
        masterLabel.setBounds(10, 80, 110, 25);
        panel.add(masterLabel);

        masterText = new JTextField(20);
        masterText.setBounds(120, 80 ,145 ,25);
        panel.add(masterText);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(10, 110, 80, 25);
        panel.add(ageLabel);

        ageText = new JTextField(20);
        ageText.setBounds(100, 110 ,165 ,25);
        panel.add(ageText);

        semesterLabel = new JLabel("Semester");
        semesterLabel.setBounds(10, 140, 80, 25);
        panel.add(semesterLabel);

        semesterText = new JTextField(20);
        semesterText.setBounds(100, 140 ,165 ,25);
        panel.add(semesterText);

        button = new JButton("Add");
        button.setBounds(10, 170, 80, 25);
        button.addActionListener(this);
        panel.add(button);

        message = new JLabel("");
        message.setBounds(10, 200, 300, 25);
        panel.add(message);

        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String firstName = firstNameText.getText();
        String lastName  = lastNameText.getText();
        // masterText
        if (!ageText.getText().matches("[1-9]([0-9]*)")) {
            message.setText("Error: Age must be a positive number.");
            return;
        }
        int age = Integer.parseInt(ageText.getText());
        if (!semesterText.getText().matches("[1-9]([0-9]*)")) {
            message.setText("Error: Semester must be a positive number.");
            return;
        }
        int semester = Integer.parseInt(semesterText.getText());

        try {
            program.addStudent(firstName, lastName, true, age, semester);
            message.setText("added successfully!");
        } catch (Exception exc){
            message.setText("Error: " + exc.getMessage());
        }

    }
}
