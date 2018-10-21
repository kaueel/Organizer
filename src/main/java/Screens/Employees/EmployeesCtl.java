package Screens.Employees;

import java.net.URL;
import java.util.ResourceBundle;

import Controllers.DataController;
import Controllers.MainScreensController;
import Controllers.Screen;
import Models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeesCtl extends Screen {
    private MainScreensController mainScreensController = MainScreensController.getInstance();
    private DataController dataController = DataController.getInstance();
    private ObservableList<Employee> employees =  FXCollections.observableArrayList();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnNewEmployee"
    private Button btnNewEmployee;

    @FXML
    private TableColumn<ObservableList<Employee>, String> rowEmployeeName;
    @FXML
    private TableColumn<ObservableList<Employee>, String> rowEmployeePhone;
    @FXML
    private TableColumn<ObservableList<Employee>, String> rowEmployeeCargo;

    @FXML // fx:id="employeesTable"
    private TableView<Employee> employeesTable;


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {


        for (Object employee : dataController.getAllObjectsOfType(Employee.class)){
            employees.add((Employee) employee);
        }


        rowEmployeeName.setCellValueFactory(new PropertyValueFactory<>("name"));
        rowEmployeePhone.setCellValueFactory(new PropertyValueFactory<>("login"));
        rowEmployeeCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));

        employeesTable.setItems(employees);
        System.out.println("teste");
    }

    @FXML
    void callEmployeeScreen(){
     mainScreensController.showNewMainScreen("/Screens/Employee/Employee.fxml");

    }
}