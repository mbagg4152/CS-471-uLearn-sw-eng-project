package ulearn.utils;

import java.util.List;

public class User {
    String userId;
    String userRealName;
    String password;
    String username;
    String firstName;
    String lastName;
    String userType;

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

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getUserType() { return userType; }

    public void setUserType(String userType) { this.userType = userType; }

    public List<String> getClasses() { return classes; }

    public void setClasses(List<String> classes) { this.classes = classes; }

    //Adds a class to the list, returns 1 if successful and something else if an error occurred (should only be 1 or 0 though)
    public int addClass(String addedClass) {
        int check = classes.length;
        classes.add(addedClass);
        check = classes.length - check;
        return check;
    }

}
