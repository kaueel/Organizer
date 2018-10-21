package Screens.Menu;

import Controllers.DataController;
import Controllers.MainScreensController;
import Models.Country;
import Screens.AbstractScreen;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.Observable;
import java.util.Observer;

public class Menu extends AbstractScreen implements Observer, EventHandler<MouseEvent> {

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
    public void test() {
        Country country = new Country();
        country.setCountry("Teste2");
        DataController mDataController = DataController.getInstance();
        mDataController.saveObject(country);
        Country retrievedCountry = (Country) mDataController.getObjectById(Country.class, 1);
        System.out.println(retrievedCountry.getCountry());
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