package Screens.Employees;

import java.net.URL;
import java.util.ResourceBundle;

import Controllers.MainScreensController;
import Controllers.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class EmployeesCtl extends Screen {
    private MainScreensController mainScreensController = MainScreensController.getInstance();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnNewEmployee"
    private Button btnNewEmployee;

    @FXML // fx:id="employeesTable"
    private TableView<?> employeesTable;


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }

    @FXML
    void callEmployeeScreen(){
     mainScreensController.showNewMainScreen("/Screens/Employee/Employee.fxml");

    }
}