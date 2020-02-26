package ulearn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Application {
    // for login
    public Button loginBtn;
    public Label unameLabel, pwdLabel;
    public TextField unameBox;
    public PasswordField pwdBox;


    // for login_popup
    public Text uNameInfo, pwdInfo, dispUName, dispPwd;
    public Button goHomeBtn;
    public Tab chatTab = new Tab(), classTab = new Tab(), calTab = new Tab(), storageTab = new Tab(), settingsTab =
            new Tab();
    public TabPane mainTabs = new TabPane();
    public WebView gCalWebView = new WebView();

    @Override public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("layout/login.fxml"));
        primaryStage.setTitle("uLearn");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setResizable(true);
        primaryStage.show();
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        readJson();

    }


    void readJson() {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        try {
            File myObj = new File("database.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
