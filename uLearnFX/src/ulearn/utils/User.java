package ulearn.utils;

import java.util.List;

public class User {
    String userId;
    String userRealName;
    String password;
    List<String> classes;

    public User(String userId, String userRealName, String password, List<String> classes) {
        setPassword(password);
        setUserId(userId);
        setUserRealName(userRealName);
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
