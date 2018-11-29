package Screens.Files;

import Controllers.Config;
import Controllers.DataController;
import Controllers.Screen;
import Controllers.TemplateCompile;
import Models.Client;
import Models.DocumentTemplates;
import Models.Employee;
import Models.LawSuit;
import Utils.Validation;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import static com.sun.javafx.PlatformUtil.isLinux;
import static com.sun.javafx.PlatformUtil.isWindows;


public class Files extends Screen {
    private DataController mDataController = DataController.getInstance();

    @FXML
    private TreeView<FileItem> treeFiles;

    @FXML
    private ComboBox<DocumentTemplates> comboTemplate;

    @FXML
    private Button createFileProcess;

    @FXML
    void initialize() {


        String path = Config.getPropertyValue("pathFileStart");

        comboTemplate.setDisable(true);
        createFileProcess.setDisable(true);

        if(getCurrentClient() != null && getTypeOfLastSettedClass() == Client.class){
            path += "/Clientes/"+ getCurrentClient().getName();
        }

        else if(getCurrentLawsuit() != null && getTypeOfLastSettedClass() == LawSuit.class){
            path += "/Clientes/"+ getCurrentLawsuit().getClientByClientId().getName()+"/"+getCurrentLawsuit().getNumber()+" - "+getCurrentLawsuit().getTitle();

            comboTemplate.setDisable(false);
            createFileProcess.setDisable(false);
        }
        else if(getCurrentEmployee() != null && getTypeOfLastSettedClass()  == Employee.class){
            path += "/Employee/"+getCurrentEmployee().getName();
        }else{

            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro!");
            dialogoErro.setHeaderText("Erro ao abrir o arquivo");
            dialogoErro.setContentText("Não é possivel abrir o arquivo no momento");
            dialogoErro.showAndWait();

            treeFiles.setVisible(false);
            comboTemplate.setVisible(false);
            createFileProcess.setVisible(false);
        }

        ObservableList<DocumentTemplates> templates = (ObservableList<DocumentTemplates>) DataController.getInstance().getAllObjectsOfType(DocumentTemplates.class);
        comboTemplate.getItems().addAll(templates);
        comboTemplate.getSelectionModel().selectFirst();


        File file = new File(path);
        file.mkdirs();


        FileItem folder = new FileItem(path);
        TreeItem<FileItem> raiz = new TreeItem<>(folder);


        LoadSubItens(raiz,path);

        treeFiles.setRoot(raiz);
        treeFiles.setShowRoot(false);
    }

    private void LoadSubItens(TreeItem<FileItem> node,String path) {



        File fileImage = new File("src/main/java/Screens/Files/folder.png");
        Image image = new Image(fileImage.toURI().toString());

        FileItem folder = new FileItem(path);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {

            TreeItem<FileItem> item = null;


            if(file.isFile()){
                item = new TreeItem<>(new FileItem(file.getPath()));
            }
            else {

                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setFitHeight(20);
                imageView.setFitWidth(20);

                item = new TreeItem<>(new FileItem(file.getPath()), imageView);
            }

            node.getChildren().add(item);
        }
    }

    protected class FileItem extends File{

        public FileItem(String pathname) {
            super(pathname);
        }

        public FileItem(String parent, String child) {
            super(parent, child);
        }

        public FileItem(File parent, String child) {
            super(parent, child);
        }

        public FileItem(URI uri) {
            super(uri);
        }

        @Override
        public String toString() {
           return getName();
        }
    }


    @FXML
    void openNode(MouseEvent mouseEvent) throws IOException {
        TreeItem<FileItem> item = treeFiles.getSelectionModel().getSelectedItem();
        FileItem file = item.getValue();

        if(mouseEvent.getClickCount() == 2 && file.isFile()) {

            String command = "";

            if (isLinux()) {
                command = "/" + file.getCanonicalPath().replace(" ","\\ ")+"";
            } else if (isWindows()) {
                command = "cmd /C  \"" + file.getCanonicalPath()+"\"";
            } else
                return;

            try {
                Runtime.getRuntime().exec(command);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }else if(!file.isFile() && item.getChildren().size() == 0){
            LoadSubItens(item,file.getPath());
            item.setExpanded(true);
        }else{
            item.setExpanded(!item.isExpanded());
        }


    }

    @FXML
    void generateFile(){
        DocumentTemplates template = comboTemplate.getSelectionModel().getSelectedItem();

        File outputFile = treeFiles.getRoot().getValue();

        TemplateCompile templateCompile = new TemplateCompile(template,outputFile);
        try {
            templateCompile.compiler();
        }catch (Exception ex){
            Validation.showErrorDialog("Erro!","Erro ao compilar o template",ex.toString());

        }

        treeFiles.getRoot().getChildren().clear();

        LoadSubItens( treeFiles.getRoot(), treeFiles.getRoot().getValue().getPath());

    }
}
