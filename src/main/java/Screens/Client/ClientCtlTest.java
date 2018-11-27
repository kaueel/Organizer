package Screens.Client;

import Screens.Client.ClientCtl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientCtlTest {
    ClientCtl control;

    @Before
    public void start() throws Exception {
        control = new ClientCtl();
    }

    @Test
    public void saveClient() throws Exception {
        try {
            control.SaveClient(null);
        }catch(Exception e){

        }
    }

    @Test
    public void getResources() throws Exception {
        control.setResources(null);
        control.getResources();
    }

    @Test
    public void setResources() throws Exception {
        control.setResources(null);
    }

    @Test
    public void initialize() throws Exception {
        control.initialize();
    }

    @Test
    public void getCurrentEmployee() throws Exception {
        control.setCurrentEmployee(null);
        control.getCurrentEmployee();
    }

    @Test
    public void setCurrentEmployee() throws Exception {
        control.setCurrentEmployee(null);
    }

    @Test
    public void getCurrentMeeting() throws Exception {
        control.setCurrentMeeting(null);
        control.getCurrentMeeting();
    }

    @Test
    public void setCurrentMeeting() throws Exception {
        control.setCurrentMeeting(null);
    }

    @Test
    public void getCurrentClient() throws Exception {
        control.setCurrentClient(null);
        control.getCurrentClient();
    }

    @Test
    public void setCurrentClient() throws Exception {
        control.setCurrentClient(null);
    }

    @Test
    public void getCurrentEmplyee() throws Exception {
        control.setCurrentEmployee(null);
        control.getCurrentEmployee();
    }

    @Test
    public void setCurrentEmplyee() throws Exception {
        control.setCurrentEmployee(null);
    }

    @Test
    public void getCurrentLawsuit() throws Exception {
        control.setCurrentLawsuit(null);
        control.getCurrentLawsuit();
    }

    @Test
    public void setCurrentLawsuit() throws Exception {
        control.setCurrentLawsuit(null);
    }

    @Test
    public void getCurrentEvent() throws Exception {
        control.setCurrentEvent(null);
        control.getCurrentEvent();
    }

}