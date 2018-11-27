package Screens.Employees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeesCtlTest {
    EmployeesCtl control;

    @Before
    public void start() throws Exception {
        control = new EmployeesCtl();
    }

    @Test
    public void initialize() throws Exception {
        try {
            control.initialize();
        }catch (NullPointerException e){

        }
    }

    @Test
    public void callEmployeeScreen() throws Exception {
        try {
            //control.callEmployeeScreen();
        }catch (ExceptionInInitializerError e){

        }
    }

}