package oszimt;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class ShowWindowController {

    boolean editmode = false;
    Ausleiher ausleiher = null;
    Leihobjekt leihobjekt = null;


    @FXML ToggleButton toggle_btn_edit;

    @FXML Button btn_ok;

    @FXML Label lbl_1; @FXML Label lbl_2;

    @FXML TextField txtfield_1; @FXML TextField txtfield_2; @FXML TextField txtfield_3;

    public void initialize() {
    }

    public void initData(Leihobjekt leihobjekt) {
        this.leihobjekt = leihobjekt;
        fillData();
        changeUI();
    }

    public void initData(Ausleiher ausleiher) {
        this.ausleiher = ausleiher;
        fillData();
        changeUI();
    }

    @FXML
    private void editMode() {
        if (toggle_btn_edit.isSelected()) {
            editmode = true;
            btn_ok.setText("Speichern");
            txtfield_2.setDisable(false);
            txtfield_3.setDisable(false);
        } else {
            editmode = false;
            btn_ok.setText("OK");
            txtfield_2.setDisable(true);
            txtfield_3.setDisable(true);
            fillData();
        }
    }

    @FXML
    public void close() {
        if (editmode) {
            save();
        }
        Stage stage = (Stage) btn_ok.getScene().getWindow();
        stage.close();
        Main.getMainWindowController().initialize();
        Main.getMainWindowController().setShowWindowController(null);

    }

    private void save() {
        if (ausleiher != null) {
            ausleiher.setNachname(txtfield_2.getText());
            ausleiher.setVorname(txtfield_3.getText());
            if (Main.dbManager.update(ausleiher)) {
                Tools.info("Erfolg", "Der Ausleiher \"" + ausleiher.toFormattedString() + "\" wurde erfolgreich geupdated");
            }
        } else if (leihobjekt != null) {
            leihobjekt.setName(txtfield_2.getText());
            leihobjekt.setBeschreibung(txtfield_3.getText());
            if (Main.dbManager.update(leihobjekt)) {
                Tools.info("Erfolg", "Das Leihobjekt \"" + leihobjekt.toFormattedString() + "\" wurde erfolgreich geupdated");
            }

        }

    }

    private void changeUI() {
        if (ausleiher != null) {
            lbl_1.setText("Vorname");
            lbl_2.setText("Nachname");
        } else if (leihobjekt != null) {
            lbl_1.setText("Name");
            lbl_2.setText("Beschreibung");
        } else {
            Tools.error("Fehler", "Unerwarteter Fehler beim Anpassen der UI (Ausleiher & Leihobjekt null)");
        }
    }

    public void fillData(){
        if(ausleiher != null) {
            txtfield_1.setText(Integer.toString(ausleiher.getId()));
            txtfield_2.setText(ausleiher.getVorname());
            txtfield_3.setText(ausleiher.getNachname());
        } else if (leihobjekt != null) {
            txtfield_1.setText(Integer.toString(leihobjekt.getId()));
            txtfield_2.setText(leihobjekt.getName());
            txtfield_3.setText(leihobjekt.getBeschreibung());
        } else {
            Tools.error("Error loading Window", "Objekt konnte nicht geladen werden");
        }
    }

}
