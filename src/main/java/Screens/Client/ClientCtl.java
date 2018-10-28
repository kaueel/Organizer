package Screens.Client;

import Controllers.DataController;
import Models.Client;
import Models.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class ClientCtl {
    private DataController mDataController = DataController.getInstance();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ClientCpfField;

    @FXML
    private TextField ClientNameField;

    @FXML
    private TextField ClientEmailField;

    @FXML
    private Button btnSaveClient;

    @FXML
    private TextField ClientPhoneField;


    @FXML
    void SaveClient(ActionEvent event) {

        Client client = new Client();
        client.setDocumentNumber(ClientCpfField.getText());
        client.setName(ClientNameField.getText());
        client.setEmail(ClientEmailField.getText());
        client.setPhone(ClientPhoneField.getText());
        mDataController.saveObject(client);
    }

    @FXML
    void initialize() {


    }
}
