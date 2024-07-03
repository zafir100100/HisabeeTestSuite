package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DesiredCapabilities {
    @JsonProperty("appium:automationName")
    private String automationName;

    @JsonProperty("appium:appPackage")
    private String appPackage;

    @JsonProperty("appium:appActivity")
    private String appActivity;

    @JsonProperty("appium:platformName")
    private String platformName;

    @JsonProperty("appium:platformVersion")
    private String platformVersion;

    @JsonProperty("appium:deviceName")
    private String deviceName;

    @JsonProperty("appium:app")
    private String app;

    @JsonProperty("appium:autoGrantPermissions")
    private boolean autoGrantPermissions;
}
