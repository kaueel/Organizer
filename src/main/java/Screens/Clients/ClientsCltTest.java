package Screens.Clients;

import Screens.Clients.ClientsClt;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientsCltTest {
    ClientsClt control;

    @Before
    public void stast(){
        control = new ClientsClt();
    }

    @Test
    public void initialize() throws Exception {
        try{
            control.initialize();
        }catch (Exception e){

        }
    }

    @Test
    public void callClientScreen() {
        try {
            control.callClientScreen();
        }catch (ExceptionInInitializerError e){

        }
    }

    @Test
    public void setCurrentClient(){
        try {
            control.setCurrentClient();
        }catch (Exception e){

        }
    }

}