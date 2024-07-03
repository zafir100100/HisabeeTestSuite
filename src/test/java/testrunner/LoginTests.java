package testrunner;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PinPage;
import pages.StoreSelectionPage;
import setup.Setup;

import java.io.IOException;

public class LoginTests extends Setup {
    LoginPage loginPage;
    PinPage pinPage;
    StoreSelectionPage storeSelectionPage;

    @Test(priority = 1, description = "Login with valid credential")
    public void LoginWithValidCredential() throws InterruptedException, IOException {
        System.out.println("Login with valid credential");
        loginPage = new LoginPage(driver);
        loginPage.setPhoneNumber("01786368387");
        pinPage = new PinPage(driver);
        pinPage.setPin("12345");
        storeSelectionPage = new StoreSelectionPage(driver);
        storeSelectionPage.setStore();
    }
}
