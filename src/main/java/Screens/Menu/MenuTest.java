package Screens.Menu;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class MenuTest {
    Menu menu;

    @Before
    public void setUp() throws Exception {
        menu = new Menu();
    }

    @Test
    public void update() throws Exception {
        menu.update(null, null);
    }

    @Test
    public void callEmployeeScreen() throws Exception {
        try {
            menu.callEmployeeScreen();
        }catch (NullPointerException e){

        }
    }

    @Test
    public void callClientScreen() throws Exception {
        try{
            menu.callClientScreen();
        }catch (NullPointerException e){

        }
    }

    @Test
    public void callTemplateScreen() throws Exception {
        try{
            menu.callTemplateScreen();
        }catch(NullPointerException e){

        }
    }

    @Test
    public void handle() throws Exception {
        try{
            menu.handle(null);
        }catch (NullPointerException e){

        }
    }

    @Test
    public void initialize(){
        //menu.initialize();
    }
}