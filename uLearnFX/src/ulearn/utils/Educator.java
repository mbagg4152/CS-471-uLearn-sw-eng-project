package ulearn.utils;

import java.util.List;

public class Educator extends User {
    String userId;
    String userRealName;
    String password;
    List<String> classes;

    public Educator(String userId, String userRealName, String password, List<String> classes) {
        super(userId, userRealName, password, classes);
        setClasses(classes);
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getUserRealName() { return userRealName; }

    public void setUserRealName(String userRealName) { this.userRealName = userRealName; }

    public List<String> getClasses() { return classes; }

    public void setClasses(List<String> classes) { this.classes = classes; }
}
