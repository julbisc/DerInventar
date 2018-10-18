package oszimt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Main extends Application {
    public static DBManager dbManager = new DBManager();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Der Inventar");
        primaryStage.setScene(new Scene(root, 1600, 900));
        primaryStage.show();
        //Testfunktionen

    }


    public static void main(String[] args) {
        launch(args);

    }
}
