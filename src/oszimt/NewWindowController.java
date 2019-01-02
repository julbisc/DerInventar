package oszimt;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewWindowController {

    @FXML Button btn_abbrechen;

    @FXML Label lbl_1; @FXML Label lbl_2;

    @FXML TextField txtfield_1; @FXML TextField txtfield_2;

    @FXML RadioButton ausleiher_radio; @FXML RadioButton leihobjekt_radio;

    @FXML ToggleGroup select;



    @FXML
    public void einpflegen() {
        if (select.getSelectedToggle().equals(ausleiher_radio)) {
            ausleiherEinpflegen();
        } else {
            leihobjektEinpflegen();
        }
    }

    @FXML
    public void changeUI(){
        if (select.getSelectedToggle().equals(ausleiher_radio)) {
            lbl_1.setText("Vorname");
            lbl_2.setText("Nachname");
        } else {
            lbl_1.setText("Name");
            lbl_2.setText("Beschreibung");
        }
    }

    public void ausleiherEinpflegen() {
        String vorname = txtfield_1.getText();
        String nachname = txtfield_2.getText();
        if (vorname.isEmpty() || nachname.isEmpty()){
            Tools.error("Fehler", "Beide Felder müssen befüllt sein!");
            return;
        }
        Ausleiher ausleiher = new Ausleiher(Main.dbManager.getMaxID("ausleiher"),vorname, nachname);
        if (Main.dbManager.einpflegen(ausleiher)){
            Tools.info("Erfolg", "Der Ausleiher \"" + ausleiher.toFormattedString() + "\" wurde erfolgreich angelegt");
            Main.getMainWindowController().initialize();
            close();
        } else {
            Tools.error("Error", "Something went wrong here");
        }
    }

    public void leihobjektEinpflegen() {
        String name = txtfield_1.getText();
        String beschreibung = txtfield_2.getText();
        if (name.isEmpty() || beschreibung.isEmpty()){
            Tools.error("Fehler", "Beide Felder müssen befüllt sein!");
            return;
        }
        Leihobjekt leihobjekt = new Leihobjekt(Main.dbManager.getMaxID("leihobjekte"),name, beschreibung, 0);
        if (Main.dbManager.einpflegen(leihobjekt)){
            Tools.info("Erfolg", "Das Leihobjekt \"" + leihobjekt.toFormattedString() + "\" wurde erfolgreich angelegt");
            Main.getMainWindowController().initialize();
            close();
        } else {
            Tools.error("Error", "Something went wrong here");
        }
    }

    @FXML
    public void close() {
        Stage stage = (Stage) btn_abbrechen.getScene().getWindow();
        stage.close();
        Main.getMainWindowController().setNewWindowController(null);
    }
}
