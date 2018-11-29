package Screens.Templates;

import Controllers.DataController;
import Controllers.MainScreensController;
import Controllers.Screen;
import Models.DocumentTemplates;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Templates extends Screen {
    private MainScreensController mainScreensController = MainScreensController.getInstance();
    private DataController dataController = DataController.getInstance();
    private ObservableList<DocumentTemplates> documentTemplates = FXCollections.observableArrayList();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button btnNewTemplate;

    @FXML
    private TableColumn<ObservableList<DocumentTemplates>, String> rowDocumentTemplateName;

    @FXML
    private TableColumn<ObservableList<DocumentTemplates>, Date> rowDocumentTemplateLastUpdate;

    @FXML // fx:id="documentTemplatesTable"
    private TableView<DocumentTemplates> documentTemplatesTable;

    @FXML
    private TextField searchfield;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        documentTemplates = (ObservableList<DocumentTemplates>) dataController.getAllObjectsOfType(DocumentTemplates.class);

        rowDocumentTemplateName.setCellValueFactory(new PropertyValueFactory<>("name"));
        rowDocumentTemplateLastUpdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

        rowDocumentTemplateLastUpdate.setCellFactory(column -> {
            TableCell<ObservableList<DocumentTemplates>, Date> cell = new TableCell<ObservableList<DocumentTemplates>, Date>() {
                private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty) {
                        setText(null);
                    }
                    else {
                        this.setText(format.format(item));

                    }
                }
            };
            return cell;
        });

        documentTemplatesTable.setItems(documentTemplates);
    }

    @FXML
    void callDocumentTemplatesScreen() {
        setCurrentdocumentTemplates(null);
        mainScreensController.showNewMainScreen("/Screens/Template/template.fxml");
    }

    @FXML
    void setCurrentDocumentTemplates(MouseEvent click) {
        if (click.getClickCount() == 1) {
            DocumentTemplates selectedDocumentTemplates = documentTemplatesTable.getSelectionModel().getSelectedItem();
            if (selectedDocumentTemplates != null) {
                setCurrentdocumentTemplates(selectedDocumentTemplates);
                mainScreensController.showNewMainScreen("/Screens/Template/template.fxml");
            }
        }
    }

    @FXML
    void search() {
        String chave = searchfield.getText().toUpperCase();
        ObservableList<DocumentTemplates> lawSuitsPesquisa = FXCollections.observableArrayList();

        if (!chave.isEmpty()) {
            for (DocumentTemplates doc : documentTemplates) {
                if (doc.getName().toUpperCase().contains(chave) || String.valueOf(doc.getLastUpdate()).toUpperCase().contains(chave))
                    lawSuitsPesquisa.add(doc);
            }
        }else{
            lawSuitsPesquisa.addAll(documentTemplates);
        }

        documentTemplatesTable.setItems(lawSuitsPesquisa);
    }
}