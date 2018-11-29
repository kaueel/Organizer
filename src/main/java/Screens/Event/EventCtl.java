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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

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
    private AnchorPane pane;

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
            if((getCurrentLawsuit() == null || getTypeOfLastSettedClass() != LawSuit.class) && (getCurrentMeeting() == null && getTypeOfLastSettedClass() != Meeting.class) ) {
                Validation.showErrorDialog("Erro!", "Falha ao carregar os dados", "Não é possivel abrir a tela do evento.");
                pane.setVisible(false);
                return;
            }else if(getCurrentMeeting() != null && getTypeOfLastSettedClass() == Meeting.class) {
                    EventDescriptionField.setText(getCurrentMeeting().getDescription());
                    EventLocalField.setText(getCurrentMeeting().getLocal());
                    EventTitleField.setText(getCurrentMeeting().getSubject());
                    Instant instant = getCurrentMeeting().getStartTime().toInstant();
                    ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
                    EventTimeField.setValue(zdt.toLocalDate());


            }else if(getCurrentLawsuit() == null || getTypeOfLastSettedClass() != LawSuit.class) {
                Validation.showErrorDialog("Erro!", "Selecione um processo", "Selecione um processo para criar um evento");
                pane.setVisible(false);
            }
        }catch(Exception ex){
            Validation.showErrorDialog("Erro!", "Erro desconhecido", ex.toString());
        }

        insertValidation();
    }

    private void insertValidation() {
        EventHoraField.addEventFilter(KeyEvent.KEY_TYPED, Validation.numericValidation(2));
    }



}
