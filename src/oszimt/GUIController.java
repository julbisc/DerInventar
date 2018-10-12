package oszimt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;

public class GUIController {

    @FXML
    private Tab tab1_tab;

    @FXML
    private GridPane tab1_grp;

    @FXML
    private ToolBar tab1_objekt_such_tlb;

    @FXML
    private Button tab1_objekt_such_btn;

    @FXML
    private TextField tab1_objekt_such_txf;

    @FXML
    private ToolBar tab1_leiher_such_tlb;

    @FXML
    private Button tab1_leiher_such_btn;

    @FXML
    private TextField tab1_leiher_such_txf;

    @FXML
    private ToolBar tab1_buchen_tb;

    @FXML
    private Button tab1_buchen_btn;

    @FXML
    private TableView<?> tab1_leiher_tav;

    @FXML
    private TableColumn<?, ?> tab1_leiher_ID_tac;

    @FXML
    private TableColumn<?, ?> tab1_leiher_nachname_tac;

    @FXML
    private TableColumn<?, ?> tab1_leiher_vorname_tac;

    @FXML
    private TableColumn<?, ?> tab1_leiher_typ_tac;

    @FXML
    private TableView<?> objekt_tav;

    @FXML
    private TableColumn<?, ?> tab1_objekt_ID_tac;

    @FXML
    private TableColumn<?, ?> tab1_objekt_Name_tac;

    @FXML
    private TableColumn<?, ?> tab1_objekt_beschreibung_tac;

    @FXML
    private Tab tab2_tab;

    @FXML
    private GridPane tab2_grp;

    @FXML
    private TextField tab2_ID_txt;

    @FXML
    private Label tab2_ID_lbl;

    @FXML
    private Label tab2_nachname_lbl;

    @FXML
    private TextField tab2_nachname_txt;

    @FXML
    private TextField tab2_vorname_txt;

    @FXML
    private Label tab2_vorname_lbl;

    @FXML
    private ChoiceBox<?> tab2_typ_cbx;

    @FXML
    private Label tab2_typ_lbl;

    @FXML
    private Button tab2_einpflegen_btn;

    @FXML
    private Button tab2_anzeigen_btn;

    @FXML
    private Button tab2_loeschen_btn1;
    
    @FXML
    private ToggleButton tab2_umschalt_toggletbn;

    @FXML
    private Tab tab3_tab;

    @FXML
    private GridPane tab3_grp;

    @FXML
    private TextField tab3_ID_txt;

    @FXML
    private Label tab3_ID_lbl;

    @FXML
    private ChoiceBox<?> tab3_typ_cbx;

    @FXML
    private Label tab3_typ_lbl;

    @FXML
    private Label tab3_beschreib_lbl;

    @FXML
    private TextField tab3_beschreib_txt;

    @FXML
    private Button tab3_einpflegen_btn;

    @FXML
    private Button tab3_loeschen_btn;

    @FXML
    private Button tab3_anzeigen_btn;
    
    @FXML
    void tab2_anzeigen_btn_action(ActionEvent event) {
    	
    }

    @FXML
    void tab2_einpflegen_btn_action(ActionEvent event) {

    }

    @FXML
    void tab2_loeschen_btn1_action(ActionEvent event) {

    }
    
	boolean t = false;
    @FXML
    void tab2_togglebtn_action(ActionEvent event) {
    	
    	if(t) {
    		tab2_anzeigen_btn.setDisable(false);
    		tab2_ID_txt.setDisable(false);
    		
    		tab2_einpflegen_btn.setDisable(true);
        	tab2_loeschen_btn1.setDisable(true);
          	tab2_nachname_txt.setDisable(true);
        	tab2_vorname_txt.setDisable(true);
        	tab2_typ_cbx.setDisable(true);

    	}
    	else {
    		tab2_anzeigen_btn.setDisable(true);
    		tab2_ID_txt.setDisable(true);
    		
    		tab2_einpflegen_btn.setDisable(false);
        	tab2_loeschen_btn1.setDisable(false);
        	tab2_nachname_txt.setDisable(false);
        	tab2_vorname_txt.setDisable(false);
        	tab2_typ_cbx.setDisable(false);

		}
    	t = !t;
    }

    @FXML
    void tab3_anzeigen_btn_action(ActionEvent event) {

    }

    @FXML
    void tab3_einpflegen_btn_action(ActionEvent event) {

    }

    @FXML
    void tab3_loeschen_btn_action(ActionEvent event) {

    }


}
