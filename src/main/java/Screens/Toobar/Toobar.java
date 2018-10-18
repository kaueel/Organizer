package Screens.Toobar;

import Controllers.MainScreensController;
import Screens.AbstractScreen;
import javafx.fxml.FXML;

import java.util.Observable;
import java.util.Observer;

public class Toobar extends AbstractScreen implements Observer {
    private String centerScreenTitle;
    private MainScreensController mainScreensController;

    @FXML
    private void initialize() {
        mainScreensController = MainScreensController.getInstance();
        mainScreensController.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.centerScreenTitle = mainScreensController.getTitle();
    }
}