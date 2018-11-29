package Screens.Client;

import Controllers.DataController;
import Controllers.MainScreensController;
import Controllers.Screen;
import Models.*;
import Utils.Validation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class ClientCtl extends Screen {
    ObservableList<ClientType> typesOfClient;
    private MainScreensController mainScreensController = MainScreensController.getInstance();

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
    private ComboBox<State> state;

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

    private void insertValidation() {
        ClientCpfField.addEventFilter(KeyEvent.KEY_TYPED, Validation.numericValidation(null));
        ClientPhoneField.addEventFilter(KeyEvent.KEY_TYPED, Validation.numericValidation(null));
        clientCepField.addEventFilter(KeyEvent.KEY_TYPED, Validation.numericValidation(null));
    }

    @FXML
    void SaveClient(ActionEvent event) {
        if(ClientCpfField.getText().length() != 11 && ClientCpfField.getText().length() != 14) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro!");
            dialogoErro.setHeaderText("CPF/CNPJ inválido!");
            dialogoErro.setContentText("Digite o CPF ou CNPJ sem pontuação, contendo 11 ou 14 caracteres");
            dialogoErro.showAndWait();
            return;
        }else if(!radioCompany.isSelected() && !radioPerson.isSelected()){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro!");
            dialogoErro.setHeaderText("Tipo não selecionado");
            dialogoErro.setContentText("Selecione o tipo de pessoa: Física ou Jurídica");
            dialogoErro.showAndWait();
            return;
        }else if(!Validation.isEveryInputFilled(
                ClientCpfField.getText(),
                clientStreetField.getText(),
                clientAdressNumberField.getText(),
                ClientNameField.getText(),
                clientDistrictField.getText(),
                ClientEmailField.getText(),
                clientCityField.getText(),
                ClientPhoneField.getText(),
                clientCepField.getText())){
            Validation.showErrorDialog(
                    "Oooops...",
                    "Informações inválidas",
                    "Parece que há alguma campo sem preencher, volte ao form para validar"
            );
            return;
        }

        //Creating City
        City city = new City();
        city.setCity(clientCityField.getText());
        city.setUf(state.getSelectionModel().getSelectedItem().getUf());
        mDataController.saveObject(city);

        //Creating Address
        Address address = new Address();
        address.setCityByCityId(city);
        address.setStateByStateId(state.getSelectionModel().getSelectedItem());
        address.setDistrict(clientDistrictField.getText());
        address.setPostalCode(clientCepField.getText());
        address.setAddress(clientStreetField.getText());
        address.setAddress2(clientAdressNumberField.getText());
        mDataController.saveObject(address);

        //Saving new

        if(getCurrentClient() == null){
            Client client  = new Client();
            client.setAddressByAddressId(address);
            client.setAddressNumber(clientAdressNumberField.toString());
            client.setDocumentNumber(ClientCpfField.getText());
            client.setName(ClientNameField.getText());
            client.setEmail(ClientEmailField.getText());
            client.setPhone(ClientPhoneField.getText());
            //Verifiyng clientType
            if (clientType.getSelectedToggle() == radioPerson) {
                client.setClientTypeByClientTypeId(typesOfClient.get(0));
            } else
                client.setClientTypeByClientTypeId(typesOfClient.get(1));
            mDataController.saveObject(client);
            callClientsScreen();
        }else{
            getCurrentClient().setAddressByAddressId(address);
            getCurrentClient().setAddressNumber(clientAdressNumberField.toString());
            getCurrentClient().setDocumentNumber(ClientCpfField.getText());
            getCurrentClient().setName(ClientNameField.getText());
            getCurrentClient().setEmail(ClientEmailField.getText());
            getCurrentClient().setPhone(ClientPhoneField.getText());
            //Verifiyng clientType
            if (clientType.getSelectedToggle() == radioPerson) {
                getCurrentClient().setClientTypeByClientTypeId(typesOfClient.get(0));
            } else
                getCurrentClient().setClientTypeByClientTypeId(typesOfClient.get(1));
            mDataController.updateObject(getCurrentClient());
            callClientsScreen();
        }
    }

    @FXML
    void callClientsScreen() {
        super.setCurrentClient(null);
        mainScreensController.showNewMainScreen("/Screens/Clients/clients.fxml");
    }

    public ResourceBundle getResources() {
        return resources;
    }

    public void setResources(ResourceBundle resources) {
        this.resources = resources;
    }

    @FXML
    void initialize() {

        typesOfClient = (ObservableList<ClientType>) mDataController.getAllObjectsOfType(ClientType.class);
        ObservableList<State> states = (ObservableList<State>) DataController.getInstance().getAllObjectsOfType(State.class);
        state.getItems().addAll(states);
        state.getSelectionModel().selectFirst();
        if (typesOfClient.isEmpty()) {
            ClientType pessoaFisica = new ClientType();
            pessoaFisica.setName("Pessoa Física");
            typesOfClient.add(pessoaFisica);
            mDataController.saveObject(pessoaFisica);
            ClientType pessoaJuridica = new ClientType();
            pessoaJuridica.setName("Pessoa Jurídica");
            typesOfClient.add(pessoaJuridica);
            mDataController.saveObject(pessoaJuridica);
        }
        if (super.getCurrentClient() != null) {
            clientCepField.setText(super.getCurrentClient().getAddressByAddressId().getPostalCode());
            clientAdressNumberField.setText(super.getCurrentClient().getAddressByAddressId().getAddress2());
            clientCityField.setText(super.getCurrentClient().getAddressByAddressId().getCityByCityId().getCity());
            ClientCpfField.setText(super.getCurrentClient().getDocumentNumber());
            ClientEmailField.setText(super.getCurrentClient().getEmail());
            clientDistrictField.setText(super.getCurrentClient().getAddressByAddressId().getDistrict());
            ClientNameField.setText(super.getCurrentClient().getName());
            ClientPhoneField.setText(super.getCurrentClient().getPhone());
            clientStreetField.setText(super.getCurrentClient().getAddressByAddressId().getAddress());
        }
        insertValidation();
    }

}

