package Screens.Employees;

import Controllers.DataController;
import Controllers.MainScreensController;
import Controllers.Screen;
import Models.Client;
import Models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeesCtl extends Screen {
    private MainScreensController mainScreensController = MainScreensController.getInstance();
    private DataController dataController = DataController.getInstance();
    private ObservableList<Employee> employees = FXCollections.observableArrayList();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button btnNewEmployee;

    @FXML
    private TableColumn<ObservableList<Employee>, String> rowEmployeeName;
    @FXML
    private TableColumn<ObservableList<Employee>, String> rowEmployeePhone;
    @FXML
    private TableColumn<ObservableList<Employee>, String> rowEmployeeCargo;

    @FXML // fx:id="employeesTable"
    private TableView<Employee> employeesTable;

    @FXML
    private TextField searchfield;

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        employees = (ObservableList<Employee>) dataController.getAllObjectsOfType(Employee.class);

        rowEmployeeName.setCellValueFactory(new PropertyValueFactory<>("name"));
        rowEmployeePhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        rowEmployeeCargo.setCellValueFactory(new PropertyValueFactory<>("position"));
        employeesTable.setItems(employees);

    }


    @FXML
    void callEmployeeScreen() {
        super.setCurrentEmployee(null);
        mainScreensController.showNewMainScreen("/Screens/Employee/employee.fxml");
    }

    @FXML
    void setCurrentEmployee() {
        super.setTypeOfLastSettedClass(Employee.class);
        super.setCurrentEmployee(employeesTable.getSelectionModel().getSelectedItem());
        mainScreensController.showNewMainScreen("/Screens/Employee/employee.fxml");
    }

    @FXML
    void search() {
        String chave = searchfield.getText().toUpperCase();
        ObservableList<Employee> employeesPesquisa = FXCollections.observableArrayList();

        if (!chave.isEmpty()) {
            for (Employee emp : employees) {
                if (emp.getName().toUpperCase().contains(chave) || emp.getPhone().toUpperCase().contains(chave) || emp.getPosition().toUpperCase().contains(chave))
                    employeesPesquisa.add(emp);
            }
        }else{
            employeesPesquisa.addAll(employees);
        }

        employeesTable.setItems(employeesPesquisa);
    }
}