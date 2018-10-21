package Screens.HelloWord;

import Controllers.DataController;
import Models.Country;
import Controllers.Screen;
import javafx.fxml.FXML;

import java.util.List;

public class HelloWord extends Screen {
    int requiredAcesslevel;

    @FXML
    private void initialize() {
        requiredAcesslevel = 0;
    }



}