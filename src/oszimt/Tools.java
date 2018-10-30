package oszimt;

import javafx.scene.control.Alert;

public class Tools {
    public static void error(String title, String message)
    {
        Alert popUp = new Alert(Alert.AlertType.ERROR);
        popUp.setHeaderText(null);
        popUp.setTitle(title);
        popUp.setContentText(message);
        popUp.showAndWait();
    }

    public static void info(String title, String message)
    {
        Alert popUp = new Alert(Alert.AlertType.INFORMATION);
        popUp.setHeaderText(null);
        popUp.setTitle(title);
        popUp.setContentText(message);
        popUp.showAndWait();
    }
}
