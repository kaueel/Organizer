package Screens.LawSuit;

import Controllers.DataController;
import Controllers.MainScreensController;
import Controllers.Screen;
import Models.Client;
import Models.Employee;
import Models.State;
import Utils.Validation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class LawSuit extends Screen {
    private DataController mDataController = DataController.getInstance();
    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField LawSuitNumber;

    @FXML
    private TextField LawSuitTitle;

    @FXML
    private TextField LawSuitDescription;

    @FXML
    private TextField LawSuitForum;

    @FXML
    private TextField LawSuitCourt;

    @FXML
    private TextField LawSuitType;

    @FXML
    private TextField LawSuitOppositorName;

    @FXML
    private TextField LawSuitOppositorDocument;

    @FXML
    private TextField LawSuitClientDocument;

    @FXML
    private Button btnSaveLawSuit;

    @FXML
    private ComboBox<Employee> comboEmployee;

    private void insertValidation() {
        LawSuitNumber.addEventFilter(KeyEvent.KEY_TYPED, Validation.numericValidation(null));
    }

    @FXML
    void initialize() {

        ObservableList<Employee> employees = (ObservableList<Employee>) DataController.getInstance().getAllObjectsOfType(Employee.class);
        comboEmployee.getItems().addAll(employees);
        comboEmployee.getSelectionModel().selectFirst();

        if (getCurrentLawsuit() == null) {
            setCurrentLawsuit(new Models.LawSuit());
            getCurrentLawsuit().setClientByClientId(getCurrentClient());


            if (getCurrentClient() != null)
                LawSuitClientDocument.setText(getCurrentClient().getDocumentNumber());

        } else {

            LawSuitClientDocument.setText(getCurrentLawsuit().getClientByClientId().getDocumentNumber());
            LawSuitOppositorName.setText(getCurrentLawsuit().getOppositeName());
            LawSuitOppositorDocument.setText(getCurrentLawsuit().getOppositeDocument());
            LawSuitNumber.setText(getCurrentLawsuit().getNumber());
            LawSuitTitle.setText(getCurrentLawsuit().getTitle());
            LawSuitDescription.setText(getCurrentLawsuit().getDescription());
            LawSuitForum.setText(getCurrentLawsuit().getForum());
            LawSuitCourt.setText(getCurrentLawsuit().getCourt());
            LawSuitType.setText(getCurrentLawsuit().getType());

            int indexEmployee = 0;

            for (int i = 0; i < employees.size(); i++) {

                if (employees.get(i).getId() == getCurrentLawsuit().getEmployeeByEmployee().getId()) {
                    indexEmployee = i;
                    break;
                }

            }

            comboEmployee.getSelectionModel().select(indexEmployee);
        }

        insertValidation();
    }


    @FXML
    void SaveLawSuit(ActionEvent event) {

        if (Validation.isEveryInputFilled(
                LawSuitClientDocument.getText(),
                LawSuitOppositorName.getText(),
                LawSuitOppositorDocument.getText(),
                LawSuitNumber.getText(),
                LawSuitTitle.getText(),
                LawSuitDescription.getText(),
                LawSuitForum.getText(),
                LawSuitCourt.getText(),
                LawSuitType.getText())) {

            Client client = (Client) mDataController.getObjectWithValue(Client.class, "documentNumber", LawSuitClientDocument.getText());

            if (client == null) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro!");
                dialogoErro.setHeaderText("Cliente invalido");
                dialogoErro.setContentText("O CPF digitado não corresponde a nenhum cliente");
                dialogoErro.showAndWait();
                return;
            }

            Employee employee = comboEmployee.getSelectionModel().getSelectedItem();

            if (employee == null) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro!");
                dialogoErro.setHeaderText("Funcionario invalido");
                dialogoErro.setContentText("Selecione um funcionario para continuar");
                dialogoErro.showAndWait();
                return;
            }

            getCurrentLawsuit().setClientByClientId(client);
            getCurrentLawsuit().setEmployeeByEmployee(employee);
            getCurrentLawsuit().setOppositeName(LawSuitOppositorName.getText());
            getCurrentLawsuit().setOppositeDocument(LawSuitOppositorDocument.getText());
            getCurrentLawsuit().setNumber(LawSuitNumber.getText());
            getCurrentLawsuit().setTitle(LawSuitTitle.getText());
            getCurrentLawsuit().setDescription(LawSuitDescription.getText());
            getCurrentLawsuit().setForum(LawSuitForum.getText());
            getCurrentLawsuit().setCourt(LawSuitCourt.getText());
            getCurrentLawsuit().setType(LawSuitType.getText());

            if (getCurrentLawsuit().getId() > 0)
                mDataController.updateObject(getCurrentLawsuit());
            else
                mDataController.saveObject(getCurrentLawsuit());

            MainScreensController.getInstance().showNewMainScreen("/Screens/LawSuits/lawSuits.fxml");
        } else {
            Validation.showErrorDialog(
                    "Oooops...",
                    "Informações inválidas",
                    "Parece que há alguma campo sem preencher, volte ao form para validar"
            );
        }
    }
}
