package Screens.Template;

import Controllers.DataController;
import Controllers.MainScreensController;
import Controllers.Screen;
import Controllers.TemplateHashVariables;
import Models.Address;
import Models.Client;
import Models.DocumentTemplates;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;

import java.awt.*;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Callable;

import java.awt.datatransfer.*;
import java.util.function.Predicate;

public class Template extends Screen {

    private TemplateHashVariables templateHashVariables = new TemplateHashVariables();
    private ObservableList observableList = templateHashVariables.getKeys();
    private FilteredList<String> filteredList= new FilteredList<>(observableList, data -> true);
    private DataController mDataController = DataController.getInstance();
    private MainScreensController mainScreensController = MainScreensController.getInstance();

    @FXML
    private HTMLEditor htmlEditor;

    @FXML
    private ListView variableList;

    @FXML
    private javafx.scene.control.TextField nameTemplate;

    @FXML
    private javafx.scene.control.TextField nameVariable;

    @FXML
    private void initialize() {

        SortedList<String> sortedList = new SortedList(filteredList);
        sortedList.setComparator(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        variableList.setItems(sortedList);

        if(getCurrentdocumentTemplates() != null){
            nameTemplate.setText(getCurrentdocumentTemplates().getName());
            htmlEditor.setHtmlText(getCurrentdocumentTemplates().getDocumentText());
        }

        nameVariable.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(data -> {
                if (newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseSearch = newValue.toLowerCase();
                return data.toLowerCase().contains(lowerCaseSearch);
            });
        });


    }

    @FXML
    void copyVariableText(MouseEvent click) {
        if (click.getClickCount() == 2) {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection("##"+variableList.getSelectionModel().getSelectedItem().toString());
            clipboard.setContents(stringSelection, null);
        }
    }

    @FXML
    void click_ButtonSaveTemplate(MouseEvent click){
        SaveTemplate();

        mainScreensController.showNewMainScreen("/Screens/Templates/templates.fxml");
    }

    private void SaveTemplate(){

        if(getCurrentdocumentTemplates() == null)
            setCurrentdocumentTemplates(new DocumentTemplates());

        getCurrentdocumentTemplates().setDocumentText(htmlEditor.getHtmlText());
        getCurrentdocumentTemplates().setName(nameTemplate.getText());
        getCurrentdocumentTemplates().setLastUpdate(new Date());

        if(getCurrentdocumentTemplates().getId() > 0){
            mDataController.updateObject(getCurrentdocumentTemplates());
            return;
        }
        mDataController.saveObject(getCurrentdocumentTemplates());
    }



}