package Screens.LawSuits;

import Controllers.DataController;
import Controllers.MainScreensController;
import Controllers.Screen;
import Models.Client;
import Models.Employee;
import Models.LawSuit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
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

    @FXML
    private TextField searchfield;

    @FXML // fx:id="documentTemplatesTable"
    private TableView<LawSuit> lawSuitsTable;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        LawSuits = (ObservableList<LawSuit>) dataController.getAllObjectsOfType(LawSuit.class);

        ArrayList<Integer> itensRemove = new ArrayList<Integer>();


        if(getTypeOfLastSettedClass() == Client.class && getCurrentClient() != null){
            int count = 0;
            for (LawSuit lawSuit : LawSuits) {
                if(!lawSuit.getClientByClientId().getId().equals(getCurrentClient().getId())){
                    itensRemove.add(count);
                }
                count++;
            }
        }else if(getTypeOfLastSettedClass() == Employee.class && getCurrentEmployee() != null){
            int count = 0;
            for (LawSuit lawSuit : LawSuits) {
                if(!lawSuit.getEmployeeByEmployee().getId().equals(getCurrentEmployee().getId())){
                    itensRemove.add(count);
                }
                count++;
            }
        }

        for (int i = itensRemove.size()-1; i >= 0; i--) {
            LawSuits.remove((int)itensRemove.get(i));
        }

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
            super.setTypeOfLastSettedClass(LawSuit.class);
            mainScreensController.showNewMainScreen("/Screens/LawSuitsTabs/lawSuitsTabs.fxml");
        }
    }

    @FXML
    void search() {
        String chave = searchfield.getText().toUpperCase();
        ObservableList<LawSuit> lawSuitsPesquisa = FXCollections.observableArrayList();

        if (!chave.isEmpty()) {
            for (LawSuit law : LawSuits) {
                if (law.getNumber().toUpperCase().contains(chave) || law.getTitle().toUpperCase().contains(chave)
                        || law.getOppositeName().toUpperCase().contains(chave))
                    lawSuitsPesquisa.add(law);
            }
        }else{
            lawSuitsPesquisa.addAll(LawSuits);
        }

        lawSuitsTable.setItems(lawSuitsPesquisa);
    }
}