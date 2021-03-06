package Screens.Clients;

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

public class ClientsClt extends Screen {
    private MainScreensController mainScreensController = MainScreensController.getInstance();
    private DataController dataController = DataController.getInstance();
    private ObservableList<Client> clients = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnNewClient;

    @FXML
    private TextField searchfield;

    @FXML
    private TableColumn<ObservableList<Employee>, String> rowClientName;

    @FXML
    private TableColumn<ObservableList<Employee>, String> rowClientPhone;

    @FXML
    private TableColumn<ObservableList<Employee>, String> rowClientDocument;

    @FXML
    private TableView<Client> clientsTable;

    @FXML
    void initialize() {
        clients = (ObservableList<Client>) dataController.getAllObjectsOfType(Client.class);
        rowClientName.setCellValueFactory(new PropertyValueFactory<>("name"));
        rowClientPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        rowClientDocument.setCellValueFactory(new PropertyValueFactory<>("email"));
        clientsTable.setItems(clients);
    }

    @FXML
    void callClientScreen() {
        super.setCurrentClient(null);
        mainScreensController.showNewMainScreen("/Screens/Client/client.fxml");
    }

    @FXML
    void setCurrentClient() {
        if(clientsTable.getSelectionModel().getSelectedItem() != null) {
            super.setTypeOfLastSettedClass(Client.class);
            super.setCurrentClient(clientsTable.getSelectionModel().getSelectedItem());
            mainScreensController.showNewMainScreen("/Screens/ClientTabs/clientTabs.fxml");
        }
    }

    @FXML
    void search() {
        String chave = searchfield.getText().toUpperCase();
        ObservableList<Client> clientsPesquisa = FXCollections.observableArrayList();

        if (!chave.isEmpty()) {
            for (Client cli : clients) {
                if (cli.getName().toUpperCase().contains(chave) || cli.getPhone().toUpperCase().contains(chave) || cli.getEmail().toUpperCase().contains(chave))
                    clientsPesquisa.add(cli);
            }
        }else{
            clientsPesquisa.addAll(clients);
        }

        clientsTable.setItems(clientsPesquisa);
    }
}