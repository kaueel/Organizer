package Screens.Toolbar;

import Controllers.MainScreensController;
import Controllers.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class Toolbar extends Screen implements Observer {
    private String centerScreenTitle;
    private MainScreensController mainScreensController;


    @FXML
    private Label lblToolbar;


    @FXML
    private void initialize() {
        mainScreensController = MainScreensController.getInstance();
        MainScreensController.addObserverStatic(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        this.lblToolbar.setText((String) arg);
    }
}