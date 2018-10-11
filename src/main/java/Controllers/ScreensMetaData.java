package Controllers;

import java.util.HashMap;

public class ScreensMetaData {
    HashMap<String, String> screensTitle = new HashMap<>();

    public ScreensMetaData() {
        screensTitle.put("Screens/HelloWord/HelloWord.fxml", "HelloHord");
    }

    public String getTitle(String path){
        return screensTitle.get(path);
    }
}
