package oszimt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class MainWindowController {

    Stage newWindowStage = new Stage();
    Stage showStage = new Stage();
    private NewWindowController newWindowController;
    private ShowWindowController showWindowController;

    //Listen für TableView der Ausleiher
    private ObservableList<Ausleiher> ausleihers;
    private FilteredList<Ausleiher> filteredAusleihers;
    private SortedList<Ausleiher> sortedAusleihers;

    //Listen für TableView der Leihobjekte
    private ObservableList<Leihobjekt> leihobjekts;
    private FilteredList<Leihobjekt> filteredLeihobjekts;
    private SortedList<Leihobjekt> sortedLeihobjekts;

    @FXML
    private TextField ausleiher_suche_txtfield;

    @FXML
    private TextField leihobjekt_suche_txtfield;

    @FXML
    private ToolBar tab1_buchen_tb;

    @FXML
    private TableColumn<Leihobjekt, String> tab1_objekt_beschreibung_tac;

    @FXML
    private TableColumn<Ausleiher, String> tab1_leiher_vorname_tac;

    @FXML
    private TableColumn<Leihobjekt, String> tab1_objekt_Name_tac;

    @FXML
    private TableColumn<Leihobjekt, String> tab1_objekt_ID_tac;

    @FXML
    private TableView<Leihobjekt> tab1_objekt_tav;

    @FXML
    private TableColumn<Ausleiher, String> tab1_leiher_ID_tac;

    @FXML
    private Button tab1_buchen_wbtn;

    @FXML
    private TableColumn<Ausleiher, String> tab1_leiher_nachname_tac;

    @FXML
    private TableView<Ausleiher> tab1_leiher_tav;


    public void initialize(){
        populateAusleiherTable();
        populateLeihobjektTable();
    }

    private void populateAusleiherTable() { //Nicht völlig verstanden was hier geht - https://code.makery.ch/blog/javafx-8-tableview-sorting-filtering/
        tab1_leiher_ID_tac.setCellValueFactory(new PropertyValueFactory<>("id"));
        tab1_leiher_nachname_tac.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        tab1_leiher_vorname_tac.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        ausleihers = FXCollections.observableArrayList(Main.dbManager.getAusleiher());
        filteredAusleihers = new FilteredList<>(ausleihers, p -> true);
        ausleiher_suche_txtfield.textProperty().addListener(((observable, oldValue, newValue) -> filteredAusleihers.setPredicate(ausleiher -> {
            if (newValue == null || newValue.isEmpty()) return true;
            String lowerCaseFilter = newValue.toLowerCase();
            if (String.valueOf(ausleiher.getId()).contains(lowerCaseFilter)) return true;
            if (ausleiher.getVorname().toLowerCase().contains(lowerCaseFilter)) return true;
            if (ausleiher.getNachname().toLowerCase().contains(lowerCaseFilter)) return true;
            return false;
        })));
        sortedAusleihers = new SortedList<>(filteredAusleihers);
        sortedAusleihers.comparatorProperty().bind(tab1_leiher_tav.comparatorProperty());
        tab1_leiher_tav.setItems(sortedAusleihers);
    }

    private void populateLeihobjektTable() { //Nicht völlig verstanden was hier geht - ref: https://code.makery.ch/blog/javafx-8-tableview-sorting-filtering/
        tab1_objekt_ID_tac.setCellValueFactory(new PropertyValueFactory<>("id"));
        tab1_objekt_Name_tac.setCellValueFactory(new PropertyValueFactory<>("name"));
        tab1_objekt_beschreibung_tac.setCellValueFactory(new PropertyValueFactory<>("beschreibung"));
        leihobjekts = FXCollections.observableArrayList(Main.dbManager.getLeihobjekte());
        filteredLeihobjekts = new FilteredList<>(leihobjekts, l -> true);
        leihobjekt_suche_txtfield.textProperty().addListener(((observable, oldValue, newValue) -> filteredLeihobjekts.setPredicate(leihobjekt -> {
            if (newValue == null || newValue.isEmpty()) return true;
            String lowerCaseFilter = newValue.toLowerCase();
            if (String.valueOf(leihobjekt.getId()).contains(lowerCaseFilter)) return true;
            if (leihobjekt.getName().toLowerCase().contains(lowerCaseFilter)) return true;
            if (leihobjekt.getBeschreibung().toLowerCase().contains(lowerCaseFilter)) return true;
            return false;
        })));
        sortedLeihobjekts = new SortedList<>(filteredLeihobjekts);
        sortedLeihobjekts.comparatorProperty().bind(tab1_objekt_tav.comparatorProperty());
        tab1_objekt_tav.setItems(sortedLeihobjekts);

    }

    @FXML
    private void showAusleiherWindow() {
        if(showWindowController == null) {
            showWindow(getSelectedAusleiher());
        } else {
            showStage.requestFocus();
        }
    }

    @FXML
    private void showLeihobjektWindow() {
        if(showWindowController == null) {
            showWindow(getSelectedLeihobjekt());
        } else {
            showStage.requestFocus();
        }
    }

    @FXML
    private void newAusleiherWindow() {
        newWindow("ausleiher");
    }

    @FXML
    private void newLeihobjektWindow() {
        newWindow("leihobjekt");
    }

    public NewWindowController getNewWindowController() {
        return newWindowController;
    }

    public ShowWindowController getShowWindowController() {
        return showWindowController;
    }

    public void setNewWindowController(NewWindowController newWindowController) {
        this.newWindowController = newWindowController;
    }

    public void setShowWindowController(ShowWindowController showWindowController) {
        this.showWindowController = showWindowController;
    }

    public Ausleiher getSelectedAusleiher() {
        return tab1_leiher_tav.getFocusModel().getFocusedItem();
    }

    public Leihobjekt getSelectedLeihobjekt() {
        return tab1_objekt_tav.getFocusModel().getFocusedItem();
    }

    private void newWindow(String type) {
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("newWindow.fxml").openStream());
            newWindowController = fxmlLoader.getController();
            newWindowStage.setTitle("Neuer Eintrag");
            newWindowStage.setScene(new Scene(root, 300, 400));
            switch (type) {
                case "ausleiher":
                    newWindowController.select.selectToggle(newWindowController.ausleiher_radio);
                    break;
                case "leihobjekt":
                    newWindowController.select.selectToggle(newWindowController.leihobjekt_radio);
                    break;
                default:
                    System.err.println("Unknown Type of window - useing default Values");
                    break;
            }
            newWindowController.changeUI();
            newWindowStage.setResizable(false);
            newWindowStage.show();

        }
        catch (IOException e) {
            e.printStackTrace();

        }

    }

    @FXML
    private void showWindow(Leihobjekt leihobjekt) {
        Parent root;
        try {
            FXMLLoader showWindowfxmlLoader = new FXMLLoader(getClass().getResource("showWindow.fxml"));
            root = showWindowfxmlLoader.load();
            showStage.setScene(new Scene(root, 300,400));
            showStage.setOnCloseRequest(event -> showWindowController.close());
            showWindowController = showWindowfxmlLoader.getController();
            showWindowController.initData(leihobjekt);
            showStage.setResizable(false);
            showStage.setTitle("Anzeigen - Leihobjekt");
            showStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showWindow(Ausleiher ausleiher) {
        Parent root;
        try {
            FXMLLoader showWindowfxmlLoader = new FXMLLoader(getClass().getResource("showWindow.fxml"));
            root = showWindowfxmlLoader.load();
            showStage.setScene(new Scene(root, 300,400));
            showStage.setOnCloseRequest(event -> showWindowController.close());
            showWindowController = showWindowfxmlLoader.getController();
            showWindowController.initData(ausleiher);
            showStage.setResizable(false);
            showStage.setTitle("Anzeigen - Ausleiher");
            showStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
