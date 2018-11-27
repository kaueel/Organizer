package Screens.LawSuits;

import Controllers.DataController;
import Controllers.MainScreensController;
import Controllers.Screen;
import Models.DocumentTemplates;
import Models.LawSuit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class LawSuits extends Screen {
    private MainScreensController mainScreensController = MainScreensController.getInstance();
    private DataController dataController = DataController.getInstance();
    private ObservableList<LawSuit> LawSuits = FXCollections.observableArrayList();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button btnNewTemplate;

    @FXML
    private TableColumn<ObservableList<LawSuit>, String> rowlawSuitsNumber;

    @FXML
    private TableColumn<ObservableList<LawSuit>, String> rowlawSuitsTitulo;

    @FXML
    private TableColumn<ObservableList<LawSuit>, String> rowlawSuitsClientName;

    @FXML
    private TableColumn<ObservableList<LawSuit>, String> rowlawSuitsPppositeName;



    @FXML // fx:id="documentTemplatesTable"
    private TableView<LawSuit> lawSuitsTable;


    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {


        LawSuits = (ObservableList<LawSuit>) dataController.getAllObjectsOfType(LawSuit.class);



        rowlawSuitsNumber.setCellValueFactory(new PropertyValueFactory<>("number"));

        rowlawSuitsTitulo.setCellValueFactory(new PropertyValueFactory<>("title"));

        rowlawSuitsTitulo.setCellValueFactory(new PropertyValueFactory<>("clientByClientId"));

        rowlawSuitsTitulo.setCellValueFactory(new PropertyValueFactory<>("oppositeName"));

        lawSuitsTable.setItems(LawSuits);

    }


    @FXML
    void callLawSuitScreen() {
        super.setCurrentdocumentTemplates(null);
        mainScreensController.showNewMainScreen("/Screens/LawSuit/lawSuit.fxml");
    }

    @FXML
    void setCurrentLawSuit(){

        LawSuit lawSuit = lawSuitsTable.getSelectionModel().getSelectedItem();
        if(lawSuit != null) {
            super.setCurrentLawsuit(lawSuit);
            mainScreensController.showNewMainScreen("/Screens/LawSuit/lawSuit.fxml");
        }
    }
}