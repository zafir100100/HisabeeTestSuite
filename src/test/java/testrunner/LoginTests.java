package testrunner;

import org.testng.annotations.Test;
import pages.LoginPage;
import setup.Setup;

import java.io.IOException;

public class LoginTests extends Setup {
    LoginPage loginPage;

    @Test(priority = 1, description = "Login with valid credential")
    public void LoginWithValidCredential() throws InterruptedException, IOException {
        System.out.println("Login with valid credential");
        loginPage = new LoginPage(driver);
        loginPage.doLogin("01786368387");
    }
}
