package Screens.Event;

import Controllers.DataController;
import Controllers.MainScreensController;
import Controllers.Screen;
import Models.LawSuit;
import Models.Meeting;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Date;


public class EventCtl extends Screen {
    private DataController mDataController = DataController.getInstance();

    @FXML
    private URL location;

    @FXML
    private TextField EventTitleField;

    @FXML
    private Button btnSaveEvent;

    @FXML
    private TextField EventDescriptionField;

    @FXML
    private TextField EventLocalField;

    @FXML
    private Date EventTimeField;

    @FXML
    void SaveEvent(ActionEvent event) {

        Meeting meeting = null;
        if(getCurrentMeeting() != null && getTypeOfLastSettedClass() == Meeting.class) {
            meeting = getCurrentMeeting();
        }else{
            meeting = new Meeting();
            meeting.setLawSuitByLawSuitId(getCurrentLawsuit());
            meeting.setClientByClientId(getCurrentLawsuit().getClientByClientId());
        }
//        meeting.setDateTime(new java.sql.Date(EventTimeField.getTime()));
        meeting.setDescription(EventDescriptionField.getText());
//        meeting.setLocal(EventLocalField.getText());
        meeting.setSubject(EventTitleField.getText());

        if(meeting.getId() > 0){
            mDataController.updateObject(event);
        }else{
            mDataController.saveObject(event);
        }
    }

    @FXML
    void initialize() {
        try{
            if(getCurrentLawsuit() == null || getTypeOfLastSettedClass() != LawSuit.class) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro!");
                dialogoErro.setHeaderText("Processo invalido");
                dialogoErro.setContentText("Selecione um processo para continuar");
                dialogoErro.showAndWait();
                MainScreensController.getInstance().showNewMainScreen("/Screens/LawSuits/lawSuits.fxml");
                return;
            }
        }catch(Exception ex){

        }
        try{
            if(getCurrentMeeting() != null && getTypeOfLastSettedClass() == Meeting.class) {
                EventDescriptionField.setText(getCurrentMeeting().getDescription());
                EventLocalField.setText(getCurrentMeeting().getLocal());
                EventTitleField.setText(getCurrentMeeting().getSubject());
            }
        }catch(Exception ex){

        }
    }
}
