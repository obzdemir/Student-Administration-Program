package com.company;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private boolean isMaster;
    private List<Course> courses;
    private int age;
    private int semester;

    public Student(String firstName, String lastName, boolean isMaster, int age, int semester) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isMaster = isMaster;
        this.courses = new ArrayList<Course>();
        this.age = age;
        this.semester = semester;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isMaster() {
        return isMaster;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int getAge() {
        return age;
    }

    public int getSemester() {
        return semester;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMaster(boolean master) {
        isMaster = master;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void enroll(Course course){
        courses.add(course);
    }

    public boolean isEnrolled(Course course){
        return courses.contains(course);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + semester + ", " + isMaster;
    }
}
