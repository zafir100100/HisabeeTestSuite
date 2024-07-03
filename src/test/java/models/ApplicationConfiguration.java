package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationConfiguration {
    @JsonProperty("desiredCapabilities")
    private DesiredCapabilities desiredCapabilities;

    @JsonProperty("appiumServerUrl")
    private String appiumServerUrl;

    @JsonProperty("appiumServerPort")
    private String appiumServerPort;
}