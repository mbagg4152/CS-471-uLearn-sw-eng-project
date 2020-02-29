package ulearn.utils;

import java.util.List;

public class Educator extends User {

    public Educator(String userId, String userRealName, String password, List<String> classes) {
        super(userId, userRealName, password, classes);
        setClasses(classes);
    }
}
