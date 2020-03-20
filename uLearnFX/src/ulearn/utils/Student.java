package ulearn.utils;

import java.util.List;

public class Student extends User {
	String userId;
	String userRealName;
	String password;
	List<String> classes; // students current classes
	List<Student> pastClasses;
	String gpa;
	String gradDate;

	public Student(String userId, String userRealName, String password, List<String> classes, String gpa, String gradDate) {
		super(userId, userRealName, password, classes);
		setGpa(gpa);
		setGradDate(gradDate);
	}

	public String getGpa() { return gpa; }

	public void setGpa(String gpa) { this.gpa = gpa; }

	public String getGradDate() { return gradDate; }

	public void setGradDate(String gradDate) { this.gradDate = gradDate; }

	public List<Student> getPastClasses() { return pastClasses; }

	public void setPastClasses(List<Student> pastClasses) { this.pastClasses = pastClasses; }
}
