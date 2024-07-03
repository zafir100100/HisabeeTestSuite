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

public class PinPage {
    @FindBy(id = Setup.PACKAGE_ID+":id/loginPassword")
    WebElement btnPin;

    @FindBy(id = Setup.PACKAGE_ID+":id/loginButton")
    WebElement btnlogin;

    @FindBy(xpath = "(//android.widget.Button[@resource-id=\"com.hishabee.business:id/shopListItemSelect\"])[1]")
    WebElement btnShopSelect;

    AndroidDriver driver;
    WebDriverWait wait;

    public PinPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setPin(String pin) throws IOException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnPin));
            btnPin.click();
            btnPin.clear();
            btnPin.sendKeys(pin);

            wait.until(ExpectedConditions.elementToBeClickable(btnlogin));
            btnlogin.click();
            wait.until(ExpectedConditions.invisibilityOf(btnlogin));
        } catch (Exception e) {
            System.err.println("General error occurred in set pin method - " + e.getMessage());
            Utils.takeScreenShot(driver);
        }
    }
}
