package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class LoginPage {
    @FindBy(id = Setup.PACKAGE_ID + ":id/welcomeMobile")
    WebElement btnNumberInput;

    @FindBy(id = Setup.PACKAGE_ID + ":id/welcomeProceed")
    WebElement btnSubmit;

    AndroidDriver driver;
    WebDriverWait wait;

    public LoginPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void doLogin(String phoneNumber) throws IOException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnNumberInput));
            btnNumberInput.click();
            btnNumberInput.clear();
            btnNumberInput.sendKeys(phoneNumber);

            wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
            btnSubmit.click();
            wait.until(ExpectedConditions.invisibilityOf(btnSubmit));
        } catch (Exception e) {
            System.err.println("General error occurred in login method - " + e.getMessage());
            Utils.takeScreenShot(driver);
        }
    }
}
