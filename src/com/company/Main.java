package com.company;

import com.company.GUI.GUI;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        List<Course> courses = new ArrayList<Course>();
	    AdministrationProgram program = new AdministrationProgram(students, courses);

	    program.addStudent("Ömer", "Özdemir", true, 22,1 );
        program.addStudent("Ahmet", "Öner", true, 27,1 );

        program.addCourse("Java", true,1);
        program.addCourse("Linear Algebra", false, 1);

        //program.enrollStudent(courses.get(0), students.get(0));

        new GUI(program);
    }
}
