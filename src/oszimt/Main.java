package oszimt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static DBManager dbManager = new DBManager();
    private static MainWindowController mainWindowController;
    static private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("mainWindow.fxml").openStream());
        mainWindowController =  (MainWindowController) fxmlLoader.getController();
        primaryStage.setTitle("Der Inventar");
        primaryStage.setScene(scene = new Scene(root, 1280, 720));
        primaryStage.show();
        //Testfunktionen
    }


    public static void main(String[] args) {
        launch(args);

    }

    public static MainWindowController getMainWindowController () {
        return mainWindowController;
    }

    public static Scene getScene() {
        return scene;
    }
}
