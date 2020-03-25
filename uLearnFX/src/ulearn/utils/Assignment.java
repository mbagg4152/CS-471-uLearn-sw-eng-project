package ulearn.utils;

import javafx.beans.binding.StringBinding;

public class Assignment {
    private int grade = 50;
    private String date = "3/28/2020";
    private String type = "Homework";

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
