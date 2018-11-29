package Screens.Event;

import Controllers.DataController;
import Controllers.MainScreensController;
import Controllers.Screen;
import Models.LawSuit;
import Models.Meeting;
import Utils.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.util.Date.from;


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
    private TextField EventHoraField;


    @FXML
    private DatePicker EventTimeField;

    @FXML
    void SaveEvent(ActionEvent event) {

        Meeting meeting = null;
        if (getCurrentMeeting() != null && getTypeOfLastSettedClass() == Meeting.class) {
            meeting = getCurrentMeeting();
        } else {
            meeting = new Meeting();
            meeting.setLawSuitByLawSuitId(getCurrentLawsuit());
            meeting.setClientByClientId(getCurrentLawsuit().getClientByClientId());
        }

        LocalDate date = EventTimeField.getValue();
        meeting.setStartTime(from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        try {
            meeting.getStartTime().setHours(Integer.parseInt(EventHoraField.getText()));
        } catch (Exception e) {
            Validation.showErrorDialog("Erro!", "Erro ao converter hora", e.toString());
            return;
        }
        meeting.setDescription(EventDescriptionField.getText());
        meeting.setLocal(EventLocalField.getText());
        meeting.setSubject(EventTitleField.getText());

        if (meeting.getId() > 0) {
            mDataController.updateObject(meeting);
        } else {
            mDataController.saveObject(meeting);
        }

            MainScreensController.getInstance().showNewMainScreen("/Screens/Events/events.fxml");
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
                Instant instant = getCurrentMeeting().getStartTime().toInstant();
                ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
                EventTimeField.setValue(zdt.toLocalDate());
            }
        }catch(Exception ex){

        }
    }
}
