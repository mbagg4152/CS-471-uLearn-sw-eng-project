package ulearn.utils;

import java.util.ArrayList;

public class ClassGrades {
    private String classId = "1234abcd";
    ArrayList<Assignment> assignments = new ArrayList<Assignment>();

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void addAssignment(Assignment assign) {
        assignments.add(assign);
    }
}
