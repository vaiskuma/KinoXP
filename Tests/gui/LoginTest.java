package gui;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mantas_MSI on 29-Sep-17.
 */
public class LoginTest {

    Login login = new Login();

    //see if it works
    @Test
    public  void Test00SeeIfWorks() throws  Exception{
        assertEquals(1, 1);
    }

    //see if it works
    @Test
    public  void Test01CheckUsernameAndPass() throws  Exception{
        String usernameAndPassword = "adminkinoXP";
        assertEquals(usernameAndPassword, login.getNameAndPassowrd());
    }

    @Test
    public  void Test02CheckLoginHasPassed() throws  Exception{
        String username = "admin";
        String password = "kinoXP";
        assertEquals(true, login.loginOk(username, password));
    }

    @Test
    public  void Test03CheckLoginHasNOTPassed() throws  Exception{
        String username = "dsadffdsf";
        String password = "kinoafafadfXP";
        assertEquals(false, login.loginOk(username, password));
    }

}