package Tests;

import Screens.Toolbar.Toolbar;
import org.junit.Before;
import org.junit.Test;

import java.util.Observable;

import static org.junit.Assert.*;

public class ToolbarTest {

    private Toolbar toolbar;

    @Before
    public void init() {
        toolbar = new Toolbar();
    }

    @Test
    public void update() {
        try {
            toolbar.update(
                    new Observable(), "test");
        } catch (NullPointerException e) { }
    }
}