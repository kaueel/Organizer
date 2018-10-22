import Controllers.DataController;
import Controllers.MainScreensController;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.xml.crypto.Data;


//Obs: "mainContainer" is the root Pane of the application and it's first level must be a BorderPane.

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MainScreensController mainScreenController = MainScreensController.getInstance();
        DataController dataController = DataController.getInstance();
        Font.loadFont(Main.class.getResource("Screens/Toobar/fontLogo.ttf").toExternalForm(), 12);
        primaryStage.setTitle("Organizer");
        primaryStage.setScene(mainScreenController.getMainScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
        mainScreenController.showNewMainScreen("/Screens/HelloWord/HelloWord.fxml");
        mainScreenController.showNewLeftScreen("/Screens/Menu/menu.fxml");
        mainScreenController.showNewTopScreen("/Screens/Toobar/toobar.fxml");

    }
}
