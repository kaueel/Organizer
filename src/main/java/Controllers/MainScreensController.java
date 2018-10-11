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

public class MainScreensController extends Observable {
    private static MainScreensController instance;
    private int WIDTH = 1300;
    private int HEIGHT = 700;
    private static HashMap<String, Pane> screensMap = new HashMap<>();
    private static Scene mainScene;
    private ScreensMetaData screensMetaData = new ScreensMetaData();

    public String getTitle() {
        return title;
    }

    private String title;
    private static Parent root;
    {
        try {
            root = FXMLLoader.load(getClass().getResource("/Screens/MainContainer/mainContainer.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private MainScreensController() {
    }

    public static synchronized MainScreensController getInstance() {
        if (instance == null) {
            instance = new MainScreensController();
        }
        return instance;
    }

    //Avoids rebiulding of already used screens, saving bult panes in a hashMap
    private Pane getScreenFromMap(String fxmlPath) {
        Pane pane = screensMap.get(fxmlPath);
        if (pane == null) {
            FXMLLoader loader = new FXMLLoader(MainScreensController.class.getResource(fxmlPath));
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            screensMap.put(fxmlPath, pane);
        }
        return pane;
    }

    public Parent getRoot() {
        return root;
    }

    public Scene getMainScene() {
        if (mainScene == null) {
            mainScene = new Scene(root, WIDTH, HEIGHT);
        }
        return mainScene;
    }

    public void showNewCenterScreen(String fxmlPath) {
        ((BorderPane) root).setCenter(createScreen(fxmlPath));
        this.title = screensMetaData.getTitle(fxmlPath);
        notifyObservers();
    }

    private Node createScreen(String fxmlPath) {
        Node node = getScreenFromMap(fxmlPath);
        if(!node.getClass().getName().equals("javafx.scene.layout.AnchorPane"))
            throw  new RuntimeException("You should use AnchorPane as the root of your screen");
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