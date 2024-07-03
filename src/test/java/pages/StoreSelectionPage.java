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

public class StoreSelectionPage {
    @FindBy(xpath = "(//android.widget.Button[@resource-id='" + Setup.PACKAGE_ID + ":id/shopListItemSelect'])[1]")
    WebElement btnShopSelect;

    AndroidDriver driver;
    WebDriverWait wait;

    public StoreSelectionPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setStore() throws IOException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnShopSelect));
            btnShopSelect.click();
            wait.until(ExpectedConditions.invisibilityOf(btnShopSelect));
        } catch (Exception e) {
            System.err.println("General error occurred in set store method - " + e.getMessage());
            Utils.takeScreenShot(driver);
        }
    }
}
