import Controllers.DataController;
import Controllers.MainScreensController;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;


//Obs: "mainContainer" is the root Pane of the application and it's first level must be a BorderPane.

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MainScreensController mainScreenController = MainScreensController.getInstance();
        DataController dataController = DataController.getInstance();
        Font.loadFont(Main.class.getResource("Screens/Toolbar/fontLogo.ttf").toExternalForm(), 12);
        primaryStage.setTitle("Organizer");
        primaryStage.setScene(mainScreenController.getMainScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
        mainScreenController.showNewMainScreen("/Screens/Login/Login.fxml");
        mainScreenController.showNewTopScreen("/Screens/Toolbar/toobar.fxml");

    }
}
