import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.util.HashMap;

class MainScreensController {
        private int WIDTH = 1300;
        private int HEIGHT = 700;
        private static HashMap<String, Pane> screensMap = new HashMap<>();
        private static Scene mainScene;
        private static Parent root;
        {
            try {
                root = FXMLLoader.load(getClass().getResource("/Screens/Menu/menu.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //Avoids rebiulding of already used screens, saving bult panes in a hashMap
        private Pane getScreenFromMap(String fxmlPath){
                Pane pane = screensMap.get(fxmlPath);
            if (pane == null){
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

        Parent getRoot() {
            return root;
        }

        Scene getMainScene() {
            if (mainScene == null) {
                mainScene = new Scene(root, WIDTH, HEIGHT);
            }
            return mainScene;
        }

        void showNewCenterScreen( String fxmlPath) {
            ((BorderPane)root).setCenter(getScreenFromMap(fxmlPath));
        }

        void showNewTopScreen( String fxmlPath) {

            FXMLLoader loader = new FXMLLoader(MainScreensController.class.getResource(fxmlPath));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ((BorderPane)root).setTop(pane);
        }

        void showNewFooterScreen( String fxmlPath) {
            FXMLLoader loader = new FXMLLoader(MainScreensController.class.getResource(fxmlPath));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ((BorderPane)root).setBottom(pane);
        }
    }