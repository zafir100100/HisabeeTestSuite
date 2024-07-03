package setup;

import io.appium.java_client.android.AndroidDriver;
import models.ApplicationConfiguration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.AppConfigLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Setup {
    public static final String PACKAGE_ID = "com.hishabee.business";

    public AndroidDriver driver;

    private DesiredCapabilities getDesiredCapabilities(models.DesiredCapabilities desiredCap) {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("appium:automationName", desiredCap.getAutomationName());
        cap.setCapability("appium:appPackage", desiredCap.getAppPackage());
        cap.setCapability("appium:appActivity", desiredCap.getAppActivity());
        cap.setCapability("appium:platformName", desiredCap.getPlatformName());
        cap.setCapability("appium:platformVersion", desiredCap.getPlatformVersion());
        cap.setCapability("appium:deviceName", desiredCap.getDeviceName());
        cap.setCapability("appium:app", desiredCap.getApp());
        cap.setCapability("appium:autoGrantPermissions", desiredCap.isAutoGrantPermissions());
        return cap;
    }

    @BeforeTest
    public AndroidDriver setUp() throws MalformedURLException {
        ApplicationConfiguration config = AppConfigLoader.getConfig();
        System.out.println("Automation Name: " + config.getDesiredCapabilities().getAutomationName());
        System.out.println("Appium Server URL: " + config.getAppiumServerUrl());

        DesiredCapabilities cap = getDesiredCapabilities(config.getDesiredCapabilities());

        URL url = new URL(config.getAppiumServerUrl() + ":" + config.getAppiumServerPort());

        driver = new AndroidDriver(url, cap);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return driver;
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}
