package ulearn.utils;

import java.util.ArrayList;

public class Grade {
    private double GPA;
    private ArrayList<ClassGrades> classGrades = new ArrayList<ClassGrades>();

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public ArrayList<ClassGrades> getClassGrades() {
        return classGrades;
    }

    public void addClassGrades(ClassGrades classGrade) {
        this.classGrades.add(classGrade);
    }
}
