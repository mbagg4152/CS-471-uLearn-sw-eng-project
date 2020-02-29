package ulearn.utils;

public class Classes {

    String title;
    String courseId;
    String teacher;

    public Classes(String title, String courseId, String teacher) {
        this.title = title;
        this.courseId = courseId;
        this.teacher = teacher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
