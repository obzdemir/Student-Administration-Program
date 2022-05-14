package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Course {
    private String name;
    private List<Student> students;
    private boolean isMaster;
    private int fromSemester;

    public Course(String name, boolean isMaster, int fromSemester) {
        this.name = name;
        this.students = new ArrayList<Student>();
        this.isMaster = isMaster;
        this.fromSemester = fromSemester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public boolean isMaster() {
        return isMaster;
    }

    public void setMaster(boolean master) {
        isMaster = master;
    }

    public int getFromSemester() {
        return fromSemester;
    }

    public void setFromSemester(int fromSemester) {
        this.fromSemester = fromSemester;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    @Override
    public String toString() {
        return name;
    }
}
