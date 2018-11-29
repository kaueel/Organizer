package Screens.Events;

import Controllers.DataController;
import Controllers.MainScreensController;
import Controllers.Screen;
import Models.Client;
import Models.Employee;
import Models.LawSuit;
import Models.Meeting;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class EventsClt extends Screen {
    private MainScreensController mainScreensController = MainScreensController.getInstance();
    private DataController dataController = DataController.getInstance();
    private ObservableList<Meeting> meeting = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnNewClient;

    @FXML
    private TableColumn<ObservableList<Meeting>, String> rowEventSubject;
    @FXML
    private TableColumn<ObservableList<Meeting>, String> rowClientName;
    @FXML
    private TableColumn<ObservableList<Meeting>, String> rowLawSuitTitle;
    @FXML
    private TableColumn<ObservableList<Meeting>, String> rowLocal;
    @FXML
    private TableColumn<ObservableList<Meeting>, Date> rowDateTime;

    @FXML
    private TableView<Meeting> meetingTable;

    @FXML
    void initialize() {

        meeting = (ObservableList<Meeting>) dataController.getAllObjectsOfType(Meeting.class);



        ArrayList<Integer> itensRemove = new ArrayList<Integer>();


        if(getTypeOfLastSettedClass() == Client.class && getCurrentClient() != null){
            int count = 0;
            for (Meeting m : meeting) {
                if(!m.getLawSuitByLawSuitId().getClientByClientId().getId().equals(getCurrentClient().getId())){
                    itensRemove.add(count);
                }
                count++;
            }
        }else if(getTypeOfLastSettedClass() == Employee.class && getCurrentEmployee() != null){
            int count = 0;
            for (Meeting m: meeting) {
                if(!m.getLawSuitByLawSuitId().getEmployeeByEmployee().getId().equals(getCurrentEmployee().getId())){
                    itensRemove.add(count);
                }
                count++;
            }
        }else if(getTypeOfLastSettedClass() == LawSuit.class && getCurrentLawsuit() != null){
            int count = 0;
            for (Meeting m: meeting) {
                if(!(m.getLawSuitByLawSuitId().getId() == (getCurrentLawsuit().getId()))){
                    itensRemove.add(count);
                }
                count++;
            }
        }

        for (int i = itensRemove.size()-1; i >= 0; i--) {
            meeting.remove((int)itensRemove.get(i));
        }




        rowEventSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        rowClientName.setCellValueFactory(new PropertyValueFactory<>("clientByClientId"));
        rowLawSuitTitle.setCellValueFactory(new PropertyValueFactory<>("lawSuitByLawSuitId"));
        rowLocal.setCellValueFactory(new PropertyValueFactory<>("local"));
        rowDateTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        rowDateTime.setCellFactory(column -> {
            TableCell<ObservableList<Meeting>, Date> cell = new TableCell<ObservableList<Meeting>, Date>() {
                private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty) {
                        setText(null);
                    }
                    else {
                        this.setText(format.format(item));
                    }
                }
            };

            return cell;
        });
        meetingTable.setItems(meeting);
    }

    @FXML
    void callEventScreen() {
        mainScreensController.showNewMainScreen("/Screens/Event/event.fxml");
    }

    @FXML
    void callEditMeeting(MouseEvent click) {
        if (click.getClickCount() == 2) {
            super.setTypeOfLastSettedClass(Meeting.class);
            super.setCurrentMeeting(meetingTable.getSelectionModel().getSelectedItem());
        }
    }
}