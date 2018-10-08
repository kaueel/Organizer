import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


//Obs: "Menu" is the root Pane of the application and it's first level must be a BorderPane.

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
       MainScreensController mainScreenController = MainScreensController.getInstance();
       Parent root = mainScreenController.getRoot();
        primaryStage.setTitle("Organizer");
        primaryStage.setScene(mainScreenController.getMainScene());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
