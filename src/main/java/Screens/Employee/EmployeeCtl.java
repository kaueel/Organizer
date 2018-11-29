package Screens.Employee;

import Controllers.DataController;
import Controllers.MainScreensController;
import Controllers.Screen;
import Models.Employee;
import Utils.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class EmployeeCtl extends Screen {
    private MainScreensController mainScreensController = MainScreensController.getInstance();
    private DataController mDataController = DataController.getInstance();
    private boolean isNewEmployee = true;
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

    private void insertValidation() {
        EmployeeCpfField.addEventFilter(KeyEvent.KEY_TYPED, Validation.numericValidation(11));
        EmployeePhoneField.addEventFilter(KeyEvent.KEY_TYPED, Validation.numericValidation(11));
        EmployeeSalaryField.addEventFilter(KeyEvent.KEY_TYPED, Validation.numericValidation(null));
    }

    @FXML
    void SaveEmployee(ActionEvent event) {
        if(!Validation.isEveryInputFilled(
                EmployeeCpfField.getText(),
                EmployeePhoneField.getText(),
                EmployeeNameField.getText(),
                EmployeeUserNameField.getText(),
                EmployeePasswordField.getText(),
                EmployeePositionField.getText(),
                EmployeeSalaryField.getText()
        )){
            Validation.showErrorDialog(
                    "Oooops...",
                    "Informações inválidas",
                    "Parece que há alguma campo sem preencher, volte ao form para validar"
            );
            return;
        }

        if (isNewEmployee){
            Employee employee = new Employee();
            Employee isDuplicate = null;
            try {
                isDuplicate = (Employee) mDataController.getObjectWithValue(Employee.class, "cpf", EmployeeCpfField.getText().toString());

            }catch (Exception e){

            }
            if (isDuplicate == null){
            employee.setCpf(EmployeeCpfField.getText());
            employee.setName(EmployeeNameField.getText());
            employee.setLogin(EmployeeUserNameField.getText());
            employee.setToken(EmployeePasswordField.getText());
            employee.setPosition(EmployeePositionField.getText());
            employee.setSalary(EmployeeSalaryField.getText());
            employee.setPhone(EmployeePhoneField.getText());
            employee.setAccessLevel(1);
            mDataController.saveObject(employee);
            callEmployeesScreen();}
            else {
                Validation.showErrorDialog("CPF ja cadastrado", "CPF ja cadastrado", "");
            }
        }else{
            super.getCurrentEmployee().setCpf(EmployeeCpfField.getText());
            super.getCurrentEmployee().setName(EmployeeNameField.getText());
            super.getCurrentEmployee().setLogin(EmployeeUserNameField.getText());
            super.getCurrentEmployee().setToken(EmployeePasswordField.getText());
            super.getCurrentEmployee().setPosition(EmployeePositionField.getText());
            super.getCurrentEmployee().setSalary(EmployeeSalaryField.getText());
            super.getCurrentEmployee().setPhone(EmployeePhoneField.getText());
            super.getCurrentEmployee().setAccessLevel(1);
            mDataController.updateObject(super.getCurrentEmployee());
            callEmployeesScreen();
        }
    }

    @FXML
    void callEmployeesScreen() {
        mainScreensController.showNewMainScreen("/Screens/Employees/employees.fxml");
    }

    @FXML
    void initialize() {
        if (super.getCurrentEmployee() != null) {
            EmployeeCpfField.setText(super.getCurrentEmployee().getCpf());
            EmployeeUserNameField.setText(super.getCurrentEmployee().getLogin());
            EmployeePasswordField.setText(super.getCurrentEmployee().getToken());
            EmployeeSalaryField.setText(super.getCurrentEmployee().getSalary());
            EmployeePositionField.setText(super.getCurrentEmployee().getPosition());
            EmployeeNameField.setText(super.getCurrentEmployee().getName());
            EmployeePhoneField.setText(super.getCurrentEmployee().getPhone());
            isNewEmployee = false;
        }

        insertValidation();
    }
}
