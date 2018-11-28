package Controllers;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class MainScreensController extends Observable {
    private static MainScreensController instance;
    private static HashMap<String, String> titlesMap = new HashMap<>();
    private static Scene mainScene;
    private static Parent root;
    private int WIDTH = 1300;
    private int HEIGHT = 700;
    private String currentScreenTitle;

    {
        try {
            root = FXMLLoader.load(getClass().getResource("/Screens/MainContainer/mainContainer.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private MainScreensController() {
        titlesMap.put("/Screens/HelloWord/HelloWord.fxml", "Hello Word");
        titlesMap.put("/Screens/Employees/employees.fxml", "Funcionários");
        titlesMap.put("/Screens/LawSuit/lawSuit.fxml", "Processo");
        titlesMap.put("/Screens/LawSuits/lawSuits.fxml", "Processos");
        titlesMap.put("/Screens/Template/template.fxml", "Template");
        titlesMap.put("/Screens/Templates/templates.fxml", "Templates");
        titlesMap.put("/Screens/Login/login.fxml", "Login");
        titlesMap.put("/Screens/Clients/clients.fxml", "Clientes");
        titlesMap.put("/Screens/Client/client.fxml", "Cliente");
        titlesMap.put("/Screens/Employee/employee.fxml", "Funcionario");
        titlesMap.put("/Screens/ClientTabs/clientTabs.fxml", "Cliente");

    }

    public static synchronized MainScreensController getInstance() {
        if (instance == null) {
            instance = new MainScreensController();
        }
        return instance;
    }

    public static void addObserverStatic(Observer observer) {
        getInstance().addObserver(observer);
    }

    public String getTitle() {
        return currentScreenTitle;
    }

    private Pane getScreenFromMap(String fxmlPath) {
        Pane pane = null;
        FXMLLoader loader = new FXMLLoader(MainScreensController.class.getResource(fxmlPath));
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pane;
    }

    public Scene getMainScene() {
        if (mainScene == null) {
            mainScene = new Scene(root, WIDTH, HEIGHT);
        }
        return mainScene;
    }

    public void showNewMainScreen(String fxmlPath) {
        ((BorderPane) root).setCenter(createScreen(fxmlPath));
        setChanged();
        notifyObservers(titlesMap.get(fxmlPath));
    }

    private Node createScreen(String fxmlPath) {
        Node node = getScreenFromMap(fxmlPath);
        if (titlesMap.get(fxmlPath) == null) {
            currentScreenTitle = "Favor adicione um title a essa tela no constructor da main Screens controller";
        } else {
            currentScreenTitle = titlesMap.get(fxmlPath);
        }
        setChanged();
        notifyObservers();
        if (!node.getClass().getName().equals("javafx.scene.layout.AnchorPane"))
            throw new RuntimeException("You should use AnchorPane as the root of your screen");
        return node;
    }

    public void showNewTopScreen(String fxmlPath) {
        ((BorderPane) root).setTop(createScreen(fxmlPath));
    }

    public void showNewFooterScreen(String fxmlPath) {
        ((BorderPane) root).setBottom(createScreen(fxmlPath));
    }

    public void showNewLeftScreen(String fxmlPath) {
        ((BorderPane) root).setLeft(createScreen(fxmlPath));
    }
}
