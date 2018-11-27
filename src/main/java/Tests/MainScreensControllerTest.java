import Controllers.MainScreensController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainScreensControllerTest {

    private MainScreensController mainScreensController;

    @Before
    public void getInstance() {
        mainScreensController = MainScreensController.getInstance();
    }

    @Test
    public void addObserverStatic() {
        MainScreensController.addObserverStatic((o, arg) -> { });
    }

    @Test
    public void getTitle() {
        Assert.assertNull(mainScreensController.getTitle());
    }

    @Test
    public void getMainScene() {
        try {
            Assert.assertNull(mainScreensController.getMainScene());
        } catch (ExceptionInInitializerError e) { }
    }

    @Test
    public void showNewMainScreen() {
        try {
            mainScreensController.showNewMainScreen(null);
        } catch (NullPointerException e) { }
    }

    @Test
    public void showNewTopScreen() {
        try {
            mainScreensController.showNewTopScreen(null);
        } catch (NullPointerException e) { }
    }

    @Test
    public void showNewFooterScreen() {
        try {
            mainScreensController.showNewFooterScreen(null);
        } catch (NullPointerException e) { }
    }

    @Test
    public void showNewLeftScreen() {
        try {
            mainScreensController.showNewLeftScreen(null);
        } catch (NullPointerException e) { }
    }
}