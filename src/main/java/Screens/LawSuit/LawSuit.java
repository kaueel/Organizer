package Screens.LawSuit;

import Controllers.DataController;
import Controllers.Screen;
import Models.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class LawSuit extends Screen {
    private DataController mDataController = DataController.getInstance();
    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField LawSuitNumber;

    @FXML
    private TextField LawSuitTitle;

    @FXML
    private TextField LawSuitDescription;

    @FXML
    private TextField LawSuitForum;

    @FXML
    private TextField LawSuitCourt;

    @FXML
    private TextField LawSuitType;

    @FXML
    private TextField LawSuitOppositorName;

    @FXML
    private TextField LawSuitOppositorDocument;

    @FXML
    private Button btnSaveLawSuit;


    @FXML
    void btnSaveLawSuit(ActionEvent event) {

        if( getCurrentLawsuit() == null){

            setCurrentLawsuit(new Models.LawSuit());
            getCurrentLawsuit().setClientByClientId(getCurrentClient());
        }

        mDataController.saveObject(getCurrentLawsuit());
    }

    @FXML
    void initialize() {


    }
}
