package Screens.Menu;

import Controllers.MainScreensController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Menu implements Observer  {

    @Override
    public void update(Observable o, Object arg) {
        //Title.setText(mainScreensController.getTitle());
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

        itemTemplate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mainScreensController.showNewCenterScreen("/Screens/Template/template.fxml");
            }
        });
    }


}