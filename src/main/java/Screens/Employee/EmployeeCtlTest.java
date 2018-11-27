package Screens.Employee;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeCtlTest {
    EmployeeCtl control;

    @Before
    public void start(){
        control = new EmployeeCtl();
    }

    @Test
    public void saveEmployee() throws Exception {
        try{
            control.SaveEmployee(null);
        }catch (Exception e){

        }
    }

    @Test
    public void initialize() throws Exception {
        control.initialize();
    }

}