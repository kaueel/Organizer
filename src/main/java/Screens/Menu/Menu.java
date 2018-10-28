package Screens.Menu;

import Controllers.MainScreensController;
import Controllers.Screen;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.Observable;
import java.util.Observer;

public class Menu extends Screen implements Observer, EventHandler<MouseEvent> {

    @FXML
    private Label itemClient;
    @FXML
    private Label itemLowSuit;
    @FXML
    private Label itemEvent;
    @FXML
    private Label itemEmployee;
    @FXML
    private Label itemTemplate;
    private MainScreensController mainScreensController;

    @Override
    public void update(Observable o, Object arg) {

    }

    @FXML
    private void initialize() {
        mainScreensController = MainScreensController.getInstance();
        itemClient.setOnMouseEntered(this);
        itemLowSuit.setOnMouseEntered(this);
        itemEvent.setOnMouseEntered(this);
        itemEmployee.setOnMouseEntered(this);
        itemTemplate.setOnMouseEntered(this);
        itemClient.setOnMouseExited(this);
        itemLowSuit.setOnMouseExited(this);
        itemEvent.setOnMouseExited(this);
        itemEmployee.setOnMouseExited(this);
        itemTemplate.setOnMouseExited(this);

    }

    @FXML
    void callEmployeeScreen() {
        mainScreensController.showNewMainScreen("/Screens/Employees/employees.fxml");
    }

    @FXML
    void callClientScreen() {
        mainScreensController.showNewMainScreen("/Screens/Clients/clients.fxml");
    }


    @Override
    public void handle(MouseEvent event) {

        if (event.getEventType().toString().equals("MOUSE_ENTERED")) {
            ((Label) event.getSource()).setStyle("-fx-background-color: #e2e2e2;");
        } else if (event.getEventType().toString().equals("MOUSE_EXITED")) {
            ((Label) event.getSource()).setStyle("-fx-background-color: transparent");
        }
    }
}