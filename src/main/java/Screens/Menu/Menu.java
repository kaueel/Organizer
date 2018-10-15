package Screens.Menu;

import Controllers.MainScreensController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.Observable;
import java.util.Observer;

public class Menu implements Observer , EventHandler<MouseEvent> {

    @Override
    public void update(Observable o, Object arg) {

    }

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

    @Override
    public void handle(MouseEvent event) {

        if(event.getEventType().toString().equals("MOUSE_ENTERED")){
            ((Label)event.getSource()).setStyle("-fx-background-color: #e2e2e2;");
        }
        else if(event.getEventType().toString().equals("MOUSE_EXITED"))
        {
            ((Label)event.getSource()).setStyle("-fx-background-color: transparent");
        }
    }
}