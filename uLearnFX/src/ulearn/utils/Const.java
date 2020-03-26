package ulearn.utils;

// this is just a class to hold strings used throughout project
public class Const {
	// prefix p = path -> d = json data or x = fxml file

	public static final String pj_user_db = "user-db.json";
	public static final String pj_class_db = "class-db.json";
	public static final String px_main_all = "../layout/gen/main_screen_all.fxml";
	public static final String px_main_adm = "../layout/admin/main_screen_admin.fxml";
	public static final String px_main_edu = "../layout/edu/main_screen_educator.fxml";
	public static final String px_main_stu = "../layout/student/main_screen_student.fxml";
	public static final String px_login = "../layout/gen/login.fxml";

	// prefixes ordering:
	// u = user , c = class or none if both -->
	// l = object label, a = array label  -->
	// t = top-level item

	public static final String uat_users = "users";
	public static final String ul_uid = "userId";
	public static final String l_name = "name";
	public static final String ul_pwd = "password";
	public static final String ul_grad = "gradDate";
	public static final String ul_usr_type = "userType";
	public static final String cat_classes = "classes";
	public static final String cl_cid = "classId";
	public static final String cl_edu = "educator";
	public static final String ca_stu = "students";
	public static final String cl_seats = "seats";

	// prefix t = type
	public static final String t_adm = "admin";
	public static final String t_edu = "educator";
	public static final String t_stu = "student";
	public static final String t_undef = "undefined";

	public static final String url_cal = "https://calendar.google.com";
	public static final String url_drive = "https://drive.google.com/drive";
}
