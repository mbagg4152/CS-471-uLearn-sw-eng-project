package ulearn.utils;

import java.util.List;

public class Admin extends User {
    public Admin(String userId, String userRealName, String password, List<String> classes) {
        super(userId, userRealName, password, classes);
    }
}
