package Tests;

import Controllers.Screen;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScreenTest {

    private Screen screen;

    @Before
    public void init() {
        screen = new Screen();
    }

    @Test
    public void getCurrentEmployee() {
        Assert.assertNull(screen.getCurrentEmployee());
    }

    @Test
    public void setCurrentEmployee() {
        screen.setCurrentEmployee(null);
    }

    @Test
    public void getCurrentMeeting() {
        Assert.assertNull(screen.getCurrentMeeting());
    }

    @Test
    public void setCurrentMeeting() {
        screen.setCurrentMeeting(null);
    }

    @Test
    public void getCurrentClient() {
        Assert.assertNull(screen.getCurrentClient());
    }

    @Test
    public void setCurrentClient() {
        screen.setCurrentClient(null);
    }

    @Test
    public void getCurrentEmplyee() {
        Assert.assertNull(screen.getCurrentEmplyee());
    }

    @Test
    public void setCurrentEmplyee() {
        screen.setCurrentEmplyee(null);
    }

    @Test
    public void getCurrentLawsuit() {
        Assert.assertNull(screen.getCurrentLawsuit());
    }

    @Test
    public void setCurrentLawsuit() {
        screen.setCurrentLawsuit(null);
    }

    @Test
    public void getCurrentEvent() {
        Assert.assertNull(screen.getCurrentEvent());
    }

    @Test
    public void setCurrentEvent() {
        screen.setCurrentEvent(null);
    }

    @Test
    public void getCurrentdocumentTemplates() {
        Assert.assertNull(Screen.getCurrentdocumentTemplates());
    }

    @Test
    public void setCurrentdocumentTemplates() {
        Screen.setCurrentdocumentTemplates(null);
    }
}