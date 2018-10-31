package Screens.Login;

import Controllers.DataController;
import Controllers.MainScreensController;
import Controllers.Screen;
import Models.Employee;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login extends Screen {
    private DataController dataController = DataController.getInstance();
    private MainScreensController mainScreensController = MainScreensController.getInstance();
    @FXML
    private Button btnLogin;
    @FXML
    private TextField usrField;
    @FXML
    private PasswordField pwdField;
    @FXML
    private Label lblWrongPassword;

    @FXML
    private void initialize() {

    }

    @FXML
    void loginUser() {
        String loginText = usrField.getText();
        String pwdText = pwdField.getText();
        ObservableList<Employee> employeesList = (ObservableList<Employee>) dataController.getAllObjectsOfType(Employee.class);
        for (Employee employee : employeesList) {
            if ((loginText.equals(employee.getLogin()))) {
                if (pwdText.equals(employee.getToken())) {
                    mainScreensController.showNewMainScreen("/Screens/Employees/employees.fxml");
                    mainScreensController.showNewLeftScreen("/Screens/Menu/menu.fxml");
                } else {
                    lblWrongPassword.setOpacity(1);
                }
            } else {
                lblWrongPassword.setOpacity(1);
            }
        }
    }
}
