package Screens.Client;

import Controllers.DataController;
import Controllers.MainScreensController;
import Models.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class ClientCtl {
    ObservableList<ClientType> typesOfClient;
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
    private TextField ClientPhoneField;

    @FXML
    private TextField clientStreetField;

    @FXML
    private TextField clientDistrictField;

    @FXML
    private TextField clientAdressNumberField;

    @FXML
    private TextField clientCityField;

    @FXML
    private TextField clientAdressStateField;

    @FXML

    private TextField clientCepField;

    @FXML
    private ToggleGroup clientType;

    @FXML
    private RadioButton radioPerson;

    @FXML
    private RadioButton radioCompany;

    @FXML
    private Button btnSaveClient;

    @FXML
    void SaveClient(ActionEvent event) {

        //Creating Address
        City city = new City();
        State state = new State();
        Address address = new Address();
        city.setCity(clientCityField.getText());
        state.setState(clientAdressStateField.getText());
        mDataController.saveObject(state);
        mDataController.saveObject(city);

        address.setCityByCityId(city);
        address.setStateByStateId(state);
        address.setDistrict(clientDistrictField.getText());
        address.setPostalCode(clientCepField.getText());
        address.setAddress(clientStreetField.getText());
        address.setAddress2(clientAdressNumberField.getText());
        mDataController.saveObject(address);
        //Saving new client
        Client client = new Client();
        client.setAddressByAddressId(address);
        client.setDocumentNumber(ClientCpfField.getText());
        client.setName(ClientNameField.getText());
        client.setEmail(ClientEmailField.getText());
        client.setPhone(ClientPhoneField.getText());
        //Verifiyng clientType
        if (clientType.getSelectedToggle() == radioPerson){
            client.setClientTypeByClientTypeId(typesOfClient.get(0));
        }
        else
            client.setClientTypeByClientTypeId(typesOfClient.get(1));
        mDataController.saveObject(client);
    }

    @FXML
    void initialize() {
        typesOfClient = (ObservableList<ClientType>) mDataController.getAllObjectsOfType(ClientType.class);
        if (typesOfClient.isEmpty()){
            ClientType pessoaFisica = new ClientType();
            pessoaFisica.setName("Pessoa Física");
            typesOfClient.add(pessoaFisica);
            mDataController.saveObject(pessoaFisica);

            ClientType pessoaJuridica = new ClientType();
            pessoaJuridica.setName("Pessoa Jurídica");
            typesOfClient.add(pessoaJuridica);
            mDataController.saveObject(pessoaJuridica);

        }

    }
}
