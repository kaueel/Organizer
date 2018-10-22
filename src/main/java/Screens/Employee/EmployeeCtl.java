package Screens.Employee;

import java.net.URL;
import java.util.ResourceBundle;

import Controllers.DataController;
import Models.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class EmployeeCtl {
    private DataController mDataController = DataController.getInstance();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField EmployeeCpfField;

    @FXML
    private TextField EmployeeNameField;

    @FXML
    private Button btnSaveEmployee;

    @FXML
    private TextField EmployeePositionField;

    @FXML
    private TextField EmployeeSalaryField;

    @FXML
    private TextField EmployeePhoneField;

    @FXML
    private TextField EmployeeUserNameField;

    @FXML
    private PasswordField EmployeePasswordField;

    @FXML
    void SaveEmployee(ActionEvent event) {

        Employee employee = new Employee();
                employee.setCpf(EmployeeCpfField.getText());
                employee.setName(EmployeeNameField.getText());
                employee.setLogin(EmployeeUserNameField.getText());
                employee.setToken(EmployeePasswordField.getText());
                employee.setPosition(EmployeePositionField.getText());
                employee.setSalary(EmployeeSalaryField.getText());
                employee.setPhone(EmployeePhoneField.getText());
                employee.setAccessLevel(1);


        mDataController.saveObject(employee);
    }

    @FXML
    void initialize() {


    }
}
