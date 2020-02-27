package ulearn.utils;

import java.util.List;

public class Student extends User {
    String userId;
    String userRealName;
    String password;
    List<String> currentClasses;
    List<Student> pastClasses;
    String gpa;
    String gradDate;

    public Student(String userId, String userRealName, String password, List<String> currentClasses, List<String> pastClasses, String gpa, String gradDate) {
        super(userId, userRealName, password, currentClasses);
        setGpa(gpa);
        setGradDate(gradDate);
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getUserRealName() { return userRealName; }

    public void setUserRealName(String userRealName) { this.userRealName = userRealName; }

    public List<String> getCurrentClasses() { return currentClasses; }

    public void setCurrentClasses(List<String> currentClasses) { this.currentClasses = currentClasses; }

    public String getGpa() { return gpa; }

    public void setGpa(String gpa) { this.gpa = gpa; }

    public String getGradDate() { return gradDate; }

    public void setGradDate(String gradDate) { this.gradDate = gradDate; }

    public List<Student> getPastClasses() { return pastClasses; }

    public void setPastClasses(List<Student> pastClasses) { this.pastClasses = pastClasses; }
}
