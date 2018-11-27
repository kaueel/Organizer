package Screens.Login;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {
    Login login;
    @Before
    public void start(){
        login = new Login();
    }

    @Test
    public void loginUser() throws Exception {
        try{
            login.loginUser();
        }catch (NullPointerException e){

        }
    }

}