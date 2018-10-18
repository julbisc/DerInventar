package oszimt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class Controller {

    @FXML
    private TextField tab2_ID_txt;
    @FXML
    private TextField tab2_nachname_txt;
    @FXML
    private TextField tab1_leiher_such_txf;
    @FXML
    private TextField tab3_beschreib_txt;
    @FXML
    private TextField tab3_ID_txt;
    @FXML
    private TextField tab2_vorname_txt;
    @FXML
    private TextField tab1_objekt_such_txf;


    @FXML
    private Label tab3_ID_lbl;

    @FXML
    private ToolBar tab1_buchen_tb;

    @FXML
    private TableColumn<Leihobjekt, String> tab1_objekt_beschreibung_tac;

    @FXML
    private Label tab2_vorname_lbl;


    @FXML
    private ToolBar tab1_objekt_such_tlb;

    @FXML
    private Label tab2_nachname_lbl;

    @FXML
    private Tab tab1_tab;

    @FXML
    private TableColumn<?, ?> tab1_leiher_vorname_tac;

    @FXML
    private GridPane tab2_grp;

    @FXML
    private ToolBar tab1_leiher_such_tlb;


    @FXML
    private Button tab1_objekt_such_btn;

    @FXML
    private Label tab2_ID_lbl;


    @FXML
    private TableColumn<Leihobjekt, String> tab1_objekt_Name_tac;

    @FXML
    private TableColumn<Leihobjekt, String> tab1_objekt_ID_tac;

    @FXML
    private GridPane tab3_grp;

    @FXML
    private TableView<Leihobjekt> tab1_objekt_tav;

    @FXML
    private TableColumn<Ausleiher, String> tab1_leiher_ID_tac;


    @FXML
    private Button tab2_anzeigen_btn;

    @FXML
    private Label tab3_beschreib_lbl;

    @FXML
    private Button tab2_einpflegen_btn;

    @FXML
    private Button tab3_anzeigen_btn;

    @FXML
    private Tab tab3_tab;

    @FXML
    private Button tab1_buchen_btn;

    @FXML
    private TableColumn<Ausleiher, String> tab1_leiher_nachname_tac;

    @FXML
    private Button tab2_loeschen_btn1;

    @FXML
    private Button tab3_loeschen_btn;

    @FXML
    private Button tab3_einpflegen_btn;

    @FXML
    private TableView<Ausleiher> tab1_leiher_tav;

    @FXML
    private GridPane tab1_grp;

    @FXML
    private Button tab1_leiher_such_btn;

    @FXML
    private Tab tab2_tab;

    public void initialize(){
        populateAusleiherTable();
        populateLeihobjektTable();
    }

    private void populateAusleiherTable() {
        ObservableList<Ausleiher> ausleihers = FXCollections.observableArrayList(Main.dbManager.getAusleiher());
        tab1_leiher_ID_tac.setCellValueFactory(new PropertyValueFactory<>("id"));
        tab1_leiher_nachname_tac.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        tab1_leiher_vorname_tac.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        tab1_leiher_tav.setItems(ausleihers);

    }

    private void populateLeihobjektTable() {
        ObservableList<Leihobjekt> leihobjekts = FXCollections.observableArrayList((Main.dbManager.getLeihobjekte()));
        tab1_objekt_ID_tac.setCellValueFactory(new PropertyValueFactory<>("id"));
        tab1_objekt_Name_tac.setCellValueFactory(new PropertyValueFactory<>("name"));
        tab1_objekt_beschreibung_tac.setCellValueFactory(new PropertyValueFactory<>("beschreibung"));
        tab1_objekt_tav.setItems(leihobjekts);

    }

}
