package com.company;

import java.util.List;

public class AdministrationProgram {
    private List<Student> students;
    private List<Course> courses;

    public AdministrationProgram(List<Student> students, List<Course> courses) {
        this.students = students;
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addStudent(String firstName, String lastName, boolean isMaster, int age, int semester) throws IllegalArgumentException{
        if (firstName.isEmpty()) throw new IllegalArgumentException("First name can not be empty.");
        if (lastName.isEmpty()) throw new IllegalArgumentException("Last name can not be empty.");
        if (age < 1) throw new IllegalArgumentException("Age must be a positive number.");
        if (semester < 1) throw new IllegalArgumentException("Semester must be a positive number.");

        Student student = new Student(firstName, lastName, isMaster, age, semester);
        students.add(student);
    }

    public void addCourse(String name, boolean isMaster, int fromSemester) throws IllegalArgumentException{
        if (name.isEmpty()) throw new IllegalArgumentException("The name of the course can not be empty.");
        if (fromSemester < 1) throw new IllegalArgumentException("Semester must be a positive number.");
        for (Course c: courses){
            if (c.getName().equals(name)) {
                throw new IllegalArgumentException("There already exists a course with the same name.");
            }
        }

        Course course = new Course(name, isMaster, fromSemester);
        courses.add(course);
    }

    public void enrollStudent(Course course, Student student) throws Exception{
        if (course.isMaster() != student.isMaster()){
            throw new Exception("The selected course is not suitable for this student.");
        }
        if (student.isEnrolled(course)){
            throw new Exception("The selected student is already enrolled in this course.");
        }
        student.enroll(course);
        course.addStudent(student);
    }

}
